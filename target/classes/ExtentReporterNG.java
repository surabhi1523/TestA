package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	static ExtentReports extent;
	public static ExtentReports getreportObject1()
	{
		//Extent report , ExtentsparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";  // with "user.dir"Project path is given here dynamically and extent reports will be seen at index.html
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);  // this expects path where report to be created.
		reporter.config().setReportName("Web Automation Result");   
		reporter.config().setDocumentTitle("Test Results");

		extent= new ExtentReports();
		// Attaching created report from extentsparkreporter helper class to the main class extent		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Surabhi Rathor"); 
		
		return extent;
	
	}
}
