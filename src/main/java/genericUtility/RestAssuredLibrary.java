package genericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary {

	public String getJsonPath(Response res,String path)
	{
		return res.jsonPath().get(path);
	}
}
