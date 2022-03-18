package Pages;

import Utility.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    static WebDriverWait wait;

    public BasePage(){
        wait = DriverFactory.getWait();
    }

    public static void WaitElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void AlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }




}
