package steps;

import core.browser.SingletonWebDriver;
import core.configuration.Configuration;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mysql.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;
    private WebDriver driver;
    private UserData userData = new UserData();

    public LoginSteps() {

        driver = SingletonWebDriver.getInstance();
        loginPage = new LoginPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        driver.get(Configuration.getMainUrl());
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        loginPage.enterLoginAndPass(userData.getLogin(), userData.getPassword());
    }

    @Then("^I see logout link$")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @After
    public void afterClass() {
        SingletonWebDriver.quitDriver();
    }
}