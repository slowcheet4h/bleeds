package wb.bleeds.webserver;

import pisi.unitedmeows.yystal.networking.IPAddress;

public class BWebServerBuilder {

    private BWebServerConfig config;

    protected BWebServerBuilder() {
        config = new BWebServerConfig();
    }

    public static BWebServerBuilder create() {
        return new BWebServerBuilder();
    }

    public BWebServerBuilder port(int port) {
        config.port = port;
        return this;
    }

    public BWebServerBuilder host(IPAddress host) {
        config.host = host;
        return this;
    }

    public BWebServer build() {
        return new BWebServer(config).run();
    }
}
