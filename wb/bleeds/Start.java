package wb.bleeds;

import pisi.unitedmeows.yystal.networking.IPAddress;
import pisi.unitedmeows.yystal.utils.kThread;
import wb.bleeds.webserver.BWebServer;
import wb.bleeds.webserver.BWebServerBuilder;

public class Start {

    public static void main(String[] args) {
        BWebServer webServer = BWebServerBuilder.create()
                .host(IPAddress.ANY)
                .port(7772)
                .build();

        kThread.sleep(1000000);
    }
}
