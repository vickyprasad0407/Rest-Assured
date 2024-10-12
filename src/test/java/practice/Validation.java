package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Validation {

	int id;
	@Test(priority = 1)
	public void getSingle()
	{
      id=given().contentType(ContentType.JSON)
       .when().get("https://reqres.in/api/users/2")
       .jsonPath().getInt("data.id");
      System.out.println("the id is : "+id);
	}
	@Test(priority = 2)
	public void delete()
	{
		when().delete("https://reqres.in/api/users/"+id)
		.then().log().all();
	}
}
