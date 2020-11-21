package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentReporterNG;

public class Listerners extends Base implements ITestListener 
{
	ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getreportObject1();
	
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal(); //making extenttest class thread safe 
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//To print which test case is executing we are printing its name 
		test = extent.createTest(result.getMethod().getMethodName());
		
		extenttest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extenttest.get().log(Status.PASS, "Test Passed"); // replacing test with extenttest everywhere here 
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extenttest.get().fail(result.getThrowable());

		
		//screenshot taking
		WebDriver driver=null;
		String methodname =result.getMethod().getMethodName();
		try {
			//this needs only once through program so no need to remember it 
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e)
		{
			

		}
		try {
			
			// To add the screenshot to the index.html 
			extenttest.get().addScreenCaptureFromPath(getscreenshotpath(methodname,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public boolean equals(Object obj) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return null;
		// TODO Auto-generated method stub
	
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
	
}
