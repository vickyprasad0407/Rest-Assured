package DifferentWayToPostTheRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class HashMapDemo {
	@Test
	public void test()
	{
        baseURI="http://rmgtestingserver:8084";
        HashMap hs=new HashMap();
        hs.put("createdBy", "vickyKp");
        hs.put("projectName", "spains123");
        hs.put("status", "created");
        hs.put("teamSize", 12);
        
        given().body(hs).contentType(ContentType.JSON)
        .when().post("/addProject")
        .then().assertThat().statusCode(201).log().all();
	}

}
