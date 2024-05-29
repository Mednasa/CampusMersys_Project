package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.GradingPOM;
import pages.Parent;
import utilities.GWD;

public class GradingSteps extends Parent {

    GradingPOM gp = new GradingPOM();
    @Given("Click on the Grading Section")
    public void clickOnTheGradingSection() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.GradingButton));
        myClick(gp.GradingButton);
    }

    @When("Navigate to Grading Page")
    public void navigateToGradingPage() {
        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/student-grading"));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), "https://test.mersys.io/student-grading", "Redirection to the Grading page failed");
    }

    @Then("Click on the Student Transcript Button")
    public void clickOnTheStudentTranscriptButton() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.StudentTranscript));
        myJsClick(gp.StudentTranscript);
    }

    @When("Navigate to Student Transcript Section")
    public void navigateToStudentTranscriptSection() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.StudentTranscriptSection));
        Assert.assertTrue(gp.StudentTranscriptSection.isDisplayed());

    }

    @Then("Click on the Course Grade Button")
    public void clickOnTheCourseGradeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.CourseGrade));
        myJsClick(gp.CourseGrade);
    }

    @When("Navigate to Course Grade Section")
    public void navigateToCourseGradeSection() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.CourseGradeSection));
        Assert.assertTrue(gp.CourseGradeSection.isDisplayed());
    }

    @Then("Click on the Transcript by Subject Button")
    public void clickOnTheTranscriptBySubjectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.TranscriptSubject));
        myJsClick(gp.TranscriptSubject);
    }

    @When("Navigate to Transcript by Subject Section")
    public void navigateToTranscriptBySubjectSection() {
        wait.until(ExpectedConditions.elementToBeClickable(gp.TranscriptSubjectSection));
        Assert.assertTrue(gp.TranscriptSubjectSection.isDisplayed());
    }
}
