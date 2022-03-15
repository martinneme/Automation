package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CategorySection {
    By Firstproduct = By.xpath("//div[@id='tbodyid']/descendant::a[1]");

    WebDriver driver;


    public CategorySection(WebDriver driver) {
        this.driver = driver;
    }


    public void SelectToProduct(){
        BasePage.WaitElement(Firstproduct);
        driver.findElement(Firstproduct).click();

    }


}
