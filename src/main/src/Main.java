import certificate.WechatHttpsResponse;

import java.net.UnknownHostException;

/**
 * Created by user on 2015/11/12.
 */
public class Main {

    private static double lat = 36;
    private static double lon = -122;

    public static void main(String[] args) {
        System.out.println("ff");
        Main main = new Main();
        for (int i = 0; i < 10; i++) {
            lat += 0.2;
            lon = -122;
            try {
                for (int j = 0; j < 10; j++) {
                    lon -= 0.2;
                    main.resolve();
                }
            } catch (Exception e) {
                System.out.println("wrong");
            }
        }
    }

    Main() {
    }

    void resolve() throws UnknownHostException {
        Handle handle = new Handle(lat, lon);
        handle.handle2();
    }

}
