package server.classes;

import org.json.JSONArray;
import org.json.JSONObject;

public class DefaultResponse {
    public static JSONObject body = new JSONObject("{\"result\":"+new JSONObject("{\"status\": \"\",\"data\":"+new JSONArray()+"}")+"}");
}
