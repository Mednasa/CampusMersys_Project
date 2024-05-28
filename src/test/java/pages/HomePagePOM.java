package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class HomePagePOM extends Parent {
    public HomePagePOM() { PageFactory.initElements(GWD.getDriver(), this);}

    @FindBy(css = "mat-toolbar div > img")
    public WebElement homepageLogo;

    @FindBy (css = "[class='tn-atom js-click-zero-stat']")
    public WebElement homePage;
}
