package utilities;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> browserName = new ThreadLocal<>();


    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (browserName.get() == null) {
            browserName.set("chrome");
        }

        if (threadDriver.get() == null) {
            switch (browserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                default:
                    threadDriver.set(new ChromeDriver());
            }


            threadDriver.get().manage().window().setPosition(new Point(-1000, 0));

            threadDriver.get().manage().window().maximize();

            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        }


        return threadDriver.get();
    }

    public static void quitDriver() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            WebDriver driver = null;
            threadDriver.set(driver);
        }
    }

}
