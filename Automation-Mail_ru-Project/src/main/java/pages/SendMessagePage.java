package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessagePage {
    private WebDriver driver;

    public SendMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@title='Написать письмо']")
    private WebElement messageButton;

    @FindBy(xpath = "//input[@class=\"container--H9L5q size_s--3_M-_\"]")
    private WebElement mailAdress;

    @FindBy(xpath = "/html/body/div[16]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")
    private WebElement writeText;

    @FindBy(xpath = "//span[@title=\"Отправить\"]")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class=\"layer__header\"]")
    private WebElement sendAlert;

    private Logger logger = Logger.getLogger(SendMessagePage.class);

    public void sendMessage(String emails, String text, WebDriver driver) {

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(messageButton)).click();
        logger.info("click to messageButton");

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(mailAdress)).sendKeys(emails);
        logger.info("write a mail address");

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(writeText)).sendKeys(text);
        logger.info("write the text");

        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(sendButton)).click();
        logger.info("click to sendButton");
    }

    public boolean messageAlert(WebDriver driver) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(sendAlert)).isDisplayed();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

