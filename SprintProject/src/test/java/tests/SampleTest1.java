package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseReport;

public class SampleTest1 extends BaseReport {

    @Test
    public void testCase1() {
    	ext_test= ext_reports.createTest("Sample Test 1","Test Case 1");

    }

    @Test
    public void testCase2() {
    	ext_test= ext_reports.createTest("Sample Test 2","Test Case 2");

    }
}
