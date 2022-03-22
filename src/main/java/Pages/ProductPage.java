package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

        return prodPrice.substring(prodPrice.indexOf("$") + 1,prodPrice.indexOf(" "));
    }


    public String NameProd(){
        BasePage.WaitElement(NameProd);
        return driver.findElement(NameProd).getText();
    }






}
