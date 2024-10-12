package RequestChaining;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.POJO.PostP;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class DataProviderDemo {
	@DataProvider (name="rrr") // if we give name to data provider then its implementing method will provided by same name not method name otherwise we will get testng exception
	public Object [][] data()
	{
		Object [][] ob=new Object [2][4];
		ob[0][0]="vicky";
		ob[0][1]="MissionMars";
		ob[0][2]="Creating";
		ob[0][3]=10;
		
		ob[1][0]="vicky _K_P";
		ob[1][1]="MissionMars";
		ob[1][2]="created";
		ob[1][3]=12;
		return ob;
	}
	@Test(dataProvider = "rrr")//if no data provider name then we can pass method name otherwise we have to pass dataprovider name
	public void test(String createdBy,String projectName,String status,int i)
	{
        baseURI="http://rmgtestingserver";
        port=8084;
        Random r=new Random();
        int ran=r.nextInt(500);
        PostP p=new PostP(createdBy, projectName+ran, status, i);
        
        Response res=given().body(p).contentType(ContentType.JSON)
        .when().post("/addProject");
        String proid=res.jsonPath().get("projectId");
        
        String res2=when().get("/projects/"+proid).asString();
        JsonPath js=new JsonPath(res2);
        int team=js.get("teamSize");
        if(team>10)
        	System.out.println(js.get("createdBy"));
	}

}
