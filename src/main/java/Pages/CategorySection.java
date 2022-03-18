package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CategorySection {
    By Firstproduct = By.xpath("//a[contains(text(),'Sony vaio i5')]");

    WebDriver driver;


    public CategorySection(WebDriver driver) {
        this.driver = driver;
    }


    public void SelectToProduct(){
        BasePage.WaitElement(Firstproduct);
        driver.findElement(Firstproduct).click();

    }


}
