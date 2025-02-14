package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseReport;

public class SampleTest2 extends BaseReport {

    @Test
    public void testCase3() {
        ext_test.info("Executing testCase3...");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase4() {
        ext_test.info("Executing testCase4...");
        Assert.assertFalse(false);
    }
}
