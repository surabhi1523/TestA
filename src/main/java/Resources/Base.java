package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	//To get the access of driver in entire project 
	public WebDriver driver;   
	
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		//We have created a new file named "data.properties" under Academy pkg in order to pull data from it  
		FileInputStream fis = new FileInputStream("C:\\Surabhi_work\\TC\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		
		//It will take data from properties file related to browser 
		String browserName = prop.getProperty("browser"); 
		
		System.out.println(browserName);
		
		//This will come from data.properties file , we need to change there accordingly
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Surabhi_work\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Surabhi_work\\geckodriver-v0.26.0-win64\\geckodriver.exe ");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Surabhi_work\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe ");
			driver = new InternetExplorerDriver();
		}
		
		//We are setting timeout period for all tc's to 10 seconds
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		//whoever wants to use this ,can now use it through out project 
		return driver; 
	}
	
	public String getscreenshotpath(String tcname, WebDriver driver) throws IOException
	{
		TakesScreenshot  ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//Calendar calendar = Calendar.getInstance();
		//SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		
		//System.getporperty(user.dir) will point to current project (E2EProject) with new folder reports 
		//Name of screenshot should be name of failed tc. we can capture that in listernes class - onTestFailure method.
		String destincationfile = System.getProperty("user.dir")+"\\Reports\\"+tcname+".png";  // we are passing tc's name which is failing 
		
		//String destincationfile = System.getProperty("user.dir")+"\\Reports\\"+tcname+formater.format(calendar.getTime())+".png";  // we are passing tc's name which is failing 

		
		//FileUtils will be taken from  org.apache.common.io which is available from "Apache common io" dependency which is added under pom.xml
		FileUtils.copyFile(source,new File(destincationfile));
		
		return destincationfile;  // we are returning this bcz in Liteners class getscreenshot method needs path to report
	}
	
}
 