package basic;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import reuablefiles.Payload;

import static io.restassured.RestAssured.*;

public class DataProviderDemoForLibrayWS {

	@Test
	public void postandDelete()
	{
        baseURI="http://216.10.245.166";
        Payload p=new Payload();
        String b = p.postLibrary();
        given().body(b).header("Content-Type", "application/json")
        .when().post("Library/Addbook.php")
        .then().assertThat().contentType(ContentType.JSON).log().all();
	}
}
