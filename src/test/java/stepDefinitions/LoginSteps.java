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
}
