package PayloadPackage;
import io.restassured.path.json.JsonPath;
public class ReusableMethods {
	public static JsonPath returnJsonPath(String response) {
		JsonPath js= new JsonPath(response);
		return js;
	}

}
