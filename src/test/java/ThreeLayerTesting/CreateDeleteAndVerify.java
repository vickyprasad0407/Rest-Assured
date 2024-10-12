package ThreeLayerTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepository.ReactAppHomePage;
import com.mysql.cj.jdbc.Driver;

import genericUtility.BaseClass;
import genericUtility.EndPointLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class CreateDeleteAndVerify extends BaseClass{
	String projectName;
	String projectId;
	@Test
	public void createUsingGUI() throws InterruptedException
	{
		//creating using gui
		projectName="bruna123"+jlib.getRandom();
		Thread.sleep(3000);
		rah=new ReactAppHomePage(driver);
		rah.getProjects().click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("vicky");
		WebElement status = driver.findElement(By.name("status"));
		Select s=new Select(status);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(5000);
		String projectId=driver.findElement(By.xpath("//tr/td[2][.='"+projectName+"']/../td[1]")).getText();
		System.out.println("project created sucessfully");	
		//deleting using api
		given().spec(reqst).
		when().delete(EndPointLibrary.deleteProject+projectId)

		.then().statusCode(204).log().all();

		//verifying using db
		dlib.connectToDB();
		String query="select * from project where project_name='"+projectName+"';";
		dlib.validateDB(query, 4, projectName);
		dlib.closeDB();

	}

}
