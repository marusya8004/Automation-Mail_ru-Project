package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpamPage {
    private WebDriver driver;

    public SpamPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//div[@class=\"llc__avatar\"])[1]")
    private WebElement thisLetter;

    @FindBy(xpath = "(//span[@class=\"button2__wrapper\"])[5]")
    private WebElement spamButton;

    @FindBy(xpath = "(//div[@class=\"nav__folder-name\"])[7]")
    private WebElement spamBox;

    @FindBy(xpath = "//span[@data-title-shortcut='Shift+J']")
    private WebElement notSpamButton;

    @FindBy(xpath = "//div[@class=\"octopus__icon octopus__icon_spam\"]")
    private WebElement returnSpamMessage;

    private Logger logger = Logger.getLogger(SpamPage.class);

    public void enterSpam(WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(thisLetter)).click();
        logger.info("choose this Letter");
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(spamButton)).click();
        logger.info("click to spamButton");
    }

    public void returnSpam(WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(spamBox)).click();
        logger.info("click to spamBox");
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(thisLetter)).click();
        logger.info("choose this Letter in the spamBox");
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(notSpamButton)).click();
        logger.info("click to notSpamButton");
    }

    public boolean returnSpamMessage(WebDriver driver) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(returnSpamMessage)).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
