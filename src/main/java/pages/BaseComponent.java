package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testinit.BaseTests;

import java.time.Duration;

public class BaseComponent extends BaseTests {

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }
    private static final int DEFAULT_DURATION = 5;

    /**
     * Find and return web element
     * @param by element locator
     */
    public WebElement findElement(By by) {
        visibilityOf(by);
        return driver.findElement(by);
    }

    /**
     * Click on web element
     * @param by element locator
     */
    public void clickElement(By by) {
        visibilityOf(by);
        driver.findElement(by).click();
    }

    /**
     * Click on web element using Actions class
     * @param by element locator
     */
    public void clickElementUsingActionsClass(By by) {
        visibilityOf(by);
        new Actions(driver)
                .moveToElement(driver.findElement(by))
                .click()
                .perform();
    }

    /**
     * Enter text to web element
     * @param by element locator
     * @param text text to enter into web element
     */
    public void enterText(By by, String text) {
        visibilityOf(by);
        driver.findElement(by).sendKeys(text);
    }

    /**
     * Enter text to web element using Actions class
     * @param by element locator
     * @param text text to enter into web element
     */
    public void enterTextUsingActionsClass(By by, String text) {
        visibilityOf(by);
        new Actions(driver)
                .moveToElement(driver.findElement(by))
                .click()
                .sendKeys(text).perform();
    }

    /**
     * Delete text from web element
     * @param by element locator
     */
    public void deleteText(By by) {
        visibilityOf(by);
        driver.findElement(by).clear();
    }

    /**
     * Delete text from web element using Actions class
     * @param by element locator
     */
    public void deleteTextUsingActionsClass(By by) {
        visibilityOf(by);
        new Actions(driver)
                .moveToElement(driver.findElement(by))
                .click().sendKeys(Keys.DELETE)
                .perform();
    }

    /**
     * Move to web element using Action class
     * @param by element locator
     */
    public void moveToElementUsingActionsClass(By by) {
        visibilityOf(by);
        new Actions(driver)
                .moveToElement(driver.findElement(by))
                .perform();
    }

    /**
     * Move to web element using JavascriptExecutor class
     * @param by element locator
     */
    public void moveToElementUsingJS(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(by));
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution) for the specified
     * number of milliseconds
     * @param milliseconds number of milliseconds to sleep thread
     */
    public void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void visibilityOf(By by, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void visibilityOf(By by) {
        visibilityOf(by, DEFAULT_DURATION);
    }

    public void elementToBeClickable(By by, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void elementToBeClickable(By by) {
        elementToBeClickable(by, DEFAULT_DURATION);
    }

}
