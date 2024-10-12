package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidation {

	@Test
	public void getSingle()
	{
		baseURI="http://rmgtestingserver:8084/";
		String statusLine="HTTP/1.1 200 ";
		String contentType="application/json";
		String h1exp="Access-Control-Request-Headers";
		String h2exp="no-cache";
		int expstCode=200;
		
         Response res = when().get("/projects/TY_PROJ_9530");
         
         String content = res.getContentType();
         String h1 = res.getHeader("vary");
         String h2 = res.getHeader("Pragma");
         int stCode = res.getStatusCode();
         String actStatusLine = res.getStatusLine();
         
         res.then().log().all();
         Assert.assertEquals(actStatusLine, statusLine);
         Assert.assertEquals(contentType, content);
         Assert.assertEquals(h1, h1exp);
         Assert.assertEquals(h2, h2exp);
         Assert.assertEquals(stCode, expstCode);
         
	}
}
