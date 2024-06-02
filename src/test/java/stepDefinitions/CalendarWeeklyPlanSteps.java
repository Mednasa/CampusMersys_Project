package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.CalendarWeeklyPlanPOM;
import pages.Parent;

public class CalendarWeeklyPlanSteps extends Parent {

    CalendarWeeklyPlanPOM cwp = new CalendarWeeklyPlanPOM();

    @Given("user navigates to the weekly course plan page via Calendar link.")
    public void userNavigatesToTheCoursePlanPage() {
        myClick(cwp.calendar);
    }

    @When("user clicks on a lesson")
    public void userClicksOnALesson() {
        myClick(cwp.previousButton);
        waitUntilVisibilityOf(cwp.mathematics);
        myClick(cwp.mathematics);
    }

    @Then("a window should open and the user should see the name of the course in the opened window")
    public void aWindowShouldOpenAndTheUserShouldSeeTheNameOfTheCourseInTheOpenedWindow() {
        waitUntilVisibilityOf(cwp.lessonName);
        Assert.assertTrue(cwp.lessonName.isDisplayed(), "Lesson name not found!");
        System.out.println("current lesson: " + cwp.lessonName.getText());
        myClick(cwp.closeButton);
    }

    @When("user clicks on a lesson that has not started yet")
    public void userClicksOnALessonThatHasNotStartedYet() {
        myClick(cwp.calendar);
        myClick(cwp.previousButton);
        waitUntilVisibilityOf(cwp.geometry);
        myJsClick(cwp.geometry);
    }

    @Then("the course name, teacher name, date and time should be displayed")
    public void theCourseNameTeacherNameDateAndTimeShouldBeDisplayed() {

        waitUntilVisibilityOf(cwp.teacherName);
        Assert.assertTrue(cwp.teacherName.isDisplayed());
        System.out.println("Teacher name: " + cwp.teacherName.getText());

        wait.until(ExpectedConditions.visibilityOfAllElements(cwp.labelsInfo));
        wait.until(ExpectedConditions.visibilityOfAllElements(cwp.valuesInfo));
        for (WebElement label : cwp.labelsInfo) {
            Assert.assertTrue(label.isDisplayed());
        //  System.out.println("label info: " + label.getText());
        }
        for (WebElement value : cwp.valuesInfo) {
            Assert.assertTrue(value.isDisplayed());
         // System.out.println("value info: " + value.getText());
        }
    }

    @And("the message {string} should be shown")
    public void theMessageShouldBeShown(String message) {
        waitUntilVisibilityOf(cwp.message1);
        Assert.assertEquals(message, cwp.message1.getText());
        System.out.println(cwp.message1.getText());
        myClick(cwp.closeButton);
    }

    @When("user clicks on a published lesson")
    public void userClicksOnALessonInTheCoursePlan() {
        waitUntilVisibilityOf(cwp.calendar);
        myClick(cwp.calendar);
        waitUntilVisibilityOf(cwp.previousButton);
        myClick(cwp.previousButton);
        waitUntilVisibilityOf(cwp.publishedL);
        wait(1);
        myJsClick(cwp.publishedL);
    }

    @Then("a pop-up window contains the course information should be opened")
    public void aPopUpWindowShouldBeOpened() {
        waitUntilVisibilityOf(cwp.popUpWindow);
        Assert.assertTrue(cwp.popUpWindow.isDisplayed());
    }

    @And("user should see the Information, Topic, Attachments and Recent Events links are running correctly for the published lesson")
    public void userShouldSeeTheLinksForPublishedLesson() {
        verifyLinksAndPerformActions();
        waitUntilVisibilityOf(cwp.searchButton);
        myJsClick(cwp.searchButton);
        waitUntilVisibilityOf(cwp.closeButton);
        myClick(cwp.closeButton);
    }

    @When("user clicks on an ended lesson")
    public void userClicksOnAnEndedLesson() {
        waitUntilVisibilityOf(cwp.endedL);
        wait(1);
        myJsClick(cwp.endedL);
    }

    @And("user should see the Information, Topic, Attachments and Recent Events links are running correctly for the ended lesson")
    public void userShouldSeeTheLinksForEndedLesson() {
        verifyLinksAndPerformActions();
        waitUntilVisibilityOf(cwp.searchButton);
        myJsClick(cwp.searchButton);
        waitUntilVisibilityOf(cwp.recordingBtn);
        myJsClick(cwp.recordingBtn);
        waitUntilVisibilityOf(cwp.recordCloseBtn);
        myJsClick(cwp.recordCloseBtn);
        waitUntilVisibilityOf(cwp.closeButton);
        myClick(cwp.closeButton);
    }

    public void verifyLinksAndPerformActions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(cwp.popUpTabList));
        for (WebElement element : cwp.popUpTabList) {
            Assert.assertTrue(element.isDisplayed());
            wait.until(ExpectedConditions.visibilityOfAllElements(cwp.popUpTabList));
            myJsClick(element);
        }
    }
}
