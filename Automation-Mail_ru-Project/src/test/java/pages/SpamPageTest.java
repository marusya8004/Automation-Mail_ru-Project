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

public class SpamPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private SpamPage spamPage;

    @BeforeClass
    public void beforeClass() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Configuration.getMainUrl());
        loginPage = new LoginPage(driver);
        Parsing parsing = new Parsing();
        loginPage.enterLoginAndPass(parsing.parse().get(1).getLogin(), parsing.parse().get(1).getPassword());
        spamPage = new SpamPage(driver);
    }

    @Test
    public void spamTest() {
        spamPage.enterSpam(driver);
        spamPage.returnSpam(driver);
        Assert.assertTrue(spamPage.returnSpamMessage(driver));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
