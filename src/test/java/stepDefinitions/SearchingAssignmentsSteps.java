package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Parent;
import pages.SearchingAssignmentsPOM;
import pages.UploadingAssignmentsPOM;

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
        if(!sap.viewText.isDisplayed()){
            System.out.println("List is empty");

        }else{
            System.out.println("List is not empty");
        }

    }
}
