package DemoPackage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

import PayloadPackage.*;
import io.restassured.common.exception.*;
import io.restassured.path.json.JsonPath;
public class PutPlace {

	public static void main(String[] args) throws PathException {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String resbody= given().log().all().queryParams("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(AddPlacePayload.AddPlace())
				.when().post("maps/api/place/add/json")
				.then().extract().response().asString();
		System.out.println(resbody);
		JsonPath jp = new JsonPath(resbody);
		String placeID= jp.getString("place_id");
		
		String addNew = "PeaceFul Home Affection limitless 1/0";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeID+"\",\r\n" + 
				"\"address\":\""+addNew+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"")
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		String addActual = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeID)
				.when().get("maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200)
				.extract().body().asString();
		JsonPath js2= ReusableMethods.returnJsonPath(addActual);
		String addActual2= js2.getString("address");
		System.out.println(addActual2);
		Assert.assertEquals(addNew, addActual2);
		System.out.println("After testng assert");
		
		
		
		

	}

}
