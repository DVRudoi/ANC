package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.BaseModel;

public class StartPage extends BaseModel {
    @FindBy(linkText = "Акції")
    private WebElement akcii;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public AkciiPage clickAkcii(){
        akcii.click();

        return new AkciiPage(getDriver());
    }
}
