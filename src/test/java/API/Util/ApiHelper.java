package API.Util;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;

public class ApiHelper {

    public JsonPath RawToJson(String apiResponse) {
        JsonPath responseJson = new JsonPath(apiResponse);
        return responseJson;
    }

    public String graphqlToJson(String payload)
    {
        JSONObject json = new JSONObject();
        json.put("query",payload);
        return  json.toString();
    }
}
