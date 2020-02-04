package steps;

import core.browser.SingletonWebDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SpamPage;

public class SpamSteps {
    private SpamPage spamPage;
    private WebDriver driver;
    private LoginSteps loginSteps;

    public SpamSteps() {
        loginSteps = new LoginSteps();
        driver = loginSteps.getDriver();
        spamPage = new SpamPage(driver);
    }

    @Given("^I am on inbox page$")
    public void OnInboxPage() {
        loginSteps.loadMainPage();
        loginSteps.loginAsCorrectUser();
    }

    @When("^I choose this letter$")
    public void chooseThisLetter() {
        spamPage.enterSpam(driver);
    }

    @Then("^I click button 'to spam'$")
    public void i_click_button_to_spam() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^I am in spam pocket$")
    public void inSpamPocket() {
        loginSteps.loadMainPage();
        loginSteps.loginAsCorrectUser();
    }

    @Then("^I click this letter$")
    public void ClickThisLetter() {
        spamPage.returnSpam(driver);
    }

    @Then("^I click button 'not spam'$")
    public void i_click_button_not_spam() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @And("^I see message 'in your mail no spam'$")
    public void seeMessageNoSpam() {
        Assert.assertTrue(spamPage.returnSpamMessage(driver));
    }

    @After
    public void afterClass() {
        SingletonWebDriver.quitDriver();
    }
}