package CRUDwithBDD;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Post {
	
	@Test
	public void testPost()
	{
		
		baseURI="http://rmgtestingserver";//methods of rest assured
		port=8084;//methods of rest assured
		Random r=new Random();
		int ran=r.nextInt();
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Aliens");
		jobj.put("projectName", "Xylem"+ran);
		jobj.put("status", "creating");
		jobj.put("teamSize", 12);
		
		given().body(jobj).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().assertThat().time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS).statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
