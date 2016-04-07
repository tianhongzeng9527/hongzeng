import certificate.WechatHttpsResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 2015/11/12.
 */
public class Groups {
    private double lat;
    private double lon;
    private int categoriesId;
    private String results;
    private String url1 = "https://api.meetup.com/2/groups?offset=0&format=json&lon=%s&category_id=2&photo-host=public&page=500&radius=25.0&fields=&lat=%s&order=id&desc=false&sig_id=195116585&sig=4168be093f430013a86c443c4393e7915a13179c";
    private String path;
    private Set<Long> groupId;

    Groups(double lat, double lon, int categoriesId) {
        this.path = "D://groups//1//";
        this.lat = lat;
        this.lon = lon;
        this.results = "";
        this.categoriesId = categoriesId;
        this.url1 = "https://api.meetup.com/2/groups?&sign=true&photo-host=public&lat=%s&lon=%s&category_id=%s&page=500&key=1f523d455f721ae65266f441b3f405d";
        this.url1 = String.format(url1, lat, lon, categoriesId);
        this.groupId = new HashSet<Long>();
        System.out.println(this.url1);
    }

    public Set<Long> getGroupId() {
        try{
            Results result = new Results();
            results = result.getResults(url1, path + lat+" "+lon+" "+categoriesId);
            JSONObject jsonObject = new JSONObject(results);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                groupId.add(jsonArray.getJSONObject(i).getLong("id"));
            }
        }
        catch (Exception e){
            System.out.print("wrogonff");
        }
        return groupId;
    }


    public static void main(String[] args) {
        Groups groups = new Groups(49.0, -123.0, 2);
        groups.getGroupId();
    }
}
