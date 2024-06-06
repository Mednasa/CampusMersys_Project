package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.AssignmentsIconsPOM;
import pages.Parent;
import pages.SearchingAssignmentsPOM;
import utilities.GWD;

import java.util.Random;

public class AssignmentsIconSteps extends Parent {

    AssignmentsIconsPOM ai=new AssignmentsIconsPOM();
    SearchingAssignmentsPOM sa=new SearchingAssignmentsPOM();
    Random rnd=new Random();
    int random= rnd.nextInt(3);


    @When("Click on the assignments and semester all select")
    public void clickOnTheAssignmentsAndSemesterAllSelect() {

        wait.until(ExpectedConditions.visibilityOf(ai.assignmentsBtn));
        myClick(ai.assignmentsBtn);
        myClick(ai.semesterBtn);
        myJsClick(ai.semester1);
        myClick(ai.defaultView);
        myJsClick(ai.showByType);
        myLoadingBarWait(sa.loadingBar);


    }

    @And("click on the information sections")
    public void checkWhetherTheIconsAreWorking() {


        myJsClick(ai.assigmentList.get(random));

        wait.until(ExpectedConditions.visibilityOf(ai.descriptonWait)); // info kısmına girmesini bekle
        String url=GWD.getDriver().getCurrentUrl();
        System.out.println("url1 = " + url);
        Assert.assertTrue(url.contains("info"));

        GWD.getDriver().navigate().back();
        wait.until(ExpectedConditions.visibilityOf(ai.homeworkWait));
        wait.until(ExpectedConditions.visibilityOf(ai.infoBtn.get(random)));
        myJsClick(ai.infoBtn.get(random));
        wait.until(ExpectedConditions.visibilityOf(ai.descriptonWait));

        url=GWD.getDriver().getCurrentUrl();
        System.out.println("url1 = " + url);
        Assert.assertTrue(url.contains("info"));
        GWD.getDriver().navigate().back();

    }

    @When("click on submit")
    public void clickOnSubmit() {

        wait.until(ExpectedConditions.visibilityOf(ai.homeworkWait)); // homework yazana kadar bekle
        wait.until(ExpectedConditions.visibilityOf(ai.submitBtn.get(random)));

        myJsClick(ai.submitBtn.get(random));

        wait.until(ExpectedConditions.visibilityOf(ai.submitVerify));
        String submitVerifyText=ai.submitVerify.getText();
        Assert.assertTrue(submitVerifyText.contains("Submit"));
        myJsClick(ai.exit);
        myLoadingBarWait(sa.loadingBar);

    }

    @And("click on star")
    public void clickOnStar() {

        wait.until(ExpectedConditions.visibilityOf(ai.homeworkWait));
        wait.until(ExpectedConditions.visibilityOf(ai.starBtn.get(random)));
        wait.until(ExpectedConditions.elementToBeClickable(ai.starBtn.get(random)));

        myJsClick(ai.starBtn.get(random));
        myJsClick(ai.showOnlyStarBtn);
        wait.until(ExpectedConditions.visibilityOf(ai.homeworkWait));

        System.out.println(ai.homeworkWait.getText());
        Assert.assertTrue(ai.homeworkWait.getText().contains("Homework"));


        // yıldızlanan dersin yıldızını kaldırır
        myJsClick(ai.showOnlyStarBtn);
        myJsClick(ai.starBtn.get(random));


    }
}
