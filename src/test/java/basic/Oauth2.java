package basic;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import reuablefiles.Api;
import reuablefiles.GetCoursesPojo;
import reuablefiles.WebAutomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Oauth2 {

	@Test
	public void test()
	{
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		/*
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=ddb");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("prasadvicky0407@gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pwd");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		*/
		//String url=driver.getCurrentUrl();
		String url="https://rahulshettyacademy.com/getCourse.php?state=ddb&code=4%2F0AWtgzh7tkUpmaEnMBGjBulUHE6Fn_4U2gewsfqABjzxtallvOmnDp_648eR5zJh_ZlfXjQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
		String partialUrl=url.split("code=")[1];
		String code=partialUrl.split("&scope")[0];
		String accessTokenResponse=given().urlEncodingEnabled(false)
		.queryParams("code",code)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js=new JsonPath(accessTokenResponse);
		String accessToken=js.getString("access_token");
		System.out.println("the access token is "+accessToken);
		
		GetCoursesPojo gc=given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCoursesPojo.class);
		
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getExpertise());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		String [] courseTitle= {"Selenium Webdriver Java","Cypress","Protractor"};
		List<Api> getCourses=gc.getCourses().getApi();
		for (Api api : getCourses) {
			if(api.getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
				System.out.println("the price is"+api.getPrice());
		}
		
		ArrayList<String> al=new ArrayList<String>();
		List<WebAutomation> webaut = gc.getCourses().getWebAutomation();
		for(int i=0;i<webaut.size();i++)
		{
		     al.add(webaut.get(i).getCourseTitle());
		}
		 
		List<String> expList = Arrays.asList(courseTitle);
		Assert.assertTrue(al.equals(expList));
		
		
	}
}
