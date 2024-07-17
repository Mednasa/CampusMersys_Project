package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

import java.util.List;

public class TopMenuPOM extends Parent {

    public TopMenuPOM() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//div[@fxlayoutalign=\"end center\"]//div[2]//div//ms-layout-menu-button")
    public List<WebElement> topMenuItems;

    @FindBy(xpath = "//div[text()[normalize-space()='Please wait while your request is processing']]")
    public WebElement attendanceStatusText;

    @FindBy(xpath = "//span[text()=' Assignments ']")
    public WebElement attendance;
}



















