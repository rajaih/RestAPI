package PayloadPackage;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticBook {
	@Test
	public void addBook() throws IOException {
		
		  
			  RestAssured.baseURI="http://216.10.245.166";
			  String response= given().header("Content-Type", "application/json")
			  .body(generateString("E:\\2020\\UDMEY\\Library-api\\Addbook.json"))
			  .when().post("/Library/Addbook.php")
			  .then().assertThat().statusCode(200)
			  .extract().response().asString();
			  JsonPath js= ReusableMethods.returnJsonPath(response);
			  String id= js.get("ID");
			  System.out.println(id);
	}
public static String generateString(String path) 
		throws IOException { 
return new String(Files.readAllBytes(Paths.get(path)));


}
}
