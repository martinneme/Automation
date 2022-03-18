package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ModalConfirmPage extends BasePage {

    By msjH2 = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/child::h2");
    By btnConfirm = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");


    WebDriver driver;

    public ModalConfirmPage(WebDriver driver) {
        this.driver = driver;

    }

    public String GetMsjConfirm(){
        return driver.findElement(msjH2).getText();

    }

    public void ClickConfirmOk(){
        driver.findElement(btnConfirm).click();
    }






}
