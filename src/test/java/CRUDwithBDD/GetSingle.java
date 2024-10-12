package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSingle {

	@Test
	public void getSingle()
	{
        baseURI="http://rmgtestingserver:8084";//no error even we place / more than one time
        
        when().get("/projects/TY_PROJ_936")
        
        .then().time(Matchers.lessThan(10000l), TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
