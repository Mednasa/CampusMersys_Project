package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class FunctionalityOfCalendarFunctionsPOM extends Parent{

    public FunctionalityOfCalendarFunctionsPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//ms-layout-menu-button//span/span)[3]")
    public WebElement calendarBtn;

    @FindBy(css = " thead th+th")
    public List<WebElement> calendarDays;

    @FindBy(css = "fa-icon+div div+span+span")
    public List<WebElement> psec;

    @FindBy(css = "ms-browse div+div>div>div span+span")
    public List<WebElement> psecIconName;

    @FindBy(css = "span[class^='mat-accent']")
    public List<WebElement> psecIcon;

    @FindBy(css=" fa-icon+div div span")
    public List<WebElement> lessonName;

    @FindBy(xpath = "(//ms-browse//*[@class='mat-mdc-focus-indicator'])[1]")
    public WebElement calendarPreviousBtn;

    @FindBy(xpath = "(//ms-browse//*[@class='mat-mdc-focus-indicator'])[2]")
    public WebElement calendarTodayBtn;

    @FindBy(xpath = "(//ms-browse//*[@class='mat-mdc-focus-indicator'])[3]")
    public WebElement calendarNextBtn;

    @FindBy(xpath = "(//*[text()=' Calendar '])[2]")
    public WebElement calendarcl;

    @FindBy(xpath = "(//mat-tab-header//*[@class='mat-mdc-tab-labels']//fa-icon)[1]")
    public WebElement weeklyCoursePlanBtn;

    @FindBy(css = "[aria-label='Close dialog'] fa-icon+span")
    public WebElement lessonCloseIcon;

    @FindBy(css = "ms-dialog-content div h3")
    public WebElement notmessage;

    @FindBy(css="[class='mat-ripple-element']")
    public WebElement ghostElement;
}
