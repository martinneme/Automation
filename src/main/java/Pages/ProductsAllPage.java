package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class ProductsAllPage {


    WebDriver driver;


    public ProductsAllPage(WebDriver driver) {
        this.driver = driver;
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
