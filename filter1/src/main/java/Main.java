
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;
//{ "id" : 13104911

/**
 * Created by tian on 16-1-5.
 */
public class Main implements Runnable {
    public static Set<Integer> set = new HashSet<Integer>();

    int a = 0;

    public Main(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws UnknownHostException, JSONException {
        System.out.println("ff");
        String path = "/home/tian/event";
        File file = new File(path);
        File[] files = file.listFiles();
        Mongo mongo = new Mongo();
        DB db = mongo.getDB("tianhongzeng");
        DBCollection categorys = db.getCollection("categorys");
        DBCollection events = db.getCollection("events");
        DBCollection groups = db.getCollection("groups");
        DBCollection members = db.getCollection("members2");
        DBCollection memberConnectEvent = db.getCollection("memberConnectEvent");
        DBCollection RSVP = db.getCollection("RSVP");
        DBCollection events2 = db.getCollection("events2");
        DBObject query1 = new BasicDBObject("id", "228533881");
        DBCollection memberInformation = db.getCollection("memberInformation");
        DBCollection memberInformation4 = db.getCollection("memberInformation51");
        DBCursor cur = members.find();
        cur.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
        System.out.println(cur.next());
        DBCursor cur2 = events.find(query1);
        System.out.println(cur2.next());
        DBCursor cur3 = memberInformation.find();
        System.out.println(cur3.next());
        System.out.println(cur.count());
        System.out.println(memberInformation4.find().count());
        while (cur.hasNext()) {
            //这个是初始化人物属性
            try {
                DBObject dbobject = cur.next();
//                System.out.println(dbobject.toString());
                set.add((Integer) dbobject.get("id"));
//                System.out.println(dbobject.get("id").getClass());
                System.out.println(set.size() / (double) cur.count());
////            events.remove(dbobject);
//                System.out.println(dbobject.get("id").getClass());
//                DBObject insertDBObject = new BasicDBObject();
//                insertDBObject.put("id",dbobject.get("id"));
//                insertDBObject.put("lat",dbobject.get("lat"));
//                insertDBObject.put("lon",dbobject.get("lon"));
//                insertDBObject.put("topic",dbobject.get("topics"));
//                Events es = new Events();//这个其实是组，写倒名字了这两个
//                String results = es.getResults(dbobject.get("id").toString());
//                JSONObject json1 = new JSONObject(results);
//                JSONArray groupsId = json1.getJSONArray("results");
//                List<String> groups_id = new ArrayList<String>();
//                for(int i = 0; i < groupsId.length(); i++){
//                    groups_id.add(groupsId.getJSONObject(i).get("id").toString());
//
//                }
//                Groups gs = new Groups();//这个其实是事件
//                String resultsGs = gs.getResults(dbobject.get("id").toString());
//                JSONObject json2 = new JSONObject(resultsGs);
//                JSONArray eventsId = json2.getJSONArray("results");
//                List<String> events_id = new ArrayList<String>();
//                for(int i = 0; i < eventsId.length(); i++){
//                    events_id.add(eventsId.getJSONObject(i).get("id").toString());
//                }
//                insertDBObject.put("groups",groups_id);
//                insertDBObject.put("events",events_id);
//                System.out.println(insertDBObject);
//                memberInformation4.save(insertDBObject);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.print(set.size());
//        System.out.println(cur.count());
//        while (cur.hasNext()) {
//            DBObject dbObject = cur.next();
//            DBObject insertDBObject = new BasicDBObject();
//            insertDBObject.put("id", dbObject.get("id"));
//            insertDBObject.put("lat", dbObject.get("venue.lat"));
//            insertDBObject.put("lon", dbObject.get("venue.lon"));
//            insertDBObject.put("description", dbObject.get("description"));
//            insertDBObject.put("event_host",dbObject.get("event_hosts"));
//            insertDBObject.put("group",dbObject.get("group"));
//            insertDBObject.put("time",dbObject.get("time"));
//            RSVP rsvp = new RSVP(dbObject.get("id").toString());
//            String re = rsvp.getResults();
//            JSONObject jsonObject = new JSONObject(re);
//            insertDBObject.put("member",jsonObject.get("results"));
//            memberConnectEvent.save(insertDBObject);
//            System.out.println(insertDBObject);
//        }
//        System.out.println(memberConnectEvent.find().count());
//        while (cur.hasNext()) {
//            DBObject dbObject = cur.next();
//            long id = Long.valueOf(dbObject.get("id").toString());
//            DBObject insertDBObject = new BasicDBObject();
//            insertDBObject.put("id",dbObject.get("id"));
//            insertDBObject.put("lat",dbObject.get("lat"));
//            insertDBObject.put("lon",dbObject.get("lon"));
//            insertDBObject.put("topic",dbObject.get("topic"));
//            DBCursor cur2 = events2.find(new BasicDBObject("members.member.member_id",id));
//            Set<String> list = new HashSet<String>();
//            while(cur2.hasNext()){
//                list.add(cur2.next().get("id").toString());
//            }
//            insertDBObject.put("event",list);
//            System.out.println(insertDBObject);
//            memberConnectEvent.save(insertDBObject);
//        }
//        System.out.println(cur.count());
//        while (cur.hasNext()){
//            DBObject dbObject = cur.next();
////            System.out.println(dbObject.get("id"));
////            System.out.println(dbObject.get("time"));
////            System.out.println(dbObject.get("venue"));
////            System.out.println(dbObject.get("description"));
////            System.out.println(dbObject.get("group"));
////            events.remove(dbObject);
//            System.out.println(dbObject);
//            DBObject insertDBObject = new BasicDBObject();
//            insertDBObject.put("id",dbObject.get("id"));
//            insertDBObject.put("time",dbObject.get("time"));
//            insertDBObject.put("venue",dbObject.get("venue"));
//            insertDBObject.put("description",dbObject.get("description"));
//            insertDBObject.put("group",dbObject.get("group"));
//            DBCursor cur2 = RSVP.find(new BasicDBObject("event.id",dbObject.get("id")));
//            List<DBObject> list = new ArrayList<DBObject>();
//            while(cur2.hasNext()){
//                DBObject dbObject1 = cur2.next();
//                list.add(dbObject1);
//            }
//            insertDBObject.put("members",list);
//            events2.save(insertDBObject);
////            System.out.println(cur2.next().toString());
////            System.out.println(cur2.next().get("member").toString());
//        }
//        System.out.println(events2.find().count());
//        DBObject dbObject = cur.next();
//        System.out.println(dbObject.get("id"));
//        System.out.println(dbObject.get("time"));
//        System.out.println(dbObject.get("venue"));
//        System.out.println(dbObject.get("description"));
//        System.out.println(dbObject.get("group"));
////            events.remove(dbObject);
//        System.out.println(dbObject);
//        DBObject insertDBObject = new BasicDBObject();
//        insertDBObject.put("id", dbObject.get("id"));
//        insertDBObject.put("time", dbObject.get("time"));
//        insertDBObject.put("venue", dbObject.get("venue"));
//        insertDBObject.put("description", dbObject.get("description"));
//        insertDBObject.put("group", dbObject.get("group"));
//        DBCursor cur2 = RSVP.find(new BasicDBObject("event.id", dbObject.get("id")));
//        List<String> list = new ArrayList<String>();
//        while (cur2.hasNext()) {
//            list.add(cur2.next().toString());
//        }
//        insertDBObject.put("members", list);
//        System.out.println(insertDBObject.toString());
//        for(int i = 0; i < files.length; i++){
//        //组属性初始化函数
//            if(files[i].isFile()){
//                System.out.println(files[i].getName());
//                BufferedReader bufferedReader = null;
//                try {
//                    bufferedReader = new BufferedReader(new FileReader(files[i]));
//                    JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
//                    JSONArray jsonObject1 = jsonObject.getJSONArray("results");
//                    for(int j = 0; j < jsonObject1.length(); j++){
//                        DBObject dbObject =(DBObject) JSON.parse(jsonObject1.get(j).toString());
////                        System.out.println(dbObject);
////                        events.save(dbObject);
//                        try{
//                            String id = dbObject.get("id").toString();
//                            String time = dbObject.get("time").toString();
//                            String name = dbObject.get("name").toString();
//                            JSONObject jsonObject2 = new JSONObject(dbObject.get("venue").toString());
//                            String lat = jsonObject2.get("lat").toString();
//                            String lon = jsonObject2.get("lon").toString();
//                            JSONArray event_hosts = new JSONArray(dbObject.get("event_hosts").toString());
////                            System.out.println(event_hosts);
//                            List<String> eventhosts = new ArrayList<String>();
//                            for(int m = 0; m < event_hosts.length(); m++){
//                                eventhosts.add(event_hosts.getJSONObject(m).get("member_id").toString());
////                                System.out.println(event_hosts.getJSONObject(m).get("member_id"));
//                            }
////                            System.out.println(lat+"  "+lon);
//                            String description = dbObject.get("description").toString();
////                            System.out.println(description);
//                            RSVP rsvp = new RSVP(id);
//                            String re = rsvp.getResults();
//                            JSONObject jsonObject3 = new JSONObject(re);
//                            JSONArray result = jsonObject3.getJSONArray("results");
//                            List<String> membersId = new ArrayList<String>();
//                            for(int k = 0; k < result.length(); k++){
//                                membersId.add(result.getJSONObject(k).getJSONObject("member").get("member_id").toString());
//                            }
//                            String group = new JSONObject(dbObject.get("group").toString()).get("id").toString();
//                            DBObject insertDBObject = new BasicDBObject();
//                            insertDBObject.put("id",id);
//                            insertDBObject.put("time",time);
//                            insertDBObject.put("lat",lat);
//                            insertDBObject.put("lon",lon);
//                            insertDBObject.put("event_hosts",eventhosts);
//                            insertDBObject.put("name",name);
//                            insertDBObject.put("description",description);
//                            insertDBObject.put("members",membersId);
//                            insertDBObject.put("group",group);
//                            System.out.println(insertDBObject);
//                            DBObject query2= new BasicDBObject("id", id);
//                            if(events.find(query2).count() < 1){
//                                events.save(insertDBObject);
//                            }
//                            else{
//                                System.out.println(id);
//                            }
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//
//                    }
//                } catch (FileNotFoundException e) {
//                    System.out.println(e + files[i].getName());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                } finally {
//                    if(bufferedReader!=null){
//                        try {
//                            bufferedReader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
        Main[] mains = new Main[11];
        for (int i = 0; i < 11; i++) {
            mains[i] = new Main(i);
            mains[i].setA(i);
        }
        Thread[] threads = new Thread[11];
        for (int i = 0; i < 11; i++) {
            threads[i] = new Thread(mains[i]);
        }
        for (int i = 0; i < 11; i++) {
            threads[i].start();
        }
    }

    public void setA(int a) {
        this.a = a;
    }

    public void run() {
        Mongo mongo = null;
        try {
            mongo = new Mongo();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB db = mongo.getDB("tianhongzeng");
        DBCollection dbCollection = db.getCollection("memberInformation5");
        ArrayList list = new ArrayList(set);
        int max = 30000 * (a + 1) > set.size() ? set.size() : 30000 * (a + 1);
        Set<Integer> set1 = new HashSet(list.subList(0 + 30000 * a, max));
        System.out.println(set1.size());
        DBCollection members = db.getCollection("members2");
        DBCollection memberInformation4 = db.getCollection("memberInformation521" + a);
        int size = 0;
        for (int a : set1) {
            size ++;
            try {
                //            DBObject query1 = new BasicDBObject("id", String.valueOf(a));
//            if(dbCollection.find(query1).count() > 0){
//                System.out.println(dbCollection.find(query1).next().toString());
//            }
                DBObject query2 = new BasicDBObject("id", a);
                if (dbCollection.find(query2).count() > 0) {
//                System.out.println(dbCollection.find(query2).next().toString());
                    continue;
                }
//                continue;
                DBObject query = new BasicDBObject("id", a);
                DBCursor cur = members.find(query);
                cur.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
                DBObject dbobject = cur.next();
                DBObject insertDBObject = new BasicDBObject();
                insertDBObject.put("id", dbobject.get("id"));
                insertDBObject.put("lat", dbobject.get("lat"));
                insertDBObject.put("lon", dbobject.get("lon"));
                insertDBObject.put("topic", dbobject.get("topics"));
                Events es = new Events();//这个其实是组，写倒名字了这两个
                String results = es.getResults(dbobject.get("id").toString());
                JSONObject json1 = new JSONObject(results);
                JSONArray groupsId = json1.getJSONArray("results");
                List<String> groups_id = new ArrayList<String>();
                for (int i = 0; i < groupsId.length(); i++) {
                    groups_id.add(groupsId.getJSONObject(i).get("id").toString());

                }
                Groups gs = new Groups();//这个其实是事件
                String resultsGs = gs.getResults(dbobject.get("id").toString());
                JSONObject json2 = new JSONObject(resultsGs);
                JSONArray eventsId = json2.getJSONArray("results");
                List<String> events_id = new ArrayList<String>();
                for (int i = 0; i < eventsId.length(); i++) {
                    events_id.add(eventsId.getJSONObject(i).get("id").toString());
                }
                insertDBObject.put("groups", groups_id);
                insertDBObject.put("events", events_id);
                System.out.println("fff" + insertDBObject);
                System.out.println(size / (double)set1.size());
                try {
                    Thread.sleep(7600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                memberInformation4.save(insertDBObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
