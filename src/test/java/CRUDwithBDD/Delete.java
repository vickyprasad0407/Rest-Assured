package CRUDwithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Delete {
	@Test
	public void testDelete()
	{
       baseURI="http://rmgtestingserver:8084";
       
       when().delete("/projects/TY_PROJ_19018")
       .then().assertThat().time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS).statusCode(204).contentType(ContentType.JSON).log().all();
	}

}
