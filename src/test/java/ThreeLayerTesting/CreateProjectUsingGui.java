package ThreeLayerTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class CreateProjectUsingGui extends BaseClass {

	String projectName;
	String projectID;
	@Test
	public void createProjectUsingGUI() throws InterruptedException
	{
		//create a project using gui

		projectName="bruna"+jlib.getRandom();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("vicky");
		WebElement status = driver.findElement(By.name("status"));
		Select s=new Select(status);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();


		//verify using db
		dlib.connectToDB();
		String query="select * from project where project_name='"+projectName+"';";
		dlib.validateDB(query, 4, projectName);
		dlib.closeDB();

		//verify using api
		given().spec(reqst).
		when().get(EndPointLibrary.getSingleProject+projectID)
	    .then().log().all();
	}
}
