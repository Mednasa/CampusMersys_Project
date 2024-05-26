package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class FinanceAccessPOM extends Parent{
    public FinanceAccessPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(css = "[aria-haspopup='menu']")
    public WebElement hamburgerMenu;
    @FindBy(xpath = "(//span[contains(text(),'Finance')])[1]")
    public WebElement financeLink;
    @FindBy(xpath = "//span[contains(text(),'My Finance')]")
    public WebElement myFinanceLink;

    public WebElement getWebElement(String element) {

        switch (element) {
            case "hamburgerMenu":
                return hamburgerMenu;
            case "financeLink":
                return financeLink;
            case "myFinanceLink":
                return myFinanceLink;
        }
        return null;
    }
}
