package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseComponent {
    protected WebDriver driver;
    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    private static final int DEFAULT_DURATION = 5;

    public void waitUntilVisibilityOf(WebElement webElement, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void waitUntilVisibilityOf(WebElement webElement) {
        waitUntilVisibilityOf(webElement, DEFAULT_DURATION);
    }

    public void waitUntilElementToBeClickable(WebElement webElement, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitUntilElementToBeClickable(WebElement webElement) {
        waitUntilElementToBeClickable(webElement, DEFAULT_DURATION);
    }


}
