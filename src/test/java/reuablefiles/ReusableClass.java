package reuablefiles;

import org.openqa.selenium.json.Json;

import io.restassured.path.json.JsonPath;

public class ReusableClass {
	
	public JsonPath stringToJson(String response)
	{
		JsonPath js=new JsonPath(response);
		return js;
	}

}
