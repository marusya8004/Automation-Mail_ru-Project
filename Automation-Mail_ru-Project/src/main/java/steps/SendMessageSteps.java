package steps;

import core.browser.SingletonWebDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mysql.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SendMessagePage;

public class SendMessageSteps {

    private SendMessagePage sendMessagePage;
    private WebDriver driver;
    private LoginSteps loginSteps;
    private UserData userData = new UserData();

    public SendMessageSteps() {
        loginSteps = new LoginSteps();
        driver = loginSteps.getDriver();
        sendMessagePage = new SendMessagePage(driver);

    }

    @Given("^I go Inbox Page$")
    public void GoInboxPage() {
        loginSteps.loadMainPage();
        loginSteps.loginAsCorrectUser();
    }

    @When("^I click button 'Write message'$")
    public void clickWriteMessage() {
        sendMessagePage.sendMessage(userData.getEmail(), userData.getText(), driver);
    }

    @When("^I input emails$")
    public void i_input_emails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
    }

    @When("^I input text$")
    public void i_input_text() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
    }

    @When("^I click 'Send message'$")
    public void i_click_Send_message() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
    }

    @Then("^I see 'Email send'$")
    public void seeEmailSend() {
        Assert.assertTrue(sendMessagePage.messageAlert(driver));
    }

    @After
    public void afterClass() {
        SingletonWebDriver.quitDriver();
    }
}
