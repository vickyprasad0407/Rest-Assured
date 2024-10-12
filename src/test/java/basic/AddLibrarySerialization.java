package basic;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import reuablefiles.AddPlacePojo;
import reuablefiles.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class AddLibrarySerialization {

	@Test
	public void test()
	{
		baseURI="https://rahulshettyacademy.com";
		AddPlacePojo ap=new AddPlacePojo();
        Location l=new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        ap.setLocation(l);
        
        ap.setAccuracy(50);
        ap.setAddress("dimdam");
        ap.setLanguage("englisg");
        ap.setName("vicky");
        ap.setPhone_no("987654321112");
        List<String> mylst=new ArrayList<String>();
        mylst.add("clothes");
        mylst.add("shoes");
        ap.setTypes(mylst);
        ap.setWebsite("www.abc.xyz");
        
        Response res=given().log().all().queryParam("key", "qaclick123")
        		.body(ap)
        		.when().post("/maps/api/place/add/json").
        		then().assertThat().statusCode(200).extract().response();

        		String responseString=res.asString();
        		System.out.println(responseString);
	}
}
