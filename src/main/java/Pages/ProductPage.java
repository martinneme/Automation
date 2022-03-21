package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

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

        return prodPrice.substring(prodPrice.indexOf("$") + 1,prodPrice.indexOf(" "));
    }


    public String NameProd(){
        BasePage.WaitElement(NameProd);
        String prodName = driver.findElement(NameProd).getText();
        return prodName;
    }


    public WebElement getPriceRange(int priceMin,int priceMax){
        int price;

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("2017 Dell 15.6 Inch")));
        List<WebElement>elementsPrice = driver.findElements(By.xpath("//h5[contains(text(),'$')]"));

        for (WebElement priceElement:elementsPrice) {
            price = Integer.parseInt(priceElement.getText().replace("$",""));

            if(price> priceMin && price < priceMax){
                return priceElement;
            }
        }
    return null;
    }

    public void ClickToProductRange(int priceMin,int priceMax){
        getPriceRange(priceMin,priceMax).findElement(By.xpath(".//preceding-sibling::h4")).click();
    }



}
