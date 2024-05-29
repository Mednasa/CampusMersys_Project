package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class ChangeThemePOM extends Parent{

    public ChangeThemePOM(){
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(xpath = "//user-image")
    public WebElement profileBtn;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    public WebElement settingsBtn;

    @FindBy(xpath = "//label//mat-label[contains(text(),'Default Theme')]")
    public WebElement themeBtn;

    @FindBy(xpath = "//span[contains(text(),'Purple Theme' )]")
    public WebElement purpleTheme;

    @FindBy(xpath = "//span[contains(text(),'Save' )]")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[contains(text(),'Profile successfully updated')]")
    public WebElement verifyTheme;

    @FindBy(xpath = "//span[contains(text(),' Dark Purple Theme ' )]")
    public WebElement darkPurpleTheme;

    @FindBy(xpath = "//span[contains(text(),' Indigo ')]")
    public WebElement indigoTheme;




}
