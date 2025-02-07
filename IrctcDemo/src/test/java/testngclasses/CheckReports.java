package testngclasses;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import utilities.BaseReport;

public class CheckReports extends BaseReport{

	@Test
	public void successfulTest() {
		ext_test = ext_reports.createTest("Test Case-1","All the test steps executed successfully");
		Assert.assertTrue(true);
	}
	@Test
	public void unsuccessfulTest() {
		ext_test = ext_reports.createTest("Test Case-2","Test case failed after the 3rd step");
		Assert.assertTrue(false);
	}
	@Test
	public void skippedTest() {
		ext_test = ext_reports.createTest("Test Case-3","got skipped due to configurational issue");
		throw new SkipException("Test Case 3 skipped");
	}
}
