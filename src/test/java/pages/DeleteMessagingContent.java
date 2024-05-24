package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;


public class DeleteMessagingContent extends Parent {

    public DeleteMessagingContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='mat-mdc-menu-trigger mat-mdc-button-wrapper mdc-button mat-mdc-button mat-mdc-button-unchecked mat-unthemed mat-mdc-button-base']")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//span[text()='Messaging']")
    public WebElement hamburgerMenuMessaging;

    @FindBy(xpath = "//span[text()='Outbox']")
    public WebElement messagingOutbox;

    @FindBy(xpath = "//*[@id=\"ms-table-0\"]/div/cdk-virtual-scroll-viewport/div[1]/table/tbody/tr[1]/td[6]/div[1]/ms-confirm-button/button/span[2]")
    public WebElement trashBoxBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement trashConfirmYesBtn;

    @FindBy(xpath = "//div[text()='Message successfully moved to trash!']")
    public WebElement verify;


}
