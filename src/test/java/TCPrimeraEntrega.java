
import Pages.*;
import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import Pages.CategorySection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class TCPrimeraEntrega {
    private String URLMarket = PropertiesFile.getProperty("URLdemo");
    private WebDriver driver = DriverFactory.getWebDriverBrowser();


    @Test
    public void NavigateToMarketDemoblaze() throws InterruptedException {


        IndexPage index = new IndexPage(driver);
        CategorySection categorySection = new CategorySection(driver);
        ProductPage productPage = new ProductPage(driver);
        NavPage navePage = new NavPage(driver);
        CartPage cartPage = new CartPage(driver);
        ModalOrderPage modalOrderPage = new ModalOrderPage(driver);
        ModalConfirmPage modalConfirmPage = new ModalConfirmPage(driver);

        FluentWait waitf = new FluentWait(driver);
        waitf.withTimeout(Duration.ofSeconds(25));
        waitf.pollingEvery(Duration.ofSeconds(2));


        driver.get(URLMarket);

        index.EnterToLaptopSection();
        categorySection.SelectToProduct();
        // Thread.sleep(7000);
        String priceProd = productPage.PriceProd();
        String nameProd = productPage.NameProd();

        Assert.assertEquals("790", priceProd);
        Assert.assertEquals("Sony vaio i5", nameProd);

        productPage.AddTocart();

        Thread.sleep(7000);
        waitf.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Product added", alert.getText());
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(5000);

        navePage.ToCartSection();


        Assert.assertEquals(nameProd, cartPage.GetTitleProd());
        Assert.assertEquals(nameProd, cartPage.GetPriceProd());

        cartPage.ClickBtnPlacerOrder();

        modalOrderPage.FormOrder("Martin", "Argentina", "Avellaneda", "1234567894545", "08", "2025");

        Assert.assertEquals(modalConfirmPage.GetMsjConfirm(), "Thank you for your purchase!");
        modalConfirmPage.ClickConfirmOk();

        driver.quit();
    }


}
