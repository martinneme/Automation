package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CartPage  {

    By btnPlaceOrder = By.xpath("//button[contains(text(),'Place Order')]");

    By TitleProdCart = By.xpath("//tr[@class='success']/td[2]");
    By PriceCart = By.xpath("//tr[@class='success']/td[3]");


    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;

    }

    public String GetTitleProd() {
        return driver.findElement(TitleProdCart).getText();

    }

    public String GetPriceProd() {
        return driver.findElement(PriceCart).getText();

    }

    public void ClickBtnPlacerOrder(){
        driver.findElement(btnPlaceOrder).click();
    }


}
