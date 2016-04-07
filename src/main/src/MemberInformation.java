import certificate.WechatHttpsResponse;

/**
 * Created by user on 2015/11/12.
 */
public class MemberInformation {
    private String url = "https://api.meetup.com/2/member/%s?&sign=true&photo-host=public&key=1f523d455f721ae65266f441b3f405d";
    private String results;
    private String memberId;
    private String path;

    MemberInformation(String memberId) {
        this.memberId = memberId;
        this.path = "D://member2//";
        this.url = String.format(url, memberId);
        System.out.println(url);
    }

    public void getResults() {
        Results result = new Results();
        results = result.getResults(url, path + memberId);
    }
}
