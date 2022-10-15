package wb.bleeds.parser.html;

import pisi.unitedmeows.yystal.utils.MemoryReader;
import wb.bleeds.shared.Request;
import wb.bleeds.shared.RequestType;

import java.io.IOException;
import java.util.HashMap;

public class RequestParser {

    private HashMap<String, String> headers;


    public Request parse(MemoryReader reader) throws IOException {
        boolean lastLineWasEmpty = false;
        String line;

        /* getting request type and location */
        line = reader.readLine();

        if (!line.contains(" ")) {
            return null;
        }
        final String[] split = line.split(" ");
        String req = split[0];
        Request request = null;
        for (RequestType type : RequestType.values()) {
            if (type.reqName().equalsIgnoreCase(req)) {
                final String location = split[1];
                request = new Request(type, location);
            }
        }

        while ((line = reader.readLine()) != null) {

            if (line.isEmpty()) {
                break;
            }

            if (!line.contains(" ")) {
                break;
            }
            int splitIndex = line.indexOf(" ");
            final String headerName = line.substring(0, splitIndex);
            final String headerValue = line.substring(splitIndex + 1);
            request.headers().put(headerName, headerValue);
        }

        return request;
    }
}
