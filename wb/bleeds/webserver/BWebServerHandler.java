package wb.bleeds.webserver;

import pisi.unitedmeows.yystal.clazz.ref;
import pisi.unitedmeows.yystal.networking.advanced.server.YServerNetworkHandler;
import pisi.unitedmeows.yystal.networking.advanced.server.YSocketChannel;
import test.yystal.stuff.YTestPipeline;

public class BWebServerHandler extends YServerNetworkHandler {

    @Override
    public void channelInitialize(YSocketChannel channel, ref<Boolean> allowed) {
        try {
            channel.hooked().setTcpNoDelay(true);
            channel.hooked().setReuseAddress(true);
        } catch (Exception var4) {
        }

        System.out.println("someone connected and now initializing");
        channel.pipeline().put("handler", new BWebServerPipeline());
    }
}
