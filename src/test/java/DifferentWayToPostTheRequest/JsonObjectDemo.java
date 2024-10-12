package DifferentWayToPostTheRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.net.URI;

public class JsonObjectDemo {
	@Test
	public void test()
	{
		baseURI="http://rmgtestingserver:8084";
		double ran=Math.random();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Vicky");
		jobj.put("projectName", "Photosynthesis123");
		jobj.put("status", "creating");
		jobj.put("teamSize", 12);
		given().body(jobj).contentType(ContentType.JSON)
		.when().post("addProject")
		.then().assertThat().statusCode(201).log().all();
	}

}
