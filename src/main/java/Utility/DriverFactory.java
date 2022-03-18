package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
            System.setProperty("webdriver.gecko.driver", pathDriver +"geckodriver.exe");
            driver = new FirefoxDriver();
        };
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);


        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

}
