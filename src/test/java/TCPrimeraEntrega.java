
import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.CategorySection;

import java.util.concurrent.TimeUnit;


public class TCPrimeraEntrega {
    private String URLMarket = PropertiesFile.getProperty("URLdemo");
    private WebDriver driver = DriverFactory.getWebDriverBrowser();


    @Test
    public void NavigateToMarketDemoblaze()  {


      
        IndexPage index = new IndexPage(driver);
        CategorySection categorySection = new CategorySection(driver);
        ProductPage productPage = new ProductPage(driver);


        driver.get(URLMarket);
        index.EnterToLaptopSection();
        categorySection.SelectToProduct();
        productPage.SaveAndShowProdDetails();
        productPage.AddTocart();
        String ProdAlert = productPage.AlertAcept();
        Assert.assertEquals("Product added",ProdAlert);
        System.out.println("Llego aca");
        productPage.ToCartSection();
        driver.quit();
    }



}
