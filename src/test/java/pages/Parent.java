package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GWD;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class Parent {



    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));


    public String myJsGetText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        return (String) (js.executeScript("arguments[0].textContent;", element));
    }


    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void myJsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void selectByIndex(WebElement element, int num) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select menu = new Select(element);
        menu.selectByIndex(num);
    }

    public void selectByText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void hoverOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        new Actions(GWD.getDriver()).moveToElement(element).build().perform();
    }

    public void myUploadFile(String pathFile) {

        Robot robot;

        {
            try {
                robot = new Robot();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }

        StringSelection createPathFile=new StringSelection(pathFile);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(createPathFile, null);

        wait(1);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        wait(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait(1);

    }

    public void tabKeyMultiplePress(int quantity) {

        Robot robot;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i <quantity ; i++) {
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

    }

    public void enterKeyMultiplePress(int quantity) {

        Robot robot;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i <quantity ; i++) {
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

    }

    public void leftClickMultiplePress(int quantity) {

        Robot robot;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i <quantity ; i++) {
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);
        }

    }


    public void waitUntilVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static int randomGenerator(int range) {
        return (int) (Math.random() * range);
    }

    public void iframeSwitchByIndex(int index){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void iframeSwitchByNameOrId(String nameOrId){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
    }

    public void iframeSwitchByElement(WebElement iframeElement){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
    }

    public static boolean listContainsString(List<WebElement> list, String search) {
        boolean isFound = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(search))
                isFound = true;
        }
        return isFound;
    }

    public static boolean compareLists(List<WebElement> list1, List<String> list2) {
        // Check if the lists are of equal size.
        if (list1.size() != list2.size()) {
            return false;
        }

        // Iterate through the elements of both lists and compare them.
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getText().equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void wait(int sn) {
        try {
            Thread.sleep(sn * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
