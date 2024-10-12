package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAll {

	@Test
	public void testGet()
	{
         baseURI="http://rmgtestingserver";
         port=8084;
         
         
         when().get("/projects")
         
         .then().assertThat().time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS).statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
