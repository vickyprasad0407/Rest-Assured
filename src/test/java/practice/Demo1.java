package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {

	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("washing machine");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Voltas Beko 9 kg Semi Automatic Twin Tub Washing machine (WTT90UDX/BKGR4KPTD) Black - ECO Model']")).click();
		Set<String> list = driver.getWindowHandles();
		for (String string : list) {
			driver.switchTo().window(string);
		}
		
		 List<WebElement> spec = driver.findElements(By.xpath("//td[@class='a-span3']"));
		 List<WebElement> value = driver.findElements(By.xpath("//td[@class='a-span9']"));
		 HashMap<String, String> hs=new HashMap<String, String>();
		for (int i=0;i<spec.size();i++) {
			String key = spec.get(i).getText();
			String val = value.get(i).getText();
			hs.put(key, val);
		}
		System.out.println(hs);
		driver.quit();;
	}
}
