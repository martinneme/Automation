package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static Pages.BasePage.wait;

public class ProductPage {
    By NameProd = By.cssSelector("h2[class='name']");
    By PriceProd = By.cssSelector("h3[class='price-container']");
    By AddToCart = By.cssSelector("a[onclick*='addToCart']");
    By btnCartTab = By.xpath("//a[contains(text(),'Cart')]");


    WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void AddTocart(){
        BasePage.WaitElement(AddToCart);
        driver.findElement(AddToCart).click();

    }

    public void SaveAndShowProdDetails(){
        BasePage.WaitElement(NameProd);
        String prodName = driver.findElement(NameProd).getText();
        BasePage.WaitElement(PriceProd);
        String prodPrice = driver.findElement(PriceProd).getText();
        System.out.println("El producto "+prodName+" cuesta "+prodPrice.substring(0,4));
    }

    public String AlertAcept(){
        BasePage.AlertIsPresent();
        String MsjPrompt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return MsjPrompt;
    }

    public void WaitToClick(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void ToCartSection(){
        WaitToClick(btnCartTab);
        driver.findElement(btnCartTab).click();
    }


}
