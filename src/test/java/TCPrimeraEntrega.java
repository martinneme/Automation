
import Data.DataProviderClass;
import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class TCPrimeraEntrega {
    private String URLMarket = PropertiesFile.getProperty("URLdemo");
    private WebDriver driver = DriverFactory.getWebDriverBrowser();

    @BeforeTest
    public void beforeTest() {
        System.out.println("/**  STARTING TO TEST    /**");
        driver.get(URLMarket);
    }



    @Test(dataProvider = "getDataForm", dataProviderClass = DataProviderClass.class)
    public void NavigateToMarketDemoblaze(String nameParam, String countryPram, String cityPram, String creditCardPram,String monthParam,String yearParam){


        IndexPage index = new IndexPage(driver);
        ProductPage productPage = new ProductPage(driver);
        NavPage navePage = new NavPage(driver);
        CartPage cartPage = new CartPage(driver);
        ModalOrderPage modalOrderPage = new ModalOrderPage(driver);
        ModalConfirmPage modalConfirmPage = new ModalConfirmPage(driver);


        FluentWait waitf = new FluentWait(driver);
        waitf.withTimeout(Duration.ofSeconds(25));
        waitf.pollingEvery(Duration.ofSeconds(2));




        index.EnterToLaptopSection();
        productPage.ClickToProductRange(780,890);

        String priceProd = productPage.PriceProd();
        String nameProd = productPage.NameProd();

        Assert.assertEquals("790", priceProd);
        Assert.assertEquals("Sony vaio i5", nameProd);

        productPage.AddTocart();


        waitf.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Product added", alert.getText());
        alert.accept();


        navePage.ToCartSection();


        Assert.assertEquals(nameProd, cartPage.GetTitleProd());
        Assert.assertEquals(priceProd, cartPage.GetPriceProd());

        cartPage.ClickBtnPlacerOrder();

        modalOrderPage.FormOrder( nameParam,  countryPram,  cityPram,  creditCardPram,  monthParam, yearParam);

        Assert.assertEquals(modalConfirmPage.GetMsjConfirm(), "Thank you for your purchase!");
        Assert.assertEquals( modalConfirmPage.getTxtConfirm().contains(cartPage.GetPriceProd()),true);
        Assert.assertEquals( modalConfirmPage.getTxtConfirm().contains(creditCardPram),true);
        Assert.assertEquals( modalConfirmPage.getTxtConfirm().contains(nameParam),true);

        modalConfirmPage.ClickConfirmOk();



    }

    @AfterTest
    public void AfterTest(){
        System.out.println("/**  END TO TEST    /**");
        driver.quit();
    }


}
