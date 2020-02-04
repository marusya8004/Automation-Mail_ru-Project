package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    private Logger logger = Logger.getLogger(LoginPage.class);

    public void enterLoginAndPass(String login, String password) {
        loginField.clear();
        loginField.sendKeys(login);
        buttonEnter.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(emailField)).clear();
        emailField.sendKeys(password);
        buttonEnter.click();
        logger.info("click to buttonEnter");
    }

    public boolean logoutLinkPresents() {
        return new WebDriverWait(driver, 15).until(ExpectedConditions
                .elementToBeClickable(logoutLink)).isDisplayed();
    }




}
