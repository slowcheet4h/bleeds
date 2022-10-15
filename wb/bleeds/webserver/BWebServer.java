package wb.bleeds.webserver;

import pisi.unitedmeows.yystal.networking.advanced.server.YServerChannel;
import pisi.unitedmeows.yystal.networking.advanced.server.YServerChannelBuilder;
import pisi.unitedmeows.yystal.networking.simple.server.YTcpServer;

public class BWebServer {


    private YServerChannel tcpServer;
    private BWebServerConfig config;

    protected BWebServer(BWebServerConfig _config) {
        config = _config;
    }

    public BWebServer run() {
        tcpServer = YServerChannelBuilder.create().build()
                .handler(new BWebServerHandler()).bind(config.host, config.port);

        return this;
    }

}

