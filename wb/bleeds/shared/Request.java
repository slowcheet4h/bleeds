package wb.bleeds.shared;

import wb.bleeds.shared.RequestType;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private RequestType type;
    private String location;
    private Map<String, String> headers;

    public Request(RequestType _type, String _location) {
        type = _type;
        location = _location;
        headers = new HashMap<>();
    }

    public Map<String, String> headers() {
        return headers;
    }

    public String location() {
        return location;
    }

    public RequestType type() {
        return type;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Request{");
        sb.append("type=").append(type);
        sb.append(", location='").append(location).append('\'');
        sb.append(", headers=").append(headers);
        sb.append('}');
        return sb.toString();
    }
}
