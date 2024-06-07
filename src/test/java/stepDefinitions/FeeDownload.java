package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

public class FeeDownload extends DialogContent {
    @When("User clicks on the {string} from the fees page")
    public void userClicksOnTheFromTheFeesPage(String arg) {
        myClick(getWebElement(arg));
    }


    @And("User clicks on the {string} from three-point menu button")
    public void userClicksOnTheFromThreePointMenuButton(String arg0) {
        myClick(getWebElement(arg0));
    }

    @And("User clicks on the download button from page he or she is directed to")
    public void userClicksOnTheDownloadButtonFromPageHeOrSheIsDirectedTo() {
        tabKeyMultiplePress(8);
        enterKeyMultiplePress(2);
    }
}
