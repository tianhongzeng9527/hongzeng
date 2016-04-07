package certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author hongzeng.tian
 * @date 2015/9/2
 */
public class WechatHttpsResponse {
    private static final int TIMEOUT = 1000000;

    public String httpsPostRequest(String requestUrl, String outputStr) throws Exception {
        return httpsRequest(requestUrl, "POST", outputStr);
    }

    public String httpsGetRequest(String requestUrl, String outputStr) throws Exception {
        return httpsRequest(requestUrl, "GET", outputStr);
    }

    private String httpsRequest(String requestUrl, String requestMethod, String outputStr) throws Exception {
        StringBuffer buffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        HttpsURLConnection httpUrlConn = null;
        OutputStream outputStream = null;
        try {
            TrustManager[] tm = { new Wechat509TrustManger() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            httpUrlConn = (HttpsURLConnection) new URL(requestUrl).openConnection();
            configureUrlCon(httpUrlConn, sslContext.getSocketFactory(), requestMethod);
            if ("GET".equalsIgnoreCase(requestMethod) || "get".equals(requestMethod)) {
                httpUrlConn.connect();
            }
            if (null != outputStr) {
                outputStream = httpUrlConn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));

            }
            bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream(), "UTF-8"));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
        } finally {
            close(bufferedReader);
            close(outputStream);
            if (httpUrlConn != null)
                httpUrlConn.disconnect();
        }
        return buffer.toString();
    }

    private void configureUrlCon(HttpsURLConnection httpUrlConn, SSLSocketFactory ssf, String requestMethod)
            throws ProtocolException {
        httpUrlConn.setSSLSocketFactory(ssf);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);
        httpUrlConn.setUseCaches(false);
        httpUrlConn.setRequestMethod(requestMethod);
        httpUrlConn.setConnectTimeout(TIMEOUT);
        httpUrlConn.setReadTimeout(TIMEOUT);
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
