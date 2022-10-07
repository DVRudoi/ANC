package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class SampleFactory {

    @Factory(dataProvider="dp")
    public Object[] createInstances(String str) {
        return new Object[] {new StartTest(str)};
    }
    @DataProvider(name="dp")
    public static Object[][] createData() {
        return new Object[][] {
                new Object[] { new String("Біфрен") },
                new Object[] { new String("Ангіноваг") }
        };
    }

}
