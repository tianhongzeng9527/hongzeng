import com.mongodb.*;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/11/12.
 */
public class Handle {

    private double lat;
    private double lon;
    private List<Integer> categoriesId;
    private List<Long> groupsId;
    private List<String> membersId;
    private List<String> eventsId;

    Handle(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        eventsId = new ArrayList<String>();
        membersId = new ArrayList<String>();
        categoriesId = new ArrayList<Integer>();
        groupsId = new ArrayList<Long>();
    }

    void handle() {
        Categories categories = new Categories();
        categoriesId = categories.getCategoriesId();
        for (int i = 0; i < categoriesId.size(); i++) {
            Groups groups = new Groups(lat, lon, categoriesId.get(i));
            groupsId.addAll(groups.getGroupId());
        }
        for (Long groupId : groupsId) {
            System.out.println(groupId);
            Members members = new Members(groupId);
            membersId.addAll(members.getMemberId());
        }
    }

    void handle2() throws UnknownHostException {
        for (int i = 1; i <= 35; i++) {
            Event event = new Event(lat, lon, i);
            eventsId.addAll(event.getMemberId());
//            event.getMemberId();
        }
//        Mongo mongo = new Mongo();
//        DB db = mongo.getDB("tianhongzeng");
//        DBCollection eventAndMemId = db.getCollection("eventAndMemId");
        for (String s : eventsId) {
            RSVP rsvp = new RSVP(s);
            String re = rsvp.getResults();
//            JSONObject jsonObject = new JSONObject(re);
//            DBObject insertDBObject = new BasicDBObject();
//            insertDBObject.put("event",s);
//            insertDBObject.put("member",jsonObject.get("results"));
//            eventAndMemId.save(insertDBObject);
//            System.out.println(insertDBObject);
        }
    }

    void handle3(){

    }
}
