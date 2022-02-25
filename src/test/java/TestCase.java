import Utility.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase {

    private String URlBase = "http://www.google.com.ar";
    private String URLMarket ="https://demoblaze.com/index.html";
    private String URlDesafio = "https://petstore.octoperf.com/actions/Account.action?newAccountForm=";
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
        driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
        driver.quit();
    }

    @Test
    public void desafio(){
        driver.navigate().to(URlDesafio);
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("17");;
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("ContraseñaNueva");
        driver.findElement(By.cssSelector("input[name=repeatedPassword]")).sendKeys("ContraseñaNueva");

        driver.findElement(By.cssSelector("input[name='account.firstName']")).sendKeys("Martin");
        driver.findElement(By.cssSelector("input[name='account.lastName']")).sendKeys("Neme");

        driver.findElement(By.cssSelector("input[name='account.email']")).sendKeys("correo@test.com");
        driver.findElement(By.cssSelector("input[name='account.phone']")).sendKeys("1532125458");
        driver.findElement(By.cssSelector("input[name='account.address1']")).sendKeys("calle falsa 123");
        driver.findElement(By.cssSelector("input[name='account.address2']")).sendKeys("calle falsa 456");
        driver.findElement(By.cssSelector("input[name='account.city']")).sendKeys("Sarandí");
        driver.findElement(By.cssSelector("input[name='account.state']")).sendKeys("Buenos aires");
        driver.findElement(By.cssSelector("input[name='account.zip']")).sendKeys("1872");
        driver.findElement(By.cssSelector("input[name='account.country']")).sendKeys("Avellaneda");

        Select Lenguage = new Select(driver.findElement(By.name("account.languagePreference")));
        Lenguage.selectByValue("japanese");
        Select Category = new Select(driver.findElement(By.name("account.favouriteCategoryId")));
        Category.selectByValue("DOGS");
        WebElement ListOption = driver.findElement(By.cssSelector("input[name='account.listOption']"));
        ListOption.click();
        WebElement bannerOP = driver.findElement(By.cssSelector("input[name='account.bannerOption']"));
        bannerOP.click();
        driver.quit();







    }

}

