package practice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class CookiesDemo {

	//@Test
	public void testCookies()
	{
		when().get("https://www.google.com/")
		.then().log().all();
	}
	//@Test
	public void getParticularCookies()
	{
		Response res = given()
		.when().get("https://www.google.com/");
		
		String cookie_value = res.getCookie("AEC");
		System.out.println(cookie_value);
	}
	@Test
	public void getAllCookies()
	{
		Response res = given()
		.when().get("https://www.google.com/");

		Map<String, String> cookies_value = res.getCookies();
		for (String k : cookies_value.keySet()) {
			String value=res.getCookie(k);
			System.out.println(k+"....."+value);
		}
	}
}
