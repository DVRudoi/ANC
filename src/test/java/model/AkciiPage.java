package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.BaseModel;

public class AkciiPage extends BaseModel {
    @FindBy(xpath = "//h2")
    private WebElement h2;

    public AkciiPage(WebDriver driver) {
        super(driver);
    }

    public String getPageText(){

        return getWait20().until(ExpectedConditions.visibilityOf(h2)).getText();
    }
}
