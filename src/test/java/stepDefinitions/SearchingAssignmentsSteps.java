package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.Parent;
import pages.SearchingAssignmentsPOM;
import pages.UploadingAssignmentsPOM;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchingAssignmentsSteps extends Parent {

    UploadingAssignmentsPOM uap = new UploadingAssignmentsPOM();
    SearchingAssignmentsPOM sap = new SearchingAssignmentsPOM();

    @Given("Login to the assignment submission")
    public void loginToTheAssignmentSubmission() {
        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/user-courses"));
        myClick(uap.assignmentsBtn);
    }

    @When("Listing of tasks when default search is performed")
    public void listingOfTasksWhenDefaultSearchIsPerformed() {

        myClick(sap.searchBtn);
        myLoadingBarWait(sap.loadingBar);
        if (sap.lessonName.isEmpty()) {

            System.out.println("List is empty");

        } else {

            System.out.println("List is not empty");
        }

    }


    @And("Search and verify assignments by filtering")
    public void searchAndVerifyAssignmentsByFiltering() {
        myClick(sap.courseSelect);

        for (int i = 1; i < sap.listName.size(); i++) {

            myJsClick(sap.listName.get(i));
            myLoadingBarWait(sap.loadingBar);
            if (sap.lessonName.isEmpty()) {

                System.out.println("List is empty");

            } else {

                System.out.println("List is not empty");
            }
            myJsClick(sap.courseSelect);

        }

        myJsClick(sap.listName.get(0));
        myJsClick(sap.statusSelect);
        myJsClick(sap.resultsPublished);
        verifyContainsText(sap.statusPlc, "Results Published");

        myJsClick(sap.onlyMarkedBtn);
        myLoadingBarWait(sap.loadingBar);
        myClick(sap.onlyMarkedBtn);
        myLoadingBarWait(sap.loadingBar);

        myJsClick(sap.semesterSelect);
        for (WebElement semesterName : sap.listName) {
            myJsClick(semesterName);
            myLoadingBarWait(sap.loadingBar);
            if (sap.assignList.isEmpty()) {
                System.out.println("List is empty");

            } else {
                System.out.println("List is not empty");
            }
            myJsClick(sap.semesterSelect);

        }

        myJsClick(sap.listName.get(1));
    }

    @And("Search and verify assignments using the date icon")
    public void searchAndVerifyAssignmentsUsingTheDateIcon() {

        myClick(sap.dateIcon);
        myClick(sap.todayBtn);

        String dateCampus = sap.startDateText.getAttribute("value");

        LocalDate startDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String nowDate = startDate.format(formatter);
        Assert.assertEquals(nowDate, dateCampus);
        myClick(sap.thisWeekBtn);


    }

    @And("Search and validate assignments using course, type, date units from the sort menu")
    public void searchAndValidateAssignmentsUsingCourseTypeDateUnitsFromTheSortMenu() {

        myJsClick(sap.viewSelectBtn);

        for (int i = 0; i < sap.viewList.size() - 1; i++) {
            myJsClick(sap.viewList.get(i));
            myLoadingBarWait(sap.loadingBar);
            if (sap.lessonName.isEmpty()) {

                System.out.println("List is empty");

            } else {

                System.out.println("List is not empty");
            }
            myJsClick(sap.viewSelectBtn);

        }

    }


}
