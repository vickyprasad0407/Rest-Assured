package basic;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ComplexHashMap {

	@Test
	public void test()
	{
		baseURI="https://petstore.swagger.io/v2";
		HashMap<String, Object> hs=new HashMap<String, Object>();
		hs.put("id", 50);
		HashMap<String, Object> hs1=new HashMap<String, Object>();
		hs1.put("id", 30);
		hs1.put("name", "suman");
		hs.put("category", hs1);
		hs.put("name", "doggie");
		String [] ar= {"xyz"};
		hs.put("photoUrls", ar);
		HashMap<String, Object> hs2=new HashMap<String, Object>();
		hs2.put("id", 120);
		hs2.put("name", "vicky");
		Object [] arr= {hs2};
		hs.put("tags", arr);
		hs.put("status", "available");
						
		given().log().all().contentType(ContentType.JSON)
		.body(hs)
		.when().put("/pet")
		.then().assertThat().statusCode(200).log().all();
	}
}
