package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Update {
	@Test
	public void updateTest()
	{
	   double ran = Math.random()*500;
	   baseURI="http://rmgtestingserver:8084";
	   JSONObject jobj=new JSONObject();
	   
	   jobj.put("projectName", "Xylem"+ran);
	   jobj.put("createdBy", "Vicky");
	   jobj.put("status", "created");
	   jobj.put("createdBy", "Vicky");
	   jobj.put("teamSize", 50);
       
	   given().body(jobj).contentType(ContentType.JSON)
	   .when().put("/projects/TY_PROJ_19068")
	   .then().assertThat().time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
	}

}
