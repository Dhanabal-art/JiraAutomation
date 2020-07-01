package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonParse {
	public static String getvalues(Response res,String key)
	{
		JsonPath js=res.jsonPath();
		String value=js.get(key);
		return value;
	}

}
