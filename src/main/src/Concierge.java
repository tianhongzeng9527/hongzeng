/**
 * Created by user on 2015/11/14.
 */
public class Concierge {
    private String results;
    private double lat;
    private double lon;
    private String path = "d://";
    private String url = "https://api.meetup.com/2/concierge?offset=0&format=json&lon=%f&photo-host=public&page=500&lat=%f&sig_id=195116585&sig=6bc1e2c5d2704e0a476bced1e489d6a84c7ba957";
    Concierge(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
        String.format(url,lon,lat);
    }

    public String getResults(){
        Results r = new Results();
        r.getResults(url,path);
        return results;
    }
}
