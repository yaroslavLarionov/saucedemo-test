package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    @BeforeMethod
    public void setUp(){
        initializeDriver();
        getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){
        driver.get().quit();
        driver.remove();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public void initializeDriver(){
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(options));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver.set(new InternetExplorerDriver());
                break;
            default:
                System.out.println("Wrong browser name was entered");
        }
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }




}
