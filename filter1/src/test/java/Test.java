import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

/**
 * Created by tian on 16-3-16.
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("tianhongzeng");
        Mongo mongo = new Mongo();
        DB db = mongo.getDB("tianhongzeng");
        DBCollection events = db.getCollection("memberInformation5211");
        DBCursor dbObjects = events.find();
        System.out.println(dbObjects.next().toString());
        System.out.println(dbObjects.next().toString());
        System.out.println(dbObjects.next().toString());
        System.out.println(dbObjects.next().toString());
    }
}
