package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ModalOrderPage extends BasePage {

    By name = By.xpath("//input[@id='name']");

    By country = By.xpath("//input[@id='country']");
    By city = By.xpath("//input[@id='city']");
    By creditCard = By.xpath("//input[@id='card']");
    By month = By.xpath("//input[@id='month']");
    By year = By.xpath("//input[@id='year']");

    By btnPurchase = By.xpath("//button[@onclick='purchaseOrder()']");


    WebDriver driver;

    public ModalOrderPage(WebDriver driver) {
        this.driver = driver;

    }

    public void FormOrder(String nameParam, String countryPram, String cityPram, String creditCardPram,String monthParam,String yearParam){
        wait.until(ExpectedConditions.elementToBeClickable(name));
        driver.findElement(name).sendKeys(nameParam);
        driver.findElement(country).sendKeys(countryPram);
        driver.findElement(city).sendKeys(cityPram);
        driver.findElement(creditCard).sendKeys(creditCardPram);
        driver.findElement(month).sendKeys(monthParam);
        driver.findElement(year).sendKeys(yearParam);

        driver.findElement(btnPurchase).click();

    }




}
