package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class AssignmentsIconsPOM extends Parent{

    public AssignmentsIconsPOM(){
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Assignments']")
    public WebElement assignmentsBtn;

    @FindBy(xpath = "//*[text()='Semester']")
    public WebElement semesterBtn;

    @FindBy(xpath = "//span[text()='Semester 1']")
    public WebElement semester1;

    @FindBy(xpath = "//span[text()='Default View']")  ////*[@data-icon='chevron-down']  replace if not working
    public WebElement defaultView;

    @FindBy(xpath = "//span[text()='Show by Type']")
    public WebElement showByType;

    @FindBy(xpath = "//*[@id=\"container-3\"]/ms-assignment-panel-student/div/div/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/fa-icon")
    public List <WebElement> assigmentList;

    @FindBy(xpath = "//span[text()='Description']")
    public WebElement descriptonWait; // açıklama

    @FindBy(xpath = "//span[text()=' Homework ']")
    public WebElement homeworkWait;

    @FindBy(xpath = "//ms-icon-button[@icon='info']")
    public List<WebElement> infoBtn;

    @FindBy(xpath = "//ms-icon-button[@icon='file-import']//button")
    public List<WebElement> submitBtn;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submitVerify;

    @FindBy(xpath = "/html/body/div[2]/div[1]")
    public WebElement exit;

    @FindBy(xpath = "//ms-icon-button[@icon='star']//button")
    public List<WebElement> starBtn;

    @FindBy(xpath = "//label[text()=' Show Only Marked ']")
    public WebElement showOnlyStarBtn;



}
