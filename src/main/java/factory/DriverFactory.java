package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.ConfigReader;

public class DriverFactory {
    private DriverFactory() {
        throw new IllegalStateException("DriverFactory class");
    }

    public static WebDriver createDriverInstance() {
        WebDriver driver;
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new IllegalArgumentException("Unexpected value: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
}
