package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static Pages.BasePage.wait;

public class ProductPage {
    By NameProd = By.cssSelector("h2[class='name']");
    By PriceProd = By.cssSelector("h3[class='price-container']");
    By AddToCart = By.cssSelector("a[onclick*='addToCart']");



    WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AddTocart(){
        BasePage.WaitElement(AddToCart);
        driver.findElement(AddToCart).click();

    }

    public String PriceProd(){

        BasePage.WaitElement(PriceProd);
        String prodPrice = driver.findElement(PriceProd).getText();
        return prodPrice.substring(0,4);
    }

    public String NameProd(){
        BasePage.WaitElement(NameProd);
        String prodName = driver.findElement(NameProd).getText();
        return prodName;
    }

    public String AlertAcept(){
        BasePage.AlertIsPresent();
        String MsjPrompt = driver.switchTo().alert().getText();

        return MsjPrompt;
    }



}
