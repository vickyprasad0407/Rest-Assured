package ThreeLayerTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepository.ReactAppHomePage;
import com.ObjectRepository.ReactAppPage;
import com.ObjectRepository.ReactApp_ProjectPage;
import com.POJO.PostP;
import com.mysql.cj.jdbc.Driver;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import genericUtility.IConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateAProjectUsingApi extends BaseClass {

	String projectName;
	@Test
	public void createProjectUsingApi() throws InterruptedException
	{
		//creating a project using api
		projectName="Xylem@12"+jlib.getRandom();
		PostP p=new PostP("Aliens", projectName, "creating", 5);
		given().spec(reqst).body(p)
		.when().post(EndPointLibrary.createProject)
		.then().spec(resp).log().all();
		
		// verifying in gui	
		rah=new ReactAppHomePage(driver);
		rah.getProjects().click();
		Thread.sleep(8000);
		WebElement element = driver.findElement(By.xpath("//tr/td[2][.='"+projectName+"']"));
		if(element.getText().equalsIgnoreCase(projectName))
			System.out.println("project verified sucessfully on gui");
		else
			System.out.println("project not verified sucessfully in gui");

		//verifying in database
		System.out.println(projectName);
		dlib.connectToDB();
		String query="select * from project where project_name='"+projectName+"';";
		dlib.validateDB(query, 4, projectName);
		dlib.closeDB();
	}
}
