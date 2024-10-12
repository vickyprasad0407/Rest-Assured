package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingle {
	@Test
	public void getSingleProject()
	{
		RequestSpecification req=RestAssured.given();
		Response resp=req.get("http://rmgtestingserver:8084/projects/TY_PROJ_1875");
		resp.then().log().all();
	}

}
