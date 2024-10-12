package genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.CreateProjectPage;
import com.ObjectRepository.ReactAppHomePage;
import com.ObjectRepository.ReactAppPage;
import com.ObjectRepository.ReactApp_ProjectPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {

	public WebDriver driver;
	
	public ReactApp_ProjectPage rapp=new ReactApp_ProjectPage(driver);
	public ReactAppHomePage rah;
	public CreateProjectPage cp=new CreateProjectPage(driver);
	public ReactAppPage rp;
	public DatabaseLibrary dlib=new DatabaseLibrary();
	public JavaLibrary jlib=new JavaLibrary();
	public RestAssuredLibrary rlib=new RestAssuredLibrary();
	public WebDriverUtility wb=new WebDriverUtility();
	public  RequestSpecification reqst;
	public  ResponseSpecification resp;
	
    

	@BeforeSuite
	public void configBeforeDB()
	{
		//baseURI="http://rmgtestingserver:8084/";
		dlib.connectToDB();
		System.out.println("connect to database");
	
		reqst=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver").setPort(8084)
				.setContentType(ContentType.JSON).build();
		resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@AfterSuite
	public void configAfterDB()
	{
		dlib.closeDB();
		System.out.println("disconnect to database");
	}
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Launched browser successfully");
		driver.get("http://rmgtestingserver:8084");
		Thread.sleep(5000);
	
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Closed browser successfully");
	}
	@BeforeMethod
	public void loginApp() throws InterruptedException
	{
		rp=new ReactAppPage(driver);
	      rp.reactapplogin(IConstant.appUserName, IConstant.appPassword);
		 System.out.println("Login to application successfully");
	}
	@AfterMethod
	public void logoutApp()
	{
		rah=new ReactAppHomePage(driver);
		rah.logout();
		System.out.println("Logout from application successfully");
	}
}
