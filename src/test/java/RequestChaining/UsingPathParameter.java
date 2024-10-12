package RequestChaining;

import org.testng.annotations.Test;

import com.POJO.PostP;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsingPathParameter {

	@Test
	public void requestChaining()
	{
		//step 1 Creating the project using POJO
		 int ran = (int)Math.random()*500;
		 PostP p=new PostP("vicky", "Alpha1"+ran, "creating", 15);
		 baseURI="http://rmgtestingserver";
		 port=8084;
		 
		 Response res=given().body(p).contentType(ContentType.JSON)
				      .when().post("/addProject");
		 // step 2 capturing the project id
		 String proId = res.jsonPath().get("projectId");
		 System.out.println("the project id is "+proId);
		 res.then().log().all();
		 
		 //creating a request and pass project id as path parameter
		 
		 given().pathParam("pid", proId)
		 .when().get("/projects/{pid}")
		 .then().assertThat().statusCode(200).log().all();
	}
}
