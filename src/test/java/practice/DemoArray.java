package practice;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DemoArray {
	@Test
	public void testArray()
	{
		baseURI="https://reqres.in/";
		String res=given().queryParam("page", 2)
		.when().get("/api/users").asString();
		JsonPath js=new JsonPath(res);
		int count=js.get("data.size()");
		for (int i = 0; i < count; i++) {
			int id=js.get("data.get("+i+").id");
			if(id>=10)
				System.out.println(js.get("data.get("+i+").first_name"));
		}
	}

}
