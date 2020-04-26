package DemoPackage;
import PayloadPackage.*;

import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {

	public static void main(String[] args) {
		JsonPath js= new JsonPath(AddPlacePayload.courseRes());
		int csize= js.getInt("courses.size()");
		System.out.println("***size array***"+csize);
		int totprize=js.getInt("dashboard.purchaseAmount");
		System.out.println("*****tot prize*****"+totprize);
		String titlec1 = js.get("courses[0].title");
		System.out.println("*****title one*****"+titlec1);
		for ( int i =0;i<csize;i++) {
			String ctitle= js.get("courses["+i+"].title");
			System.out.println(ctitle);
			System.out.println(js.get("courses["+i+"].price").toString());
			
			
			
			
			
		}
		
		
		
		
		

	}

}
