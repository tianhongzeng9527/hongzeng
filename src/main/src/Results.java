import certificate.WechatHttpsResponse;

/**
 * Created by user on 2015/11/17.
 */
public class Results {
    public String getResults(String url, String path) {
        String results = "";
        WechatHttpsResponse wechatHttpsResponse = new WechatHttpsResponse();
        try {
            results = wechatHttpsResponse.httpsGetRequest(url, null);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        WriteToFile writeToFile = new WriteToFile(path+""+ this.getClass().toString() + ".txt", results);
        writeToFile.writeFile();
//        System.out.print(results);
        return results;
    }

    public static void main(String[] args){
        Results results = new Results();
        results.getResults("http://baike.baidu.com/subview/29/12654100.htm", "");
    }
}
