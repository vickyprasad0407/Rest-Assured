package Authuntication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {
	
	@Test
	public void test()
	{
      // baseURI="http://coop.apps.symfonycasts.com/api";
       Response res=given().formParam("client_id", "Manga123")
    		   .formParam("client_secret", "30753d94eb3ed3faab475091c6c5530e")
               .formParam("grant_type", "client_credentials")
               .formParam("redirect_uri", "http://example.com")
               .formParam("code", "The authorization code")
               .when().post("http://coop.apps.symfonycasts.com/token");
       String token=res.jsonPath().get("access_token");// access_token is given based on response to see it remove semi column and write log.all
       System.out.println("the access token is "+token);
       
       given().auth().oauth2(token).pathParam("userId", "4353")
       .when().post("http://coop.apps.symfonycasts.com/api/{userId}/toiletseat-down")
       .then().assertThat().statusCode(200).log().all();   
	}
}
