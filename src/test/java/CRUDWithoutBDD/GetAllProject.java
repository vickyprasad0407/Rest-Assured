package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllProject {
	
	@Test
	public void getAll()
	{
		RequestSpecification req=RestAssured.given();
		Response resp=req.get("http://rmgtestingserver:8084/projects");
		resp.then().log().all();
		
	}

}
