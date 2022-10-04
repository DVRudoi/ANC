package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class StartTest extends BaseTest {
    @Test
    public void testAkcii(){
        String str = openBaseURL()
                .clickAkcii()
                .getPageText();

        Assert.assertTrue(str.contains("Акції"));
    }
}
