package tests;

import model.StartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import runner.BaseTest;

public class StartTest extends BaseTest {
    private String medicine = "";

    public StartTest(String a) {
        this.medicine = a;
    }

    @Test(groups = {"l"})
    public void testBuyMedicine() {
        new StartPage(getDriver())
                .inputSearch(medicine)
                .clickSearch()
                .clickMedicine(medicine)
                .clickBuy()
                .clickInBasket();
//        Assert.assertTrue();
    }

    @Test(groups = {"l"}, dependsOnMethods = "testBuyMedicine")
    public void test() {
        String actualResult = new StartPage(getDriver())
                .clickBasket()
                .clickDelete(medicine)
                .getTextBasketEmpty();

        Assert.assertEquals(actualResult, "Ваш кошик покупок пустий");
    }
}

