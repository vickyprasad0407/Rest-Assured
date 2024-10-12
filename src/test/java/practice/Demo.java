package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Demo {

	
	  static int id;
	  
	  @Test(priority=1)
	  public void post() 
	  { 
      baseURI="https://reqres.in/";
	  JSONObject jobj=new JSONObject(); jobj.put("name", "vicky"); jobj.put("job","student");
	  id=given().body(jobj).contentType("application/json")
	  .when().post("/api/users") .jsonPath().getInt("id");
	  System.out.println(id);
	  }
	  
	  @Test(dependsOnMethods = "post") 
	  public void get()
	  {
	  Response res =when().get("https://reqres.in/api/users/2");
	  int act =res.jsonPath().getInt("data.id");
	  System.out.println(act);
	  res.then().assertThat().statusCode(200).header("Content-Type","application/json; charset=utf-8") .log().all(); 
	  }
	 
	
	@Test
	public void test123()
	{
		System.out.println("Ignore");
	}
}
