package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;



public class NavPage extends BasePage {

    By btnCartTab = By.xpath("//a[contains(text(),'Cart')]");
    WebDriver driver;



    public NavPage(WebDriver driver) {
        this.driver = driver;

    }


    public void WaitToClick(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void ToCartSection() throws InterruptedException{
        Thread.sleep(7000);
        driver.findElement(btnCartTab).click();
    }


}
