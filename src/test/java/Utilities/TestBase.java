package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class TestBase {
    WebDriver driver = null;

    public WebDriver WebDriverManager() {

        try {
            WebDriver driver = null;
            FileInputStream fileInput = new FileInputStream(
                    System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties prop = new Properties();
            prop.load(fileInput);
            String platform = System.getenv("Platform") != null ? System.getenv("Platform") : prop.getProperty("Platform");
            String browser = System.getenv("browser") != null ? System.getenv("browser") : prop.getProperty("browser");

            if (platform.toLowerCase().equals("windows")) {
                DesktopOptions option = new DesktopOptions();
                option.setApplicationPath("C:\\Users\\Sumit.Goswami\\AppData\\Local\\slack\\slack.exe");
             // WiniumDriver Driver1 = new WiniumDriver(new URL("http://localhost:9999"), option);
                driver = new WiniumDriver(new URL("http://localhost:9999"), option);
            }
            else if(platform.toLowerCase().equals("mobile")){
                String userName = "sumitsharma_OSNU36";
                String automationkey = "ALU5nCYshvqQEuyQy7L7";
                String framework ="cucumber-testng";
                String Url ="https://"+userName+":"+automationkey+"@hub-cloud.browserstack.com/wd/hub";
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("deviceName","Samsung Galaxy S23 Ultra");
                caps.setCapability("osVersion","13.0");
                caps.setCapability("browserName","Chrome");
                caps.setCapability("deviceOrientation","portrait");
                driver =new RemoteWebDriver(new URL(Url),caps);
            }
            else {
                if (driver == null) {
                    if (browser.equalsIgnoreCase("chrome")) {
                        WebDriverManager.chromedriver().setup();
                        System.setProperty("webdriver.http.factory", "jdk-http-client");
//                        ChromeOptions objChromeOptions = new ChromeOptions();
//                        objChromeOptions.addArguments("--remote-allows-origins=*");
//                        System.setProperty("webdriver.chrome.driver", "D:\\Users\\sumitg\\Desktop\\ChromeDriver\\chromedriver.exe");
                        driver = new ChromeDriver();// driver gets the life
                        driver.manage().window().maximize();

                    } else if (browser.equalsIgnoreCase("firefox")) {
                        WebDriverManager.firefoxdriver().setup();
//				System.setProperty("webdriver.gecko.driver", "//Users//rahulshetty//Downloads//geckodriver 5");
                        driver = new FirefoxDriver();
                    } else if (browser.equalsIgnoreCase("msedge")) {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                    }
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                }
            }

            return driver;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void LaunchUrl(String url, WebDriver driver) {
        try {
            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
