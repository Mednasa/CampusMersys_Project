package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

import java.util.List;

public class HamburgerMenuMessaging {
    DialogContent dc = new DialogContent();

    @Given("User clicks on the hamburger menu button")
    public void UserClicksOnTheHamburgerMenuButton() {
        dc.myClick(dc.hamburgerMenu);
    }

    @When("From opened dropdown menu select messaging")
    public void fromOpenedDropdownMenuSelectMessaging() {
        dc.myClick(dc.HmbMessaging);
    }

    @And("Click on the New Message button")
    public void clickOnTheNewMessageButton() {
        dc.myClick(dc.newMessage);
    }

    @Then("User should be redirected to the new message page")
    public void userShouldBeRedirectedToTheNewMessagePage() {
        dc.wait.until(ExpectedConditions.urlContains("user-messages/new"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("user-messages/new"));
    }

    @When("User clicks on the Add Receiver button")
    public void userClicksOnTheAddReceiverButton() {
        dc.myClick(dc.addReceiverBtn);
    }

    @Then("The add receiver window should open, and the user should select receivers.")
    public void theAddReceiverWindowShouldOpenAndTheUserShouldSelectReceivers(DataTable dt) {
        List<List<String>> dtList = dt.asLists(String.class);

        dc.waitUntilElementToBeClickable(dc.addCloseBtn);

        for (int i = 0; i < dtList.size(); i++) {
            WebElement txtBot = dc.getWebElement(dtList.get(i).get(0));
            dc.mySendKeys(txtBot, dtList.get(i).get(1));
            for (int j = 0; j < 2; j++) {
                int ranInd = (int) (Math.random() * (dc.receiversCheckboxes.size() - 1)) + 1;
                dc.waitUntilElementToBeClickable(dc.receiversCheckboxes.get(1));
                dc.myClick(dc.receiversCheckboxes.get(ranInd));
            }
            dc.myClick(dc.addBtn);
        }
    }


    @When("User clicks on the Add & Close button")
    public void userClicksOnTheAddCloseButton() {
        dc.myClick(dc.addCloseBtn);
    }

}
