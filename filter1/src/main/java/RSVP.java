/**
 * Created by user on 2015/12/1.
 */
public class RSVP {
    private String url = "https://api.meetup.com/2/rsvps?&sign=true&photo-host=public&event_id=%s&key=1f523d455f721ae65266f441b3f405d";
    private String eventId;
    private String path;

    RSVP(String eventId) {
        this.path = "/home/tian/RSVP/";
        this.eventId = eventId;
        url = String.format(url, eventId);
    }

    public String getResults() {
        Results result = new Results();
        return  result.getResults(url, path + eventId);
    }
}
