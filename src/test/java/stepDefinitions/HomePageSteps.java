package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePagePOM;
import pages.Parent;
import utilities.GWD;

import java.util.Set;


public class HomePageSteps extends Parent {

    HomePagePOM hp= new HomePagePOM();

    @Given("Locate the company logo in the top left corner of the homepage.")
    public void locateTheCompanyLogoInTheTopLeftCornerOfTheHomepage() {
        Assert.assertTrue(hp.homepageLogo.isDisplayed());

    }
    @Given("Click on the Company Logo")
    public void clickOnTheCompanyLogo() {
        myClick(hp.homepageLogo);

    }

    @When("Verify that the user will be redirected to the homepage.")
    public void verifyThatTheUserWillBeRedirectedToTheHomepage() {
        String originalWindow = GWD.getDriver().getWindowHandle();

        Set<String> allWindows = GWD.getDriver().getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                GWD.getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        System.out.println("Current URL: " + GWD.getDriver().getCurrentUrl());
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), "https://techno.study/", "Homepage failed");
    }



}
