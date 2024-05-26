package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.FinanceAccessPOM;
import pages.Parent;
import utilities.GWD;

public class FinanceAccessSteps extends Parent {
    FinanceAccessPOM fp = new FinanceAccessPOM();
    @When("User clicks on the {string} from the header")
    public void userClicksOnTheHamburgerMenuFromTheHeader(String hamburgerMenu) {
        waitUntilVisibilityOf(fp.hamburgerMenu);
        myClick(fp.hamburgerMenu);
    }

    @And("User clicks on the {string} from the drop-down menu")
    public void userClicksOnTheFinanceLinkFromTheDropDownMenu(String financeLink) {
        waitUntilVisibilityOf(fp.financeLink);
        hoverOver(fp.financeLink);
        myClick(fp.financeLink);
    }

    @And("User clicks on the {string} from the sub-menu")
    public void userClicksOnTheMyFinanceLinkFromTheSubMenu(String myFinanceLink) {
        myClick(fp.myFinanceLink);
    }

    @Then("User should be redirected to the Finance page")
    public void userShouldBeRedirectedToTheFinancePage() {
        wait.until(ExpectedConditions.urlToBe("https://test.mersys.io/student-finance/active"));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), "https://test.mersys.io/student-finance/active", "Redirection to the Finance page failed");
    }
}
