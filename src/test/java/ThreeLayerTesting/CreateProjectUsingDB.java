package ThreeLayerTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class CreateProjectUsingDB extends BaseClass {
	String projectID;
	@Test
	public void createProjectinDB() throws SQLException, InterruptedException
	{
		//create project using db
		projectID="TY_ZooView_"+jlib.getRandom();
		String query="insert into project values ('"+projectID+"','Vicky','16/12/2022','Zoo_view','created',2)";
		dlib.connectToDB();
		dlib.insertRowUsingDB(query);
		dlib.closeDB();
		
		//verifu using gui
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Projects")).click();
		Thread.sleep(8000);
		WebElement element = driver.findElement(By.xpath("//tr/td[1][.='"+projectID+"']"));
		if(element.getText().equalsIgnoreCase(projectID))
			System.out.println("project verified sucessfully on gui");
		else
			System.out.println("project not verified sucessfully in gui");
		
		
		//verify using api
		 given().spec(reqst).
		when().get(EndPointLibrary.deleteProject+projectID)
	        .then().log().all();
	}
}
