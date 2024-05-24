package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class DialogContentOnur extends Parent{

    public DialogContentOnur() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Assignments'])[1]")
    public WebElement assignmentsBtn;

    @FindBy(xpath = "(//span[@class='mat-mdc-focus-indicator'])[21]")
    public WebElement firstSubmitBtn;

    @FindBy(id="tinymce")
    public WebElement textPlc;

    @FindBy(css="[id='tinymce'] table tbody tr:nth-child(1) td:nth-child(1)")
    public WebElement tableTextBox;

    @FindBy(css="[id='tinymce'] table tbody tr:nth-child(2) td:nth-child(2)")
    public WebElement tableTextBox2;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editBtn;

    @FindBy(css = "[title='Paste']")
    public WebElement pasteBtn;

    @FindBy(css="[class='tox-notification__body']")
    public WebElement errorMessage;

    @FindBy(css="[class='tox-icon']")
    public WebElement closeIconBtn;

    @FindBy(xpath = "//*[text()='Attach Files...']")
    public WebElement attachFilesBtn;

    @FindBy(xpath = "//*[text()='From Local']")
    public WebElement fromLocalBtn;

    @FindBy(xpath = "(//*[text()='File'])[2]")
    public WebElement selectFile;

    @FindBy(xpath = "//*[text()=' Image ']")
    public WebElement selectImage;

    @FindBy(css = "[class='svg-inline--fa fa-triangle-exclamation fa-fw']")
    public WebElement notSaveIcon;

    @FindBy(xpath = "//*[text()='Save as Draft']")
    public WebElement saveAsDraftBtn;

    @FindBy(css="[class='mat-expansion-panel-header-description ng-star-inserted']")
    public WebElement succesMessages;

    @FindBy(xpath = "(//span[@class='mat-mdc-focus-indicator'])[30]")
    public WebElement openImage;

    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-square-xmark fa-fw'])[2]")
    public WebElement closeImage;

    @FindBy(xpath = "(//*[text()='Submit'])[1]")
    public WebElement submitBtn;

    @FindBy(xpath = "//*[text()=' Yes ']")
    public WebElement confirmYes;

    @FindBy(xpath = "(//span[@class='mat-mdc-focus-indicator'])[20]")
    public WebElement submittedBtn;

    @FindBy(xpath = "//*[text()='New Submission']")
    public WebElement newSubmissonBtn;
}
