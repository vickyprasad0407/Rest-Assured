package practice;

import java.util.Random;

import org.testng.annotations.Test;

import com.POJO.PostP;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DeserializePojo {
	
	@Test
	public void test()
	{
		baseURI="http://rmgtestingserver:8084";
		PostP getP = when().get("/projects/TY_PROJ_1712").as(PostP.class);
		System.out.println(getP.toString());
	}

}
