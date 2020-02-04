package pages;

import core.browser.DriverManager;
import core.browser.DriverManagerFactory;
import core.browser.DriverType;
import core.configuration.Configuration;
import core.parser.runner.Parsing;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private Parsing parsing;

    @BeforeClass
    public void beforeClass() {
        DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver=driverManager.getDriver();
        driver.get(Configuration.getMainUrl());
        parsing = new Parsing();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        loginPage.enterLoginAndPass(parsing.parse().get(1).getLogin(), parsing.parse().get(1).getPassword());
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}