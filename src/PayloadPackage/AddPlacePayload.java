package PayloadPackage;

public class AddPlacePayload {
public static String AddPlace() {
	
	return "{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"RenukaDevi Tanmay Raja Piyushi Rani SOne MOne\",\r\n" + 
			"  \"phone_number\": \"(+91) 2020202020\",\r\n" + 
			"  \"address\": \"29, Rambag New India School, cohen 09\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"shoe park\",\r\n" + 
			"    \"shop\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"https://rahulshettyacademy.com\",\r\n" + 
			"  \"language\": \"French-IN\"\r\n" + 
			"}\r\n" + 
			"";
}

public static String courseRes() {
	return "{\r\n" + 
			"\"dashboard\": {\r\n" + 
			"\"purchaseAmount\": 910,\r\n" + 
			"\"website\": \"rahulshettyacademy.com\"\r\n" + 
			"},\r\n" + 
			"\"courses\": [\r\n" + 
			"{\r\n" + 
			"\"title\": \"Selenium Python\",\r\n" + 
			"\"price\": 50,\r\n" + 
			"\"copies\": 6\r\n" + 
			"},\r\n" + 
			"{\r\n" + 
			"\"title\": \"Cypress\",\r\n" + 
			"\"price\": 40,\r\n" + 
			"\"copies\": 4\r\n" + 
			"},\r\n" + 
			"{\r\n" + 
			"\"title\": \"RPA\",\r\n" + 
			"\"price\": 45,\r\n" + 
			"\"copies\": 10\r\n" + 
			"}\r\n" + 
			"]\r\n" + 
			"}\r\n" + 
			"";
}
public static String addBook(String isbn, String aisle) {
	String bookpayload ="{\r\n" + 
			"\r\n" + 
			"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
			"\"isbn\":\""+isbn+"\",\r\n" + 
			"\"aisle\":\""+aisle+"\",\r\n" + 
			"\"author\":\"John foe\"\r\n" + 
			"}\r\n" + 
			"";
	return bookpayload;
	
}
public static String deleteBook(String isbn, String aisle) {
	return "\"ID\" : \""+isbn+aisle+"\"";
}
}
