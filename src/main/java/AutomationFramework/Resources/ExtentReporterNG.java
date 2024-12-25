package AutomationFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		// path of our reports folder
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//set the name of our reports
		reporter.config().setReportName("Web Automation Pack Results");
		//set our test results name
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		//add details of our tester
		extent.setSystemInfo("Tester", "Vijay Deep Singh");
		return extent;
	}

}
