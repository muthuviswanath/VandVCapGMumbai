package utils;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseReport {

    protected static ExtentSparkReporter sparkreporter;
    protected static ExtentReports ext_reports;
    protected ExtentTest ext_test;

    @BeforeSuite
    public void initializeReporters() {
        if (ext_reports == null) { // Ensure it's initialized only once
            sparkreporter = new ExtentSparkReporter("./test-output/ExtentReport.html");
            ext_reports = new ExtentReports();
            ext_reports.attachReporter(sparkreporter);

            sparkreporter.config().setDocumentTitle("Extent Report Sample");
            sparkreporter.config().setReportName("Regression Testing - Sprint 1");
            sparkreporter.config().setTheme(Theme.STANDARD);
            sparkreporter.config().setTimeStampFormat("EEEE, MMM dd, yyyy hh:mm:ss");
        }
    }

    @BeforeMethod
    public void setUpTest(ITestResult result) {
        // Create a test instance for each test method dynamically
        ext_test = ext_reports.createTest(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void getTestStatus(ITestResult test_result) {
        if (test_result.getStatus() == ITestResult.FAILURE) {
            ext_test.log(Status.FAIL, test_result.getThrowable());
        } else if (test_result.getStatus() == ITestResult.SKIP) {
            ext_test.log(Status.SKIP, test_result.getMethod().getMethodName() + " skipped.");
        } else if (test_result.getStatus() == ITestResult.SUCCESS) {
            ext_test.log(Status.PASS, test_result.getMethod().getMethodName() + " passed.");
        }
    }

    @AfterSuite
    public void closeReport() {
        if (ext_reports != null) {
            ext_reports.flush();
        }
    }
}
