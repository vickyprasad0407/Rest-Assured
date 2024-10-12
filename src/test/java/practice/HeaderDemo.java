package practice;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderDemo {

	//@Test
	public void test()
	{
		when().get("https://www.google.com/")
		.then().header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws");

	}
	//@Test
	public void getSingleHeaders()
	{
		Response res = given().
		when().get("https://www.google.com/");
        
		 String value = res.getHeader("Content-Type");
		 System.out.println(value);
	}
	@Test
	public void allHeaderInfo()
	{
		Response res = given().
				when().get("https://www.google.com/");
		        
				  Headers value = res.getHeaders();
			     for (Header hd : value) {
					System.out.println(hd.getName()+"...."+hd.getValue());
				}
	}
}
