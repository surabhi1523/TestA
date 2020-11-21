package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ForgotPassword;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base
{
	public WebDriver driver;  // we are declaring in order to have a local copy of driver which can be used during initializing driver object (while running tests in parallel).
	// In case of sequential order of running no error will be seen. Issue is with parallel execution which we handled here by declaring driver at class level
	
	public static Logger log= LogManager.getLogger(Base.class.getName());


	@BeforeTest
	public void initialize1() throws IOException
	{
		driver = initializeDriver();
		
	}
	
	
	@Test(dataProvider="getDataToTC")
	public void pageNavigationBaseFromHome(String username, String password, String text) throws IOException
	{	
		System.out.println("You are in homePage class");
		driver.get(prop.getProperty("url"));
		
		// We can access methods using inheritance and other is by creating object
		// We are passing driver here to give life to Landingpage.java's getlogin() function's driver 
		LandingPage l = new LandingPage(driver);
		
		LoginPage lp = l.getLogin();  // similar to driver.findelement(by.css())
		
		//LoginPage lp = new LoginPage(driver); // pass the life to driver in this form 
		
		lp.getLogin().sendKeys(username);
		
		lp.getpwd().sendKeys(password);
		
		//System.out.println(text);
		
		log.info(text);
		
		lp.Clicklogin().click();
		
		ForgotPassword fp =  lp.Forgotpwd();
		
		fp.getEmail().sendKeys("abcdefgh");
		
		fp.sendMeInstructions().click();
		
	}
	
	@DataProvider
	public Object[][] getDataToTC()
	{
		//rows stand for how many different data we are sending 
		//columns stand for how many values per each test
		Object[][] data = new Object[2][3];
		
		data[0][0]="nonrestricteduser@ssd.com";
		data[0][1]="123456";
		data[0][2]="restricteduser";
		
		data[1][0]="restricteduer@cdc.com";
		data[1][1]="32323";
		data[1][2]="non restricted usr";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
