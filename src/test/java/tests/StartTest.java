package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import runner.BaseTest;

public class StartTest extends BaseTest {
    private String medicine = "";

//    @Factory(dataProvider = "dp")
    public StartTest(String a) {
        this.medicine = a;

    }



//    @Test
//    public void testAkcii() {
//        String str = openBaseURL()
//                .clickAkcii()
//                .getPageText();
//
//        Assert.assertTrue(str.contains("Акції"));
//    }

//    @DataProvider(name = "dp")
//    public Object[][] dataProviderMethod() {
//
//        return new Object[][]{{"Біфрен"}, {"Ангіноваг"}};
//    }

    @Test//(dataProvider = "dp")
    public void testBuyMedicine() {
        openBaseURL()
                .inputSearch(medicine)
                .clickSearch()
                .clickMedicine(medicine)
                .clickBuy()
                .clickInBasket();
        System.out.println("add" + medicine);
//        Assert.assertTrue();
    }

    @Test(dependsOnMethods = "testBuyMedicine")
    public void test() {
        String actualResult = openBaseURL()
                .inputSearch(medicine)
                .clickSearch()
                .clickMedicine(medicine)
                .clickBuy()
                .clickInBasket()
                .clickDelete(medicine)
                .getTextBasketEmpty();

        Assert.assertEquals(actualResult, "Ваш кошик покупок пустий");
    }
}

