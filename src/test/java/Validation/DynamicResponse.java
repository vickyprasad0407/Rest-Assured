package Validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponse {
	@Test
	public void test()
	{
		String expData="TY_PROJ_19321";
        baseURI="http://rmgtestingserver:8084";
        Response resp=when().get("/projects");
        boolean flag=false;
        List<String> pid = resp.jsonPath().get("projectId");
        for (String projectId : pid) {
			if(projectId.equalsIgnoreCase(expData))
				flag=true;
		}
        Assert.assertTrue(flag);
        System.out.println("data verified");
        resp.then().statusCode(200).log().all();
	}

}
