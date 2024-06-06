package testinit;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    protected WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverFactory.createDriverInstance();
        driver.get("https://candymapper.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
