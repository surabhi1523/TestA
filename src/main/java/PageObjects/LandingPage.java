package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{

	public WebDriver driver;

	By signin = By.cssSelector("a[href*='sign_in']");
	
	By title = By.cssSelector("div[class='text-center']");
	
	By navigatebar =By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

	
	public LandingPage(WebDriver driver)  // this is a parameterised constructor
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(signin).click();  // Here there is no life to driver so we are creating constructor with argument here 
		LoginPage lp = new LoginPage(driver); // pass the life to driver in this form 
		return lp;
	
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);  
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navigatebar);  
	}

}

