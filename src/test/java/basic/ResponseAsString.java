package basic;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class ResponseAsString {

	@Test
	public void test()
	{
        baseURI="https://rahulshettyacademy.com";
        String resBody=given().contentType(ContentType.JSON).queryParam("key", "qaclick123")
        .body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"")
        .when().post("/maps/api/place/add/json")
        .then().log().all().assertThat().statusCode(200).extract().asString();
        
        JsonPath jp=new JsonPath(resBody);
         String place_id=jp.getString("place_id");
         System.out.println(place_id);
         
         String getResponse=given().queryParam("place_id", place_id).queryParam("key", "qaclick123")
        		 .when().get("maps/api/place/get/json")
         .then().log().all().assertThat().statusCode(200).extract().asString();
         
         JsonPath jp1=new JsonPath(getResponse);
          String actwebsite = jp1.getString("website");
          
	}
}
