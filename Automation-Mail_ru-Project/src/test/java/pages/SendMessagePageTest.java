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

public class SendMessagePageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private SendMessagePage sendMessagePage;
    private Parsing parsing;

    @BeforeClass
    public void beforeClass() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        DriverManager driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Configuration.getMainUrl());
        parsing = new Parsing();
        loginPage = new LoginPage(driver);
        sendMessagePage = new SendMessagePage(driver);
        loginPage.enterLoginAndPass(parsing.parse().get(1).getLogin(), parsing.parse().get(1).getPassword());

    }

    @Test
    public void sendMessageTest() throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
        sendMessagePage.sendMessage(parsing.parse().get(0).getE_mail(), "Hello, how are you?", driver);
            Assert.assertTrue(sendMessagePage.messageAlert(driver));
    }

        @AfterClass
        public void afterClass () {
            driver.quit();
        }
    }


