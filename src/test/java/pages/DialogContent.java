package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.GWD;

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

    public void deleteItem(String name) {
        wait.until(ExpectedConditions.visibilityOf(searchButton));

        mySendKeys(searchPlc, name);
        myClick(searchButton);

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        myClick(deleteButton);
        myClick(dialogDelBtn);
    }

    public WebElement getWebElement(String e) {
        return null;
    }


}
