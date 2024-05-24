package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages._US_021_DialogContent;
import pages.Parent;
import utilities.GWD;

import java.awt.*;
import java.util.List;

public class UploadingAssignmentsSteps extends Parent {

    _US_021_DialogContent dt21 = new _US_021_DialogContent();

    @Given("Click on the Element")
    public void clickOnTheElement(DataTable dt) {

        List<String> list = dt.asList(String.class);

        for (int i = 0; i < list.size(); i++) {
            myJsClick(dt21.getWebElement(list.get(i)));
        }


    }

    @Given("Login to the assignment submission screen and click submit")
    public void loginToTheAssignmentSubmissionScreenAndClickSubmit() {

        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/user-courses"));
        myClick(dt21.assignmentsBtn);

        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/student-assignment"));
        myClick(dt21.firstSubmitBtn);
    }

    @When("Use functionality such as writing notes, inserting tables and sending images during the assignment submission process")
    public void useFunctionalitySuchAsWritingNotesInsertingTablesAndSendingImagesDuringTheAssignmentSubmissionProcess() throws AWTException {

        String textMessages = "The hardest choices require the strongest wills.";

        Robot robot =new Robot();

        robot.mouseMove(500, 500);

        leftClickMultiplePress(1);

        iframeSwitchByIndex(0);

        mySendKeys(dt21.textPlc, textMessages);

        enterKeyMultiplePress(1);

        robot.mouseMove(568, 490);

        leftClickMultiplePress(1);

        mySendKeys(dt21.tableTextBox, "Thanos was");

        tabKeyMultiplePress(3);

        mySendKeys(dt21.tableTextBox2, "right!!!");

        robot.mouseMove(550, 600);

        leftClickMultiplePress(1);

        enterKeyMultiplePress(1);

        robot.mouseMove(520, 470);

        leftClickMultiplePress(1);

        myUploadFile("C:\\Users\\Onur GİRGİN\\Desktop\\Techno Study\\image.png");

        enterKeyMultiplePress(1);

        GWD.getDriver().switchTo().defaultContent();

    }

    @Then("Verification that the copy and paste button function is not working")
    public void verificationThatTheCopyAndPasteButtonFunctionIsNotWorking() {
        verifyContainsText(dt21.errorMessage,"doesn't support");
        System.out.println(dt21.errorMessage.getText());
    }

    @And("Upload files from computer")
    public void uploadFilesFromComputer() {
        myUploadFile("C:\\Users\\Onur GİRGİN\\Desktop\\Techno Study\\Techno Study\\Yazilim_Test_Turleri.jpeg");

    }

    @Then("Successfully saved as a draft")
    public void successfullySavedAsADraft() {
        waitUntilVisibilityOf(dt21.notSaveIcon);
        Assert.assertTrue(dt21.notSaveIcon.isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(dt21.succesMessages,"Successfully saved as a draft"));
        Assert.assertEquals(dt21.succesMessages.getText(),"Successfully saved as a draft");
        System.out.println(dt21.succesMessages.getText());
    }
}
