package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class SearchingAssignmentsPOM extends Parent{

    public SearchingAssignmentsPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css= "ms-search-button [class='mdc-button__label']")
    public WebElement searchBtn;

    @FindBy (xpath = "(//mat-select)[1]")
    public WebElement courseSelect;

    @FindBy(xpath = "(//mat-select)[2]")
    public WebElement statusSelect;

    @FindBy(xpath = "(//mat-select)[3]")
    public WebElement semesterSelect;

    @FindBy(css = "div mat-option")
    public List<WebElement> listName;

    @FindBy(xpath = "//*[text()=' Upcoming ']")
    public List<WebElement> upcomingText;

    @FindBy(xpath = "//*[text()=' Results Published ']")
    public WebElement resultsPublished;

    @FindBy(xpath = "//*[text()='Published, Results Published']")
    public WebElement statusPlc;

    @FindBy(css = "mat-checkbox label")
    public WebElement onlyMarkedBtn;

    @FindBy(css="[class='assignment ng-star-inserted']")
    public List<WebElement> assignList;

    @FindBy(css = " mat-datepicker-toggle svg+span")
    public WebElement dateIcon;

    @FindBy(xpath = "//*[text()=' Today ']")
    public WebElement todayBtn;

    @FindBy(css = "[placeholder='Start Date']")
    public WebElement startDateText;

    @FindBy(xpath = "//*[text()=' This week ']")
    public WebElement thisWeekBtn;

    @FindBy(css = "[class='selected-flag'] :nth-child(3)")
    public WebElement viewSelectBtn;

    @FindBy(css = "[class='cdk-overlay-pane'] span span span:nth-child(1)")
    public List<WebElement> viewList;

    @FindBy(xpath = "(//strong[@class='ng-star-inserted'])[1]")
    public WebElement viewText;




}
