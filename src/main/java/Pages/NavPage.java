package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;



public class NavPage {

    By btnCartTab = By.xpath("//a[contains(text(),'Cart')]");
    WebDriver driver;



    public NavPage(WebDriver driver) {
        this.driver = driver;

    }


    public void WaitToClick(By element){
        FluentWait waitF = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(10));
        waitF.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void ToCartSection(){
        WaitToClick(btnCartTab);
        driver.findElement(btnCartTab).click();
    }


}
