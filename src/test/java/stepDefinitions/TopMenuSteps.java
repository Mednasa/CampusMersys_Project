package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.Parent;
import pages.TopMenuPOM;
import utilities.GWD;

public class TopMenuSteps extends Parent {

    TopMenuPOM topMenu = new TopMenuPOM();

    @Given("The user should be able to see all the main menu items")
    public void theUserShouldBeAbleToSeeAllTheMainMenuItems() {
        String[] topMenuText = {"Courses", "Calendar", "Attendance", "Assignments", "Grading"};

        for (int i = 0; i < topMenu.topMenuItems.size(); i++) {
            verifyContainsText(topMenu.topMenuItems.get(i), topMenuText[i]);
        }


    }

    @When("The right action should take place when clicking on any of the main menu elements")
    public void theRightActionShouldTakePlaceWhenClickingOnAnyOfTheMainMenuElements() {

        for (int i = 0; i < topMenu.topMenuItems.size(); i++) {

            myClick(topMenu.topMenuItems.get(i));

            if (i == 2){
                wait(3);
            }
            if (i == 3){
                verifyContainsText(topMenu.attendance, "assignment");
                continue;
            }
            wait.until(ExpectedConditions.urlContains(topMenu.topMenuItems.get(i).getText().toLowerCase()));
            System.out.println(GWD.getDriver().getCurrentUrl());
            Assert.assertTrue(GWD.getDriver().getCurrentUrl()
                    .contains(topMenu.topMenuItems.get(i).getText().toLowerCase()));
        }

    }

}


