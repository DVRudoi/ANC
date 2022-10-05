package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import runner.BaseTest;

public class StartTest extends BaseTest {
    @Test
    public void testAkcii() {
        String str = openBaseURL()
                .clickAkcii()
                .getPageText();

        Assert.assertTrue(str.contains("Акції"));
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {

        return new Object[][]{{"Біфрен"}, {"Ангіноваг"}};
    }

    @Test(dataProvider = "data-provider")
    public void testBuyMedicine(String str) {
        openBaseURL()
                .inputSearch(str)
                .clickSearch()
                .clickMedicine(str)
                .clickBuy()
                .clickInBasket();
        System.out.println("add" + str);
//        Assert.assertTrue();
    }

    @Test(dataProvider = "data-provider", dependsOnMethods = "testBuyMedicine")
    public void test(String str) {
        String actualResult = openBaseURL()
                .clickBasket()
                .clickDelete(str)
                .getTextBasketEmpty();

        Assert.assertEquals(actualResult, "Ваш кошик покупок пустий");
    }
}
