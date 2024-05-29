package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.FinanceInstallmentDetailsPOM;
import pages.Parent;

public class FinanceInstallmentDetailsSteps extends Parent {

    FinanceInstallmentDetailsPOM fid =new FinanceInstallmentDetailsPOM();

    @And("Click on the username and see the account details")
    public void clickOnTheUsernameAndSeeTheAccountDetails() {

        myClick(fid.studentNameCl);
        myClick(fid.feeBalanceDetailBtn);

    }

    @Then("User should be able to see the account list")
    public void userShouldBeAbleToSeeTheAccountList() {

        wait.until(ExpectedConditions.visibilityOfAllElements(fid.installmentText));
        Assert.assertTrue(listContainsString(fid.installmentText,"Installment"));

    }

}
