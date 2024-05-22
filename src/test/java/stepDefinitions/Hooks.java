package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ExcelUtility;
import utilities.GWD;

public class Hooks {

    @Before
    public void before() {
        System.out.println(" Scenario is running...");
    }

    @After
    public void after(Scenario scenario) {

        ExcelUtility.writeToExcel("src/test/java/apachePOI/resource/CucumberTestResults.xlsx",
                scenario.getName() + " " + (scenario.isFailed() ? "Failed" : "Passed"));

        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
            byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(bytes, "image/png", "screenshot name");
        }
        System.out.println("Scenario has been completed.");
        GWD.quitDriver();
    }
}
