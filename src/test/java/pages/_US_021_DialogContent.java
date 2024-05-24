package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class _US_021_DialogContent extends Parent{

    public _US_021_DialogContent() {
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
    public WebElement fileBtn;

    @FindBy(xpath = "//*[text()=' Image ']")
    public WebElement imageBtn;

    @FindBy(css = "[class='svg-inline--fa fa-triangle-exclamation fa-fw']")
    public WebElement notSaveIcon;

    @FindBy(xpath = "//*[text()='Save as Draft']")
    public WebElement saveAsDraftBtn;

    @FindBy(css="[class='mat-expansion-panel-header-description ng-star-inserted']")
    public WebElement succesMessages;

    @FindBy(xpath = "(//span[@class='mat-mdc-focus-indicator'])[30]")
    public WebElement openImageBtn;

    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-square-xmark fa-fw'])[2]")
    public WebElement closeImageBtn;

    @FindBy(xpath = "(//*[text()='Submit'])[1]")
    public WebElement secondSubmitBtn;

    @FindBy(xpath = "//*[text()=' Yes ']")
    public WebElement confirmYesBtn;

    @FindBy(xpath = "(//span[@class='mat-mdc-focus-indicator'])[20]")
    public WebElement submittedBtn;

    @FindBy(xpath = "//*[text()='New Submission']")
    public WebElement newSubmissonBtn;

    public WebElement getWebElement(String elements) {
        switch (elements) {

            case "editBtn":
                return this.editBtn;
            case "pasteBtn":
                return this.pasteBtn;
            case "closeIconBtn":
                return this.closeIconBtn;
            case "attachFilesBtn":
                return this.attachFilesBtn;
            case "fromLocalBtn":
                return this.fromLocalBtn;
            case "fileBtn":
                return this.fileBtn;
            case "imageBtn":
                return this.imageBtn;
            case "saveAsDraftBtn":
                return this.saveAsDraftBtn;
            case "openImageBtn":
                return this.openImageBtn;
            case "closeImageBtn":
                return this.closeImageBtn;
            case "secondSubmitBtn":
                return this.secondSubmitBtn;
            case "confirmYesBtn":
                return this.confirmYesBtn;
            case "submittedBtn":
                return this.submittedBtn;
            case "newSubmissonBtn":
                return this.newSubmissonBtn;

        }
        return null;
    }
}
