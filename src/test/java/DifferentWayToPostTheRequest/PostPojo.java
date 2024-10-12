package DifferentWayToPostTheRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.POJO.PostP;

import CRUDwithBDD.Post;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostPojo {
	@Test
	
	public void test()
	{
		PostP p=new PostP("vicky123","xylemhhgf1","creating",12);
		baseURI="http://rmgtestingserver:8084";
		System.out.println(p);
		given().body(p).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
		
	}

}
