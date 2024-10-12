package Parameter;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void postTest()
	{
		baseURI="http://rmgtestingserver:8084";
		given().pathParam("pid", "TY_PROJ_19257")
		.when().get("/projects/{pid}")
		.then().assertThat().statusCode(200).log().all();
	}
}
