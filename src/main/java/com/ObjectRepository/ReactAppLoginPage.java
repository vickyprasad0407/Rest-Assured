package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReactAppLoginPage {

	WebDriver driver;
	@FindBy(id = "usernmae")
	private WebElement username;
	
	@FindBy(id = "inputPassword")
	private WebElement pwd;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signin;
	
	public ReactAppLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getSignin() {
		return signin;
	}
	public void login(String un,String pw)
	{
		username.sendKeys(un);
		pwd.sendKeys(pw);
		signin.click();
	}

}
