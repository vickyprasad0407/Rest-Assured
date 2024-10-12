package Validation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class BodyValidation {

	@Test
	public void validateBody()
	{
		baseURI="http://rmgtestingserver:8084/";
		Response res = when().get("/projects/TY_PROJ_9530");
		
		 String body = res.getBody().asString();
		System.out.println(body);
		System.out.println("==========================================");
		 String b1 = res.andReturn().asString();
		System.out.println(b1);
		System.out.println("============================================");
		ResponseBody resBody = res.body();
		ResponseBody b2 = res.body();
		System.out.println(b2.peek().asString());//print header +body 2 times
		System.out.println("================================================");
		System.out.println(b2.prettyPrint());
	}
}
