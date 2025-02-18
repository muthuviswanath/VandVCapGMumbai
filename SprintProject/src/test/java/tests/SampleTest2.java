package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseReport;

public class SampleTest2 extends BaseReport {

    @Test
    public void testCase3() {
    	ext_test= ext_reports.createTest("Sample Test 2","Test Case 3");

    }

    @Test
    public void testCase4() {
    	ext_test= ext_reports.createTest("Sample Test 2","Test Case 4");
    }
}
