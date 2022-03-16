package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class IndexPage extends BasePage{

    By btnLaptops = By.xpath("//a[contains(text(),'Sony vaio i5')]");
    //div[@class='list-group']/child::a[contains(text(),'Laptops')]

    WebDriver driver;


  public IndexPage(WebDriver driver) {
      this.driver = driver;

  }


    public void EnterToLaptopSection(){
        BasePage.WaitElement(btnLaptops);
        driver.findElement(btnLaptops).click();

    }


}








