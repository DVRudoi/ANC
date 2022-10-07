package runner;

import model.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;


    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 20);
        }

        return wait;
    }

    protected Actions getActions() {
        if(actions == null) {
            actions = new Actions(driver);
        }

        return actions;
    }

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        getWeb();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }
    @BeforeClass(groups = {"l"})
    protected void beforeMethodL() {
        driver = BaseUtils.createDriver();
        getWeb();
    }

    @AfterClass(groups = {"l"})
    protected void afterMethodL() {
        driver.quit();
    }

    public StartPage getWeb() {
        getDriver().get("https://anc.ua/");
        return new StartPage(getDriver());
    }




}
