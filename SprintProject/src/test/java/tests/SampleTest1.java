package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseReport;

public class SampleTest1 extends BaseReport {

    @Test
    public void testCase1() {
        ext_test.info("Executing testCase1...");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase2() {
        ext_test.info("Executing testCase2...");
        Assert.fail("Failing testCase2 for testing reporting.");
    }
}
