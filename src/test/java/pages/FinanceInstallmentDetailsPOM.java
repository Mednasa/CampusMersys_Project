package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class FinanceInstallmentDetailsPOM extends Parent{

    public FinanceInstallmentDetailsPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//student-image)[1]")
    public WebElement studentNameCl;

    @FindBy(xpath = "(//mat-tab-header//span)[8]")
    public WebElement feeBalanceDetailBtn;

    @FindBy(xpath = "//*[text()=' Installment ']")
    public List<WebElement> installmentText;
}
