package utils;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseReport {

	protected ExtentSparkReporter sparkreporter;
	protected ExtentReports ext_reports;
	protected ExtentTest ext_test;

	@BeforeTest
	public void initializeReporters() {
		sparkreporter = new ExtentSparkReporter("./test-output/ExtentReport.html");
		ext_reports = new ExtentReports();
		ext_reports.attachReporter(sparkreporter);

		sparkreporter.config().setDocumentTitle("Extent Report Sample");
		sparkreporter.config().setReportName("Regression Testing - Sprint 1");
		sparkreporter.config().setTheme(Theme.STANDARD);
		sparkreporter.config().setTimeStampFormat("EEEE, MMM dd, yyyy hh:mm:ss");
	}

	@AfterMethod
	public void getTestStatus(ITestResult test_result) {
		if(test_result.getStatus() == ITestResult.FAILURE) {
			ext_test.log(Status.FAIL, test_result.getThrowable());
		}
		else if(test_result.getStatus() == ITestResult.SKIP) {
			ext_test.log(Status.SKIP, test_result.getTestName());
		}
		else if(test_result.getStatus() == ITestResult.SUCCESS) {
			ext_test.log(Status.PASS, test_result.getTestName());
		}
		
	}
	
	@AfterTest
	public void closeReport() {
		ext_reports.flush();
	}
}