package certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author hongzeng.tian
 * @date 2015/9/2
 */
public class WechatHttpsInputStream {
    private static final int TIMEOUT = 10000;

    public InputStream httpsPostRequest(String requestUrl, String outputStr) throws Exception {
        return httpsRequest(requestUrl, "POST", outputStr);
    }

    public InputStream httpsGetRequest(String requestUrl, String outputStr) {
        try {
            return httpsRequest(requestUrl, "GET", outputStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private InputStream httpsRequest(String requestUrl, String requestMethod, String outputStr) throws Exception {
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
            return httpUrlConn.getInputStream();
        } finally {
            close(outputStream);
            if (httpUrlConn != null)
                httpUrlConn.disconnect();
        }
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
