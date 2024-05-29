package stepDefinitions;

import io.cucumber.java.en.*;
import pages.ChangeThemePOM;

public class ChangeThemeSteps {
    ChangeThemePOM ct=new ChangeThemePOM();

    @When("Click on the profile, click on the settings button from the submenu that opens")
    public void clickOnTheProfileClickOnTheSettingsButtonFromTheSubmenuThatOpens() {

        ct.myClick(ct.profileBtn);
        ct.myClick(ct.settingsBtn);
    }

    @And("Theme one")
    public void themeOne() {
        ct.myClick(ct.themeBtn);
        ct.myClick(ct.purpleTheme);
        ct.myClick(ct.saveBtn);
    }

    @Then("Receive verification message")
    public void receiveVerificationMessage() {
        ct.verifyContainsText(ct.verifyTheme, "Profile successfully updated");
    }

    @And("Theme two")
    public void themeTwo() {
        ct.myClick(ct.themeBtn);
        ct.myClick(ct.darkPurpleTheme);
        ct.myClick(ct.saveBtn);
    }

    @And("Theme three")
    public void themeThree() {
        ct.myClick(ct.themeBtn);
        ct.myClick(ct.indigoTheme);
        ct.myClick(ct.saveBtn);
    }
}
