import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/11/14.
 */
public class Event {
    private String url = "https://api.meetup.com/2/open_events?&sign=true&photo-host=public&lat=%s&category=%s&lon=%s&key=1f523d455f721ae65266f441b3f405d&status=past&fields=rsvp_sample,event_hosts";
    private int category;
    private List<String> ids;
    private String results;
    private String path;
    private double lat;
    private double lon;

    Event(double lat, double lon, int category) {
        this.lat = lat;
        this.lon = lon;
        this.path = "/home/tian/event/";
        this.category = category;
        ids = new ArrayList<String>();
        url = String.format(url,lat,category,lon);
    }

    public List<String> getMemberId() {
        try {
            Results result = new Results();
            System.out.println(url);
            results = result.getResults(url, path + category+" "+lat+" "+lon);
            JSONObject jsonObject = new JSONObject(results);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                ids.add(jsonArray.getJSONObject(i).get("id").toString());
            }
        } catch (Exception e) {
            System.out.println(category + "wrong");
        }
        return ids;
    }

}
