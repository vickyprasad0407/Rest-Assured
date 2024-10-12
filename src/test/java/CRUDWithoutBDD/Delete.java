package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
	
	@Test
	public void delete()
	{
		RequestSpecification req=RestAssured.given();
		Response res=req.delete("http://rmgtestingserver:8084/projects/TY_PROJ_9563");
		res.then().log().all();
	}

}
