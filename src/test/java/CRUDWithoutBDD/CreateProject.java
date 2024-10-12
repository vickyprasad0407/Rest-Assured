package CRUDWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
    @Test
    public void createProj()
    {
    	double ran = Math.random();
    	//step 1: create the pre request -request body
    	JSONObject jobj=new JSONObject();
    	jobj.put("createdBy", "Alliens123");
    	jobj.put("projectName", "Alpha"+ran);
    	jobj.put("status", "completed");
    	jobj.put("teamSize", 12);
    	
    	//step 2: perform the action
    	RequestSpecification req=RestAssured.given();
    	req.body(jobj);
    	req.contentType(ContentType.JSON);
    	Response resp=req.post("http://rmgtestingserver:8084/addProject");
    	
    	//step 3: validate the response
    	System.out.println("===========================");
    	System.out.println(resp.contentType());
    	System.out.println("===========================");
    	System.out.println(resp.prettyPrint());
    	System.out.println("===========================");
    	System.out.println(resp.prettyPeek());
    	System.out.println("===========================");
    	System.out.println(resp.asString());
    	int actalStatus = resp.getStatusCode();
    	Assert.assertEquals(actalStatus, 201);
    }
}
