package DifferentWayToPostTheRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class FileDemo {
	
	@Test
	public void test()
	{
		baseURI="http://rmgtestingserver:8084";
		File f=new File("./file.json");
		given().body(f).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}

}
