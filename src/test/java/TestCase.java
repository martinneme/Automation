import Utility.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase {

    private String URlBase = "http://www.google.com.ar";
    private String URLMarket ="https://demoblaze.com/index.html";
    private WebDriver driver = DriverFactory.getWebDriverBrowser();

    @Test
    public void NavigateToGoogle(){
        driver.navigate().to(URlBase);
        WebElement searchInput = driver.findElement(By.className("gLFyf"));
        searchInput.sendKeys("Selenium", Keys.ENTER);
        Assert.assertEquals("Selenium - Buscar con Google", driver.getTitle());
        driver.quit();
    }

    @Test
    public void NavigateToMarketDemoblaze(){
        driver.navigate().to(URLMarket);
        driver.findElement(By.id("next2")).click();
        driver.quit();

    }

}

