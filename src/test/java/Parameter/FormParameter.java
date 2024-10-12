package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	public void test()
	{
		baseURI="https://reqres.in/";
		given().formParam("name", "morpheus")
		.formParam("job", "leader")
		.when().post("/api/users")
		.then().assertThat().statusCode(201).log().all();
	}

}
