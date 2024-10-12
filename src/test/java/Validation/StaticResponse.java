package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class StaticResponse {

	@Test
	public void staticValidate()
	{
		baseURI="http://rmgtestingserver:8084";
	   	Response res = when().get("/projects");
	    String act = res.jsonPath().get("[5].createdBy.name");
	    Assert.assertEquals(act, "Alliens123");
	   	System.out.println("status verified sucsessfully");
	   	res.then().log().all();
	}
}
