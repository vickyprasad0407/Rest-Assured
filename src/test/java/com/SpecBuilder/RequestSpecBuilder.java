 package com.SpecBuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

class RequestSpecBuilderDemo {
	
	@Test
	public void requestSpecBuilderdemo()
	{
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
		.expectStatusCode(201).build();
		
		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Achu");
		jobj.put("projectName", "photosynthesis"+jlib.getRandom());
		jobj.put("status", "creating");
		jobj.put("teamSize", 12);
		
		given().spec(req).body(jobj)
		.when().post("/addProject")
		.then().spec(res).log().all();
	}

}
