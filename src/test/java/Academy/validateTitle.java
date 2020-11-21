package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;
import junit.framework.Assert;

public class validateTitle extends Base
{
	 // we are declaring in order to have a local copy of driver which can be used during initializing driver object (while running tests in parallel).
		// In case of sequential order of running no error will be seen. Issue is with parallel execution which we handled here by declaring driver at class level
		
	public WebDriver driver;
	
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		
		log.info("Navigated to home page");
	}
	
	
	@Test
	public void pageNavigationBaseFeomValidateTitle() throws IOException
	{
		
		// We can access methods using inheritance and other is by creating object
		// We are passing driver here to give life to Landingpage.java's getlogin() function's driver 
		LandingPage l = new LandingPage(driver);
		
		//compare the text from browser with actual value ,if mismatcth then error 
		Assert.assertEquals("FEATURED COURSES", l.getTitle().getText());
		
		log.info("Successfully validated text message");
			
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}