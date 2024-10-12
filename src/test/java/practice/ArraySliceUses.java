package practice;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import reuablefiles.Payload;

public class ArraySliceUses {
	@Test
	public void test()
	{
		Payload p=new Payload();
		JsonPath js=new JsonPath(p.bookPrice());
		int o=js.get("courses[0:2].size()");
		System.out.println(o);
	}

}
