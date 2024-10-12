package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;

public class ValidateArrayOfObject {
     
	@Test
	public void testArr()
	{
//		baseURI="https://reqres.in";
//		String res=given().queryParam("page", 2)
//		.when().get("/api/users").asString();
//		JsonPath js=new JsonPath(res);
//		ArrayList al=js.get("data");
//		System.out.println(al);
//		Integer [] exp= {1,2,3,4,6};
		                             /*
		                             if it is primitive it will store the address
		                              so no comparision takes place we can compare
		                              where toString
		                              method is overridden
		                              int [] a1={1,2};
		                              int [] a2={3,4};
		                              not able to compare it
		                              */
//		Integer [] act= {1,2,3,4,7};
//		if(exp.length==act.length)
//		{
//		for (int i = 0; i < act.length; i++) {
//			Assert.assertEquals(exp[i], act[i]);
//		}
//		}
//		else
//			Assert.fail();
//		List exp1=Arrays.asList(exp);
//		List exp2=Arrays.asList(act);
//		Assert.assertEquals(exp1, exp2);
		
		String s= "vicky";
		if(s instanceof String)
			System.out.println(s);
		else
			System.out.println("hgh");
	}
}
