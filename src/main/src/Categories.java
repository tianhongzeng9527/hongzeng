import certificate.WechatHttpsResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/11/12.
 */
public class Categories {

    private static String url = "https://api.meetup.com/2/categories?&sign=true&photo-host=public&key=1f523d455f721ae65266f441b3f405d";
    String results = "";
    String path = "";
    Categories() {
        path = "d://categorys//";
    }


    public List<Integer> getCategoriesId() {
        Results result = new Results();
        results = result.getResults(url, path);
        JSONObject jsonObject = new JSONObject(results);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        List<Integer> id = new ArrayList<Integer>();
        for (int i = 0; i < jsonArray.length(); i++) {
            id.add(jsonArray.getJSONObject(i).getInt("id"));
        }
        return id;
    }

}
