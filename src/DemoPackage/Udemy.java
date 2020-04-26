package DemoPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import PayloadPackage.AddPlacePayload;
//import files.payload;
import io.restassured.path.json.JsonPath;

public class Udemy {

	@Test
	public void sumOfCourses()
	{
		int sum = 0;
		JsonPath js=new JsonPath(AddPlacePayload.courseRes());
		int count=	js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
			
		}
		System.out.println(sum);
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		
	}
}
