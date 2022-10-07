package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.BaseModel;

public class StartPage extends BasePage {


    @FindBy(linkText = "Акції")
    private WebElement akcii;

    @FindBy(id = "input-search")
    private WebElement search;

    @FindBy(xpath = "//button[@aria-label='search']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(.,'Купити')]")
    private WebElement buttonBuy;

    @FindBy(xpath = "//a[contains(.,'У кошик')]")
    private WebElement buttonInBasket;

    @FindBy(xpath = "//span[contains(.,'Кошик')]")
    private WebElement buttonBasket;

    @FindBy(xpath = "//p[text()='Ваш кошик покупок пустий']")
    private WebElement basketInfo;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public AkciiPage clickAkcii() {
        akcii.click();

        return new AkciiPage(getDriver());
    }

    public StartPage inputSearch(String input) {
        search.sendKeys(input);

        return this;
    }

    public StartPage clickSearch() {
        searchButton.click();

        return this;
    }

    public StartPage clickMedicine(String medicine) {
        getDriver().findElement(By.xpath(String.format("//div/a[text()[contains(.,'%s')]]", medicine))).click();

        return this;
    }

    public StartPage clickBuy() {
        buttonBuy.click();

        return this;
    }

    public StartPage clickInBasket(){
        buttonInBasket.click();

        return this;
    }

    public StartPage clickBasket(){
        buttonBasket.click();

        return this;
    }

    public StartPage clickDelete(String medicine){
        getDriver().findElement(By.xpath(String.format("//div[@class='cart-page--item-main-container']//a[text()[contains(.,'%s')]]//../following-sibling::div[@class='checkout-page--pharmacy-price-container']/button", medicine))).click();

        return this;
    }

    public String getTextBasketEmpty(){

        return basketInfo.getText();
    }
}
