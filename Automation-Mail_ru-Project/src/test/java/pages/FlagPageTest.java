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


public class FlagPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private FlagPage flagPage;

    @BeforeClass
    public void beforeClass() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {

        DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Configuration.getMainUrl());
        loginPage = new LoginPage(driver);
        Parsing parsing = new Parsing();
        flagPage = new FlagPage(driver);
        loginPage.enterLoginAndPass(parsing.parse().get(1).getLogin(), parsing.parse().get(1).getPassword());
    }

    @Test
    public void flagIsPresentTest() {
        flagPage.selectFlag(driver, 3);
        Assert.assertTrue(flagPage.flagIsPresent(3));
    }

    @Test
    public void flagIsNotPresentTest() {
        flagPage.deSelectFlag(driver);
        Assert.assertFalse(flagPage.flagIsNotPresent());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}