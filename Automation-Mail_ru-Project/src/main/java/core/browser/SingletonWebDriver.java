package core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {
    private static WebDriver driver;

    private SingletonWebDriver() {
    }

    public static WebDriver getInstance() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://mail.ru");
        }
        return driver;
    }

        public static void quitDriver() {
            if (null != driver) {
                driver.quit();
                driver = null;
            }

        }
    }



