package DemoPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayloadPackage.AddPlacePayload;
import PayloadPackage.ReusableMethods;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class LibraryAPI {
  @Test(dataProvider="Booksdata")
  public void f(String isbn, String aisle) {
	  RestAssured.baseURI="http://216.10.245.166";
	  String response= given().header("Content-Type", "application/json")
	  .body(AddPlacePayload.addBook(isbn,aisle))
	  .when().post("/Library/Addbook.php")
	  .then().assertThat().statusCode(200)
	  .extract().response().asString();
	  JsonPath js= ReusableMethods.returnJsonPath(response);
	  String id= js.get("ID");
	  System.out.println(id);
	  
	  given().header("Content-Type", "application/json")
	  .body(AddPlacePayload.deleteBook(isbn, aisle))
	  .when().post("/Library/DeleteBook.php")
	  .then().assertThat().statusCode(200);
	  System.out.println("all books removed");
			  
			  
	 
	  }
  @DataProvider(name="Booksdata")
  public Object[][] getData(){
	  return  new Object[][]  {{"qlllg","q123446"},{"qaaag","q56798j"},{"qttt","q3454"}};
	  
	  
  }
}
