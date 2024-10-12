package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LogDemo {
	@Test
	public void test()
	{
		when().get("https://reqres.in/api/users?page=2&id=5")
		.then().log().cookies();
	}

}
