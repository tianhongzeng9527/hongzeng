import certificate.WechatHttpsResponse;

/**
 * Created by user on 2015/11/17.
 */
public class Groups {
    String url = "https://api.meetup.com/2/events?&sign=true&photo-host=public&member_id=%s&status=past&page=200&key=1f523d455f721ae65266f441b3f405d";

    public String getResults(String id) {
        url = String.format(url, id);
        String results = "";
        WechatHttpsResponse wechatHttpsResponse = new WechatHttpsResponse();
        try {
            results = wechatHttpsResponse.httpsGetRequest(url, null);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return results;
    }

    public static void main(String[] args) {
        Results results = new Results();
        results.getResults("http://baike.baidu.com/subview/29/12654100.htm", "");
    }
}
