package DemoPackage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
import PayloadPackage.AddPlacePayload;
import io.restassured.common.exception.*;
import io.restassured.path.json.JsonPath;

public class EndToEnd {

	public static void main(String[] args)throws PathException {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
	String resbody= given().log().all().queryParams("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(AddPlacePayload.AddPlace())
			.when().post("maps/api/place/add/json")
			.then().extract().response().asString();
	System.out.println(resbody);
	JsonPath jp = new JsonPath(resbody);
	String placeID= jp.getString("place_id");
	System.out.println("*******placeID******"+placeID+"********");
	
	
	

	}

}
