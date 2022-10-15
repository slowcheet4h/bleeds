package wb.bleeds.shared;

public enum RequestType {
    GET("GET"),
    POST("POST");

    private String reqName;
    RequestType(String _reqName) {
        reqName = _reqName;
    }

    public String reqName() {
        return reqName;
    }
}
