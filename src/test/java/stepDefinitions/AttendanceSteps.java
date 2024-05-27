package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.AttendancePOM;
import pages.Parent;
import utilities.GWD;

public class AttendanceSteps extends Parent {
    AttendancePOM ap = new AttendancePOM();
    String date = "05/29/2024";
    String message = "I feel under the weather a bit. " +
            "Unfortunately I won't be able to attend the class." +
            "The report is attached." + "Best regards. \n" +
            "Student_3";
    String expectedMessage = "Attendance Excuse successfully sent";

    @When("User navigates to the Attendance Excuses via Attendance Link")
    public void userNavigatesToTheAttendanceExcusesViaAttendanceLink() {
        myClick(ap.attendance);
        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/student-attendance"));
        waitUntilElementToBeClickable(ap.attendanceExcuses);
        myJsClick(ap.attendanceExcuses);
    }

    @Then("User should be redirected to the excuse submission page")
    public void userShouldBeRedirectedToTheExcuseSubmissionPage() {
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), "https://test.mersys.io/student-attendance", "Redirection to the Finance page failed");
    }

    @When("User clicks on the Add icon and writes the excuse in the provided text area")
    public void userClicksOnTheAddIconAndWritesTheExcuseInTheProvidedTextArea() {
        myClick(ap.addIcon);
        myClick(ap.calendarIcon);
        hoverOver(ap.date);
        myClick(ap.date);
        myClick(ap.messagePlcHolder);
        mySendKeys(ap.messagePlcHolder, message);
    }

    @And("User attaches the medical report or an optional file and clicks the send button")
    public void userAttachesTheMedicalReportOrAnOptionalFile() {
        myClick(ap.attachFiles);
        myClick(ap.fromLocal);
        myUploadFile("C:\\Users\\Lenovo\\Desktop\\proof.jpg");
        myClick(ap.sendButton);
    }

    @Then("User should see a confirmation message")
    public void userShouldSeeAConfirmationMessage() {
        waitUntilVisibilityOf(ap.successMsg);
        Assert.assertTrue(ap.successMsg.isDisplayed(), "No message is present!");
    }
}
