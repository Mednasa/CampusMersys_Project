package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteMessagingContent;

import java.util.Random;

public class US_006_Steps {
    DeleteMessagingContent dmc = new DeleteMessagingContent();

    @When("Click on the outbox in the messaging section in the hamburger menu")
    public void clickOnTheOutboxInTheMessagingSectionInTheHamburgerMenu() {
        dmc.myClick(dmc.hamburgerMenu);
        dmc.hoverOver(dmc.hamburgerMenuMessaging);
        dmc.myClick(dmc.messagingOutbox);

    }

    @Then("Delete the message and verify whether the message has been deleted")
    public void deleteTheMessageAndVerifyWhetherTheMessageHasBeenDeleted() {

        dmc.myClick(dmc.trashBoxBtn);
        dmc.myClick(dmc.trashConfirmYesBtn);
        dmc.verifyContainsText(dmc.verify, "Message successfully moved to trash");
    }
}
