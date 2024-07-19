package testinit;

import factory.DriverFactory;
import factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.ConfigReader;

public class BaseTests {
    protected WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        DriverManager.setDriver(DriverFactory.createDriverInstance());
        //driver = DriverFactory.createDriverInstance();
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getDriver().quit();
        DriverManager.removeDriver();
        //driver.quit();
    }
}
