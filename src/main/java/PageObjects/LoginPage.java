package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{

	public WebDriver driver;

	By email = By.id("user_email");
	
	By pwd = By.id("user_password");
	
	By button = By.cssSelector("input[type='submit']");
	
	By forgotpwd = By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver)  // this is a parameterised constructor
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(email);  // Here there is no life to driver so we are creating constructor with argument here 
	}

	public WebElement getpwd()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement Clicklogin()
	{
		return driver.findElement(button);
	}
	
	public ForgotPassword Forgotpwd()
	{
		driver.findElement(forgotpwd);
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}
	
	
}

