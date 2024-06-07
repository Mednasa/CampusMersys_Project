package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.GWD;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[formcontrolname= 'username']")
    public WebElement username;

    @FindBy(css = "[formcontrolname= 'password']")
    public WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginBtn;

    @FindBy(css = "span.logo-text.ng-star-inserted")
    public WebElement headText;

    @FindBy(xpath = "//div[@class='control-full']/button")
    public WebElement searchButton;

    @FindBy(css = "[data-placeholder='Name']")
    public WebElement searchPlc;

    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement deleteButton;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement dialogDelBtn;

    @FindBy(xpath = "//mat-error[text()=' E-posta gereklidir ']")
    public WebElement emailReqError;

    @FindBy(xpath = "//mat-error[text()=' Şifre gereklidir ']")
    public WebElement passwordReqError;

    @FindBy(css = "div[class=\"ng-star-inserted\"] span[style=\"margin-right: 4px;\"] button")
    public WebElement hamburgerMenu;

    @FindBy(css = "div[id=\"mat-menu-panel-4\"] button:nth-child(1)")
    public WebElement HmbMessaging;

    @FindBy(xpath = "//span[text()='New Message']")
    public WebElement newMessage;

    @FindBy(css = "ms-button[tooltip$=RECEIVER]")
    public WebElement addReceiverBtn;

    @FindBy(css = "tbody[role=\"rowgroup\"] mat-checkbox")
    public List<WebElement> receiversCheckboxes;

    @FindBy(css = "ms-table td img")
    public List<WebElement> userImgs;

    @FindBy(xpath = "//span[text()=\"Add & Close\"]")
    public WebElement addCloseBtn;

    @FindBy(xpath = "//span[text()=\"Add\"]")
    public WebElement addBtn;

    @FindBy(css = "input[placeholder=\"Name, Username or E-mail\"]")
    public WebElement receiverSearch;

    @FindBy(xpath = "//div[contains(text(), \"successfully added\")]")
    public WebElement successMsg;

    @FindBy(css = "ms-text-field[placeholder$=SUBJECT] input")
    public WebElement subjectBox;

    @FindBy(css = "ms-button[caption$=SEND]")
    public WebElement sendButton;

    @FindBy(css = "iframe[title=\"Rich Text Area\"]")
    public WebElement richTextAreaFrame;

    @FindBy(css = "body[id=\"tinymce\"] p")
    public WebElement richTextArea;

    @FindBy(css = "file-upload ms-button")
    public WebElement attachFileBtn;

    @FindBy(css = "ms-standard-button[icon=\"hdd\"]")
    public WebElement fromLocalButton;

    @FindBy(xpath = "//div[contains(text(),'Message Successfully sent')]")
    public WebElement sentMessage;

    @FindBy(css = "div[class=\"mat-mdc-menu-content ng-tns-c1923052698-9\"] button:nth-child(3)")
    public WebElement hmbOutbox;

    @FindBy(css = "ms-browse-table tbody tr")
    public List<WebElement> outboxMsgList;

    @FindBy(css = "ms-browse-table  div > div button:nth-child(1)")
    public WebElement financeMoreOptionsBtn;

    @FindBy(css = "div[tabindex=\"-1\"] button:nth-child(1)")
    public WebElement feeExcelExport;

    @FindBy(css = "div[tabindex=\"-1\"] button:nth-child(2)")
    public WebElement feePdfExport;

    @FindBy(xpath = "//div[contains(text(),'Please wait')] ")
    public WebElement feeDownloadWaitMessage;


    public WebElement getWebElement(String e) {
        switch (e) {
            case "editBtn":
                return this.deleteButton;
            case "pasteBtn":
                return this.dialogDelBtn;
            case "closeIconBtn":
                return this.searchPlc;
            case "HmbMessaging":
                return this.HmbMessaging;
            case "newMessage":
                return this.newMessage;
            case "hamburgerMenu":
                return this.hamburgerMenu;
            case "receiverSearch":
                return this.receiverSearch;
            case "financeMoreOptionsBtn":
                return this.financeMoreOptionsBtn;
            case "feeExcelExport":
                return this.feeExcelExport;
            case "feePdfExport":
                return this.feePdfExport;
        }
        return null;
    }


    public void deleteItem(String name) {
        wait.until(ExpectedConditions.visibilityOf(searchButton));

        mySendKeys(searchPlc, name);
        myClick(searchButton);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        myClick(deleteButton);
        myClick(dialogDelBtn);
    }

}
