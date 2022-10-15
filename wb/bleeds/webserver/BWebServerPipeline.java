package wb.bleeds.webserver;

import pisi.unitedmeows.yystal.networking.advanced.server.pipeline.YServerChannelDataIn;
import pisi.unitedmeows.yystal.utils.MemoryReader;
import stelix.xfile.SxfBlockBuilder;
import stelix.xfile.WriteStyle;
import test.yystal.stuff.YTestPipeline;
import wb.bleeds.parser.html.RequestParser;
import wb.bleeds.shared.Request;

import java.io.IOException;
import java.util.Map;

public class BWebServerPipeline extends YServerChannelDataIn {

    static int times = 0;

    @Override
    public void receiveDataHandler(MemoryReader reader) throws IOException {
        RequestParser requestParser = new RequestParser();
        Request request;
        try {
            request = requestParser.parse(reader);
        } catch (Exception ex) {
            request = null;
            ex.printStackTrace();
        }
        if (request == null) {
            channel.kick();
        }

        final String CLRF = "\n\r";

        String body;
        SxfBlockBuilder builder = SxfBlockBuilder.create().setStyle(WriteStyle.NORMAL);
        for (Map.Entry<String, String> entry : request.headers().entrySet()) {
            builder.variable(entry.getKey(), entry.getValue());
        }
        System.out.println(request.location());
        builder = builder.buildBlock();
        body = builder.toString().replace("\n", "<br>");


        final String page = "<html><body>" + body + "<br>" + times +  "<br>" + request.location()  +"</body></html>";
        String response =  "HTTP/1.1 200 OK" + CLRF +
                "Content-Length:" + page.getBytes().length + CLRF +
                CLRF +
                page +
                CLRF + CLRF;

        /* Write the data */
        channel.writer().write(response.getBytes());

        /* Close the connection */
        channel.kick();
        times++;

    }
}
