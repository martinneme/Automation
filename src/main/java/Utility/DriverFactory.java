package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverFactory{
    private static String browser;
    public static WebDriver driver;
    public static String pathDriver = "src/main/resources/drivers/";
    public static WebDriverWait wait;


    public static WebDriver getWebDriverBrowser(){

        browser = PropertiesFile.getProperty("browser");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",pathDriver + "chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals("edge")){
            System.setProperty("webdriver.edge.driver", pathDriver + "msedgedriver.exe");
            driver = new EdgeDriver();
        }else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", pathDriver +"geckofriver.exe");
            driver = new FirefoxDriver();
        };

        driver.manage().timeouts().implicitlyWait(15   , TimeUnit.SECONDS);


        return driver;
    }

    public static WebDriverWait getWait() {
        wait = new WebDriverWait(driver, 10);
        return wait;
    }

}
