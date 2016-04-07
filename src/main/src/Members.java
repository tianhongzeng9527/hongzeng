import certificate.WechatHttpsResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/11/12.
 */
public class Members {
    private String url = "https://api.meetup.com/2/members?&sign=true&photo-host=public&group_id=%s&key=1f523d455f721ae65266f441b3f405d";
    private long groupId;
    private List<String> memberId;
    private String results;
    private String path;
    Members(long groupId) {
        this.path = "D://members2//";
        this.groupId = groupId;
        memberId = new ArrayList<String>();
        System.out.println(groupId+"  "+this.groupId);
        System.out.println("gggg"+url);
        this.url = String.format(url, groupId);
        System.out.println("fff"+url);
    }

    public List<String> getMemberId() {
        try{
            Results result = new Results();
            System.out.println(url);
            results = result.getResults(url, path+ groupId);
            JSONObject jsonObject = new JSONObject(results);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++){
                memberId.add(jsonArray.getJSONObject(i).get("id").toString());
            }
        }
        catch (Exception e){
            System.out.println(memberId+"wrong");
        }
        return memberId;
    }
}
