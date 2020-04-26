
package DemoPackage;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import PayloadPackage.AddPlacePayload;

public class AddPlace {

	
	public static void main(String[] args) {
	RestAssured.baseURI="https://rahulshettyacademy.com/";
	/*given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body(AddPlacePayload.AddPlace()).when().post("maps/api/place/add/json")
	          .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
	          .header("Server", "Apache/2.4.18 (Ubuntu)");*/
	
	String resbody=given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body(AddPlacePayload.AddPlace()).when().post("maps/api/place/add/json")
	          .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
	          .header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	System.out.println(resbody);
		

	}

}
