package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.Parent;
import pages.ProfilePhotoPOM;
import utilities.GWD;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

public class ProfilePhotoSteps extends Parent {

    ProfilePhotoPOM pp = new ProfilePhotoPOM();

    @Given("Click on the profile and click on the Settings")
    public void clickOnTheProfileAndClickOnTheSettings() {
        pp.myJsClick(pp.profileButton);
        pp.myJsClick(pp.settingsButton);
    }

    @Then("Verification that you are on the settings page")
    public void verificationThatYouAreOnTheSettingsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(pp.profilePicture));
        Assert.assertTrue(pp.profilePicture.isDisplayed());

    }

    @When("Click on the profile picture and upload button")
    public void clickOnTheProfilePictureAndUploadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pp.profilePicture));
        pp.myJsClick(pp.profilePicture);
        wait.until(ExpectedConditions.elementToBeClickable(pp.uploadButton));
        pp.myClick(pp.uploadButton);
    }

    @And("Select the photo to upload from the files")
    public void selectThePhotoToUploadFromTheFiles() throws AWTException {


        File file = new File("/Users/macbookair/Desktop/photo2.jpg");
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        System.out.println("File Upload");
        Robot robot = new Robot();

        Set<String> windowHandles = GWD.getDriver().getWindowHandles();

        for (String handle : windowHandles) {
            GWD.getDriver().switchTo().window(handle);
            if (GWD.getDriver().getTitle().contains("Upload")) {
                break;
            }
        }

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);


        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


    @And("After taking the photo, click the Upload button and save button")
    public void afterTakingThePhotoClickTheUploadButtonAndSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(pp.uploadButton2));
        pp.myJsClick(pp.uploadButton2);
        wait.until(ExpectedConditions.invisibilityOf(pp.uploadButton2));
        wait.until(ExpectedConditions.visibilityOf(pp.saveButton));
        pp.myJsClick(pp.saveButton);
        wait.until(ExpectedConditions.invisibilityOf(pp.saveButton));
    }


    @Then("Receive a Success message when they successfully upload or change their profile picture.")
    public void receiveASuccessMessageWhenTheySuccessfullyUploadOrChangeTheirProfilePicture() {
        wait.until(ExpectedConditions.visibilityOf(pp.verifyPhoto));
        Assert.assertTrue(pp.verifyPhoto.isDisplayed());
    }
}
