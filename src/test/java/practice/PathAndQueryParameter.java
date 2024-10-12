package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathAndQueryParameter {
	//https://reqres.in/api/users?page=2&id=5
	@Test
	public void testPath()
	{
        baseURI="https://reqres.in";
        given().pathParam("path","users")
        .queryParam("page", 2).queryParam("id",5)
        .when().get("https://reqres.in/api/{path}")
        .then().statusCode(200).log().all();
	}

}
