package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContentOnur;
import pages.Parent;
import utilities.GWD;

import java.awt.*;
import java.util.List;

public class UploadingAssignmentsSteps extends Parent {

    DialogContentOnur dtO = new DialogContentOnur();

    @Given("Click on the Element")
    public void clickOnTheElement(DataTable dt) {

        List<String> list = dt.asList(String.class);

        for (int i = 0; i < list.size(); i++) {
            myJsClick(dtO.getWebElement(list.get(i)));
        }


    }

    @Given("Login to the assignment submission screen and click submit")
    public void loginToTheAssignmentSubmissionScreenAndClickSubmit() {

        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/user-courses"));
        myClick(dtO.assignmentsBtn);

        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/student-assignment"));
        myClick(dtO.firstSubmitBtn);
    }

    @When("Use functionality such as writing notes, inserting tables and sending images during the assignment submission process")
    public void useFunctionalitySuchAsWritingNotesInsertingTablesAndSendingImagesDuringTheAssignmentSubmissionProcess() throws AWTException {

        String textMessages = "The hardest choices require the strongest wills.";

        Robot robot =new Robot();

        robot.mouseMove(500, 500);

        leftClickMultiplePress(1);

        iframeSwitchByIndex(0);

        mySendKeys(dtO.textPlc, textMessages);

        enterKeyMultiplePress(1);

        robot.mouseMove(568, 490);

        leftClickMultiplePress(1);

        mySendKeys(dtO.tableTextBox, "Thanos was");

        tabKeyMultiplePress(3);

        mySendKeys(dtO.tableTextBox2, "right!!!");

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
        verifyContainsText(dtO.errorMessage,"doesn't support");
        System.out.println(dtO.errorMessage.getText());
    }

    @And("Upload files from computer")
    public void uploadFilesFromComputer() {
        myUploadFile("C:\\Users\\Onur GİRGİN\\Desktop\\Techno Study\\Techno Study\\Yazilim_Test_Turleri.jpeg");

    }

    @Then("Successfully saved as a draft")
    public void successfullySavedAsADraft() {
        waitUntilVisibilityOf(dtO.notSaveIcon);
        Assert.assertTrue(dtO.notSaveIcon.isDisplayed());
        wait.until(ExpectedConditions.textToBePresentInElement(dtO.succesMessages,"Successfully saved as a draft"));
        Assert.assertEquals(dtO.succesMessages.getText(),"Successfully saved as a draft");
        System.out.println(dtO.succesMessages.getText());
    }
}
