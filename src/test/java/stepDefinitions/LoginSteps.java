package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to the Campus")
    public void navigateToTheCampus() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @When("Enter the valid credentials and click the login button")
    public void enterTheValidCredentialsAndClickTheLoginButton() {
        dc.mySendKeys(dc.username, ConfigReader.getProperty("username"));
        dc.mySendKeys(dc.password, ConfigReader.getProperty("password"));
        dc.myClick(dc.loginBtn);
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        dc.verifyContainsText(dc.headText, "Internship");
    }

    @When("User attempts to login without entering credentials")
    public void userAttemptsToLoginWithoutEnteringCredentials() {
        dc.myClick(dc.loginBtn);
    }

    @Then("The system should display an error message indicating that credentials are required")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatCredentialsAreRequired() {
        dc.verifyContainsText(dc.emailReqError, "E-posta gereklidir");
        dc.verifyContainsText(dc.passwordReqError, "Şifre gereklidir");

    }

    @When("User enters only username and clicks the login button")
    public void userEntersOnlyUsernameAndClicksTheLoginButton() {
        dc.mySendKeys(dc.username, ConfigReader.getProperty("username"));
        dc.myClick(dc.loginBtn);
    }

    @Then("The system should display an error message indicating that password is required")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatPasswordIsRequired() {
        dc.verifyContainsText(dc.passwordReqError, "Şifre gereklidir");
    }

    @When("User enters only password and clicks the login button")
    public void userEntersOnlyPasswordAndClicksTheLoginButton() {
        dc.mySendKeys(dc.password, ConfigReader.getProperty("password"));
        dc.myClick(dc.loginBtn);
    }

    @Then("The system should display an error message indicating that username is required")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatUsernameIsRequired() {
        dc.verifyContainsText(dc.emailReqError, "E-posta gereklidir");
    }
}
