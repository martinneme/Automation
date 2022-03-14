import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class TCPrimeraEntrega {
    private String URLMarket = PropertiesFile.getProperty("URLdemo");
    private WebDriver driver = DriverFactory.getWebDriverBrowser();


    @Test
    public void NavigateToMarketDemoblaze()  {


        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.navigate().to(URLMarket);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-group']/child::a[contains(text(),'Laptops')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']/descendant::a[1]"))).click();;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='name']")));
        String nameProd  = driver.findElement(By.cssSelector("h2[class='name']")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[class='price-container']")));
        String  priceProd = driver.findElement(By.cssSelector("h3[class='price-container']")).getText();
        System.out.println("El producto "+nameProd+" cuesta "+priceProd.substring(0,4));
        driver.findElement(By.cssSelector("a[onclick*='addToCart']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String MsjPrompt = driver.switchTo().alert().getText();
        Assert.assertEquals("Product added",MsjPrompt);

        driver.quit();
    }



}
