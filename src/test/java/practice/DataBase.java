package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.DatabaseLibrary;
import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class DataBase {

	@Test
	public void verify() throws SQLException
	{
		JavaLibrary jlib=new JavaLibrary();
		JSONObject jobj=new JSONObject();
		DatabaseLibrary dlib=new DatabaseLibrary();
		jobj.put("createdBy", "Aliens");
		jobj.put("projectName", "Xylem"+jlib.getRandom());
		jobj.put("status", "creating");
		jobj.put("teamSize", 12);
		
		Response res = given().body(jobj).contentType(ContentType.JSON)
		.when().post("http://rmgtestingserver:8084/addProject");
	     
		String proid = res.jsonPath().get("projectId");
		res.then().log().all();
		System.out.println("============================");
		
		String query="update project set status='created' where project_id='"+proid+"'";
		dlib.connectToDB();
		dlib.insertRowUsingDB(query);
		dlib.closeDB();
		 when().get("http://rmgtestingserver:8084/projects/"+proid)
		 .then().log().all();
	}
}
