package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword 
{

	public WebDriver driver;

	By email = By.id("user_email");
	
	By sendmeinstructions = By.cssSelector("[type='submit']");
	
	public ForgotPassword(WebDriver driver)  // this is a parameterised constructor
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);  // Here there is no life to driver so we are creating constructor with argument here 
	}
	
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendmeinstructions);  // Here there is no life to driver so we are creating constructor with argument here 
	}
	
	
}

