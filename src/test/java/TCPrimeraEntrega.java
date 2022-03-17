
import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.CategorySection;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class TCPrimeraEntrega {
    private String URLMarket = PropertiesFile.getProperty("URLdemo");
    private WebDriver driver = DriverFactory.getWebDriverBrowser();


    @Test
    public void NavigateToMarketDemoblaze()  {


      
        IndexPage index = new IndexPage(driver);
        CategorySection categorySection = new CategorySection(driver);
        ProductPage productPage = new ProductPage(driver);
        NavPage navePage = new NavPage(driver);

        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(45));
        wait.pollingEvery(Duration.ofSeconds(5));


        driver.get(URLMarket);
        index.EnterToLaptopSection();
        categorySection.SelectToProduct();
        productPage.SaveAndShowProdDetails();
        productPage.AddTocart();
        wait.until(ExpectedConditions.alertIsPresent());
        String MsjPrompt = driver.switchTo().alert().getText();
        Assert.assertEquals("Product added",MsjPrompt);
        navePage.ToCartSection();
        driver.quit();
    }



}
