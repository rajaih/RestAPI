package DemoPackage;

//import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import PayloadPackage.AddPlacePayload;
import io.restassured.path.json.JsonPath;

public class ApiPriceValidation {
	int sum1 = 0;
  @Test
  public void f() {
	  JsonPath js= new JsonPath(AddPlacePayload.courseRes());
	  int csize= js.getInt("courses.size()");
	  for ( int i =0;i<csize;i++) {
			String ctitle= js.get("courses["+i+"].title");
			
			int price= js.get("courses["+i+"].price");
			int copies= js.get("courses["+i+"].copies");
			int amt= copies*price;
			sum1= sum1+amt;
			
			
			
		}
		System.out.println(sum1);
		int puramt=  js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum1, puramt);
		
		
		
  }
}
