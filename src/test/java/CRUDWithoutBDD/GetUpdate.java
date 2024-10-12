package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUpdate {
	
	@Test
	public void getUpdate()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Achu");
    	jobj.put("projectName", "rmgyantra488");
    	jobj.put("status", "completed");
    	jobj.put("teamSize", 12);
    	
    	RequestSpecification req=RestAssured.given();
        req.body(jobj);
        req.contentType(ContentType.JSON);
        
        Response res=req.put("http://rmgtestingserver:8084/projects/TY_PROJ_9563");
        res.then().log().all();
	}

}
