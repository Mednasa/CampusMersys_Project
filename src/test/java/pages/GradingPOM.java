package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class GradingPOM {
    public GradingPOM() {PageFactory.initElements(GWD.getDriver(), this);}

    @FindBy(xpath = "(//*[text()='Grading'])[1]")
    public WebElement GradingButton;

    @FindBy(xpath = "//*[@id='mat-tab-label-0-1']/div")
    public WebElement StudentTranscript;

    @FindBy(xpath = "//*[text()=' Internship ']")
    public WebElement StudentTranscriptSection;

    @FindBy(xpath = "//*[@id='mat-tab-label-0-2']")
    public WebElement TranscriptSubject;

    @FindBy(xpath = "//*[text()=' Subject ']")
    public WebElement TranscriptSubjectSection;

    @FindBy(xpath = "//*[@id='mat-tab-label-0-0']")
    public WebElement CourseGrade;

    @FindBy(xpath = "//*[text()=' Course Name ']")
    public WebElement CourseGradeSection;

}
