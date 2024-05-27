package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class AttendancePOM extends Parent {
    public AttendancePOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[page='ATTENDANCE']")
    public WebElement attendance;
    @FindBy(xpath = "(//div[@class='mat-mdc-tab-label-container']//div)[8]")
    public WebElement attendanceExcuses;
    @FindBy(xpath = "//button[contains(@class,'mat-mdc-tooltip-trigger mat-badge')]")
    public WebElement addIcon;
    @FindBy(xpath = "((//button[@class=\"mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base\"])[2]//span)[2]")
    public WebElement calendarIcon;
    @FindBy(css = "button[aria-label='May 29, 2024']")
    public WebElement date;
    @FindBy(xpath = "(//textarea[@id='ms-textarea-field-0'])[1]")
    public WebElement messagePlcHolder;
    @FindBy(css = "span[class='mat-mdc-menu-item-text'] span[class='ng-star-inserted']")
    public WebElement attachFiles;
    @FindBy(xpath = "//span[contains(text(),'From Local')]")
    public WebElement fromLocal;
    @FindBy(xpath = "//span[contains(text(),'Send')]")
    public WebElement sendButton;
    @FindBy(xpath = "//*[contains(text(),'Attendance Excuse successfully sent')]")
    public WebElement successMsg;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "attendance":
                return attendance;
            case "attendanceExcuses":
                return attendanceExcuses;
            case "addIcon":
                return addIcon;
            case "calendarIcon":
                return calendarIcon;
            case "date":
                return date;
            case "messagePlcHolder":
                return messagePlcHolder;
            case "attachFiles":
                return attachFiles;
            case "fromLocal":
                return fromLocal;
            case "sendButton":
                return sendButton;
            case "successMsg":
                return successMsg;
        }
        return null;
    }
}
