package testinit;

import factory.DriverFactory;
import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.ConfigReader;

public class BaseTests {

    @BeforeMethod
    public void initializeDriver() {
        DriverManager.setDriver(DriverFactory.createDriverInstance());
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getDriver().quit();
        DriverManager.removeDriver();
    }
}
