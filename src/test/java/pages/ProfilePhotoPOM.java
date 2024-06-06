package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class ProfilePhotoPOM extends Parent {
    public ProfilePhotoPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//user-image")
    public WebElement profileButton;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    public WebElement settingsButton;

    @FindBy(css = "[class= 'profile-image avatar huge ng-star-inserted']")
    public WebElement profilePicture;

    @FindBy(css = "[data-icon='upload']")
    public WebElement uploadButton;

    @FindBy(xpath = "//*[text()=' Upload ']")
    public WebElement uploadButton2;

    @FindBy(css = "ms-save-button fa-icon+span")
    public WebElement saveButton;

    @FindBy(xpath = "//*[text()='Profile successfully updated']")
    public WebElement verifyPhoto;


}
