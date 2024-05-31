package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.FunctionalityOfCalendarFunctionsPOM;
import pages.Parent;
import pages.SearchingAssignmentsPOM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FunctionalityOfCalendarSteps extends Parent {

    FunctionalityOfCalendarFunctionsPOM fcf =new FunctionalityOfCalendarFunctionsPOM();
    SearchingAssignmentsPOM sap = new SearchingAssignmentsPOM();

    @Given("Weekly lesson plan and today's date appear and verify")
    public void weeklyLessonPlanAndTodaySDateAppearAndVerify() {

        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/user-courses"));
        myClick(fcf.calendarBtn);

        wait.until(ExpectedConditions.visibilityOfAllElements(fcf.lessonName));

        for (int i = 0; i < fcf.lessonName.size(); i++) {
            Assert.assertTrue(fcf.lessonName.get(i).isDisplayed());
        }

        myClick(fcf.lessonName.get(0));
        wait.until(ExpectedConditions.visibilityOf(fcf.notmessage));
        myClick(fcf.lessonCloseIcon);

        String todayText ="";
        for (WebElement cD:fcf.calendarDays){
            if (cD.getCssValue("background-color").equals("rgba(14, 89, 193, 1)")){
                System.out.println(cD.getText().toUpperCase());
                todayText += cD.getText().toUpperCase();
            }

        }

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd", Locale.UK);
        String formattedDate = today.format(formatter).toUpperCase();


        Assert.assertEquals(todayText.charAt(0),formattedDate.charAt(0));

    }

    @When("Visibility of P, S, E, C symbols and their meanings on the page")
    public void visibilityOfPSECSymbolsAndTheirMeaningsOnThePage() {

        for (int i = 0; i < fcf.psecIconName.size(); i++) {

            System.out.println(fcf.psecIconName.get(i).getText());
            System.out.println(fcf.psecIcon.get(i).getText());

            Assert.assertTrue(fcf.psecIconName.get(i).getText().startsWith(fcf.psecIcon.get(i).getText()));

        }

    }

    @And("View the status of scheduled lessons represented by icons \\(P, S, E, C)")
    public void viewTheStatusOfScheduledLessonsRepresentedByIconsPSEC() {

        while (fcf.psec.isEmpty()){
            myClick(fcf.calendarPreviousBtn);
            myLoadingBarWait(sap.loadingBar);
        }

    }

    @And("Look at the icons \\(Previous, Today, Next) on the weekly course plan page and click.")
    public void lookAtTheIconsPreviousTodayNextOnTheWeeklyCoursePlanPageAndClick() {

        myLoadingBarWait(sap.loadingBar);
        myClick(fcf.calendarPreviousBtn);
        myLoadingBarWait(sap.loadingBar);
        myClick(fcf.calendarTodayBtn);
        myLoadingBarWait(sap.loadingBar);
        myClick(fcf.calendarNextBtn);
        myLoadingBarWait(sap.loadingBar);
    }

    @Then("Visibility and clickability of two links to switch to Weekly Course Plan and Calendar pages")
    public void visibilityAndClickabilityOfTwoLinksToSwitchToWeeklyCoursePlanAndCalendarPages() {

        myClick(fcf.calendarcl);
        wait.until(ExpectedConditions.visibilityOf(fcf.ghostElement));
        Assert.assertTrue(fcf.ghostElement.isDisplayed());
        myJsClick(fcf.weeklyCoursePlanBtn);
        Assert.assertTrue(fcf.ghostElement.isDisplayed());


    }
}
