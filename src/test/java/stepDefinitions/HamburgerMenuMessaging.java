package stepDefinitions;

import com.github.javafaker.Faker;
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

public class HamburgerMenuMessaging extends DialogContent {
    Faker faker = new Faker();

    @Given("User clicks on the hamburger menu button")
    public void UserClicksOnTheHamburgerMenuButton() {
        myClick(hamburgerMenu);
    }

    @When("From opened dropdown menu select messaging")
    public void fromOpenedDropdownMenuSelectMessaging() {
        myClick(HmbMessaging);
    }

    @And("Click on the New Message button")
    public void clickOnTheNewMessageButton() {
        myClick(newMessage);
    }

    @Then("User should be redirected to the new message page")
    public void userShouldBeRedirectedToTheNewMessagePage() {
        wait.until(ExpectedConditions.urlContains("user-messages/new"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("user-messages/new"));
    }

    @When("User clicks on the Add Receiver button")
    public void userClicksOnTheAddReceiverButton() {
        myClick(addReceiverBtn);
    }

    @Then("The add receiver window should open, and the user should select receivers.")
    public void theAddReceiverWindowShouldOpenAndTheUserShouldSelectReceivers(DataTable dt) {
        List<List<String>> dtList = dt.asLists(String.class);

        for (int i = 0; i < dtList.size(); i++) {
            WebElement txtBot = getWebElement(dtList.get(i).get(0));
            mySendKeys(txtBot, dtList.get(i).get(1));
            wait.until(ExpectedConditions.stalenessOf(userImgs.get(0)));
            for (int j = 1; j < 3; j++) {
                waitUntilVisibilityOf(receiversCheckboxes.get(j));
                myClick(receiversCheckboxes.get(j));
            }
            myClick(addBtn);
        }
    }

    @And("User clicks on the Add & Close button and user should see the success message")
    public void userClicksOnTheAddCloseButtonAndUserShouldSeeTheSuccessMessage() {
        myClick(addBtn);
        myClick(addCloseBtn);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        verifyContainsText(successMsg, "successfully added");
    }

    @Then("Enter subject to the new message")
    public void enterSubjectToTheNewMessage() {
        mySendKeys(subjectBox, faker.lorem().word());
    }

    @And("Enter message to the text and attach a file to it.")
    public void enterMessageToTheTextAndAttachAFileToIt() {
        GWD.getDriver().switchTo().frame(richTextAreaFrame);
        mySendKeys(richTextArea, faker.lorem().sentence());
        GWD.getDriver().switchTo().defaultContent();
        myClick(attachFileBtn);
        myClick(fromLocalButton);
        myUploadFile("C:\\Users\\E.Gürel\\Desktop\\Resource\\image2");

    }

    @And("Click on the Send button and user should see the success message")
    public void clickOnTheSendButtonAndUserShouldSeeTheSuccessMessage() {
        myClick(sendButton);
        wait.until(ExpectedConditions.invisibilityOf(sendButton));

//        System.out.println("sentMessage = " + sentMessage);


//        Assert.assertTrue(myJsGetText(sentMessage).toLowerCase().contains("successfully"));
        verifyContainsText(sentMessage, "successfully");
    }
}
