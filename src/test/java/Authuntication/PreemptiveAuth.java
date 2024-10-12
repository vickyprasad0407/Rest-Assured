package Authuntication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreemptiveAuth {
	
	@Test
	public void test()
	{
        baseURI="http://rmgtestingserver";
        port=8084;
        given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
        .when().get("/login")
        .then().log().all();
	}

}
