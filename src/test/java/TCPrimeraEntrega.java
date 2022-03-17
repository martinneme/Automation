
import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Pages.CategorySection;

import java.time.Duration;



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
        wait.withTimeout(Duration.ofSeconds(25));
        wait.pollingEvery(Duration.ofSeconds(5));


        driver.get(URLMarket);
        index.EnterToLaptopSection();
        categorySection.SelectToProduct();
        String priceProd= productPage.PriceProd();
        String nameProd = productPage.NameProd();
        Assert.assertEquals("$790",priceProd);
        Assert.assertEquals("Sony vaio i5",nameProd);
        productPage.AddTocart();
        wait.until(ExpectedConditions.alertIsPresent());
        String MsjPrompt = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals("Product added",MsjPrompt);
        navePage.ToCartSection();
        driver.quit();
    }



}
