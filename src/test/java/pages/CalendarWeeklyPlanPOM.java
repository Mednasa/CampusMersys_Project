package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class CalendarWeeklyPlanPOM extends Parent {
    public CalendarWeeklyPlanPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[page='CALENDAR']")
    public WebElement calendar;
    @FindBy(xpath = "((//div[@fxlayout='row'])[19]//button//span)[2]")
    public WebElement previousButton;
    @FindBy(xpath = "(//span[contains(text(),'11A-MATHEMATICS')])[4]")
    public WebElement mathematics;
    @FindBy(xpath = "(//span[contains(text(),'11A- GEOMETRY')])[2]")
    public WebElement geometry;
    @FindBy(xpath = "(//span[contains(text(),'11A-STATISTICS')])[1]")
    public WebElement publishedL;
    @FindBy(xpath = "(//span[contains(text(),'11A- BIOLOGY')])[1]")
    public WebElement endedL;
    @FindBy(xpath = "(//course-details-dialog[@class='mat-mdc-dialog-component-host ng-star-inserted']//ms-dialog//simple-dialog-title//mat-toolbar//span)[1]")
    public WebElement lessonName;
    @FindBy(xpath = "(//simple-dialog-title//*[@class='mat-mdc-focus-indicator'])[2]")
    public WebElement closeButton;
    @FindBy(xpath = "(//ms-search-button/div/button/span)[1]")
    public WebElement searchButton;
    @FindBy(xpath = "((//div[@fxlayout='row'])[22]//div)[2]")
    public List<WebElement> labelsInfo;
    @FindBy(xpath = "((//div[@fxlayout='row'])[22]//div)[7]")
    public List<WebElement> valuesInfo;
    @FindBy(xpath = "(//span[contains(text(),'Teacher_5 T5')])[4]")
    public WebElement teacherName;
    @FindBy(xpath = "//span[contains(text(),'Recording')]")
    public WebElement recordingBtn;
    @FindBy(xpath = "//meetings-recording[@class='mat-mdc-dialog-component-host ng-star-inserted']//span[@class='mat-mdc-focus-indicator']")
    public WebElement recordCloseBtn;
    @FindBy(xpath = "(//div[@fxlayout='row'])[31]//h3[contains(text(),'Course Meeting has not been started yet')]")
    public WebElement message1;
    @FindBy(xpath = "//div[contains(text(),'Course Meeting has not been started yet')]")
    public WebElement message;
    @FindBy(xpath = "(//mat-tab-header[@class='mat-mdc-tab-header'])[2]//div//div//div/div/div")
    public List<WebElement> popUpTabList;
    @FindBy(css = "[class='cdk-global-overlay-wrapper']>div")
    public WebElement popUpWindow;

}