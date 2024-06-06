package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class HomePage extends BaseComponent {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        closePopupWidget();
    }

    @FindBy(id = "popup-widget111379-close-icon")
    WebElement btnPopupClose;
    @FindBy(css = "span[id*=\"membership-icon\"]")
    WebElement menuMembershipIcon;
    @FindBy(css = "ul[id*=\"membershipId-loggedout\"] li:nth-child(1) a")
    WebElement menuSignInLink;
    @FindBy(css = "h1[id*=\"dynamic-tagline\"]")
    WebElement header;
    @FindBy(id = "tCounty")
    WebElement dropdownCounty;
    @FindBy(css = "div[id=\"bs-6\"] span iframe")
    WebElement iFrame;
    @FindBy(css = "div[class=\"widget widget-contact widget-contact-contact-2\"] " +
            "div[data-aid=\"CONTACT_FORM_NAME\"] input")
    WebElement txtNameInContactForm;
    @FindBy(css = "div[class=\"widget widget-contact widget-contact-contact-2\"] " +
            "div[data-aid=\"CONTACT_FORM_EMAIL\"] input")
    WebElement txtEmailInContactForm;
    @FindBy(css = "div[class=\"widget widget-contact widget-contact-contact-2\"] " +
            "textarea[data-aid=\"CONTACT_FORM_MESSAGE\"]")
    WebElement txtMessageInContactForm;
    @FindBy(css = "div[class=\"widget widget-contact widget-contact-contact-2\"] button")
    WebElement btnSendInContactForm;
    @FindBy(css = "div[data-aid=\"CONTACT_FORM_SUBMIT_SUCCESS_MESSAGE\"] span")
    WebElement lblSubmitSuccessMsg;
    @FindBy(css = "div[id=\"bs-6\"]")
    WebElement sectionWithIFrame;

    public void closePopupWidget() {
        if (btnPopupClose.isDisplayed()) {
            btnPopupClose.click();
        }
    }

    public void openNestedSideMenuMembership() {
        menuMembershipIcon.click();
    }

    public SignInPage goToMyAccountPage() {
        menuSignInLink.click();
        return new SignInPage(driver);
    }

    public String getHeaderText() {
        return header.getText();
    }

    public void selectCountyByValue(String value) {
        Actions action = new Actions(driver);
        action.moveToElement(sectionWithIFrame).perform();
        driver.switchTo().frame(iFrame);
        Select select = new Select(dropdownCounty);
        select.selectByValue(value);
        driver.switchTo().defaultContent();
    }

    public String getSelectedCounty() {
        driver.switchTo().frame(iFrame);
        Select select = new Select(dropdownCounty);
        String selectedOption = select.getFirstSelectedOption().getText();
        driver.switchTo().defaultContent();
        return selectedOption;
    }

    public void enterName(String name) {
        Actions action = new Actions(driver);
        action.moveToElement(txtNameInContactForm).click().sendKeys(name).perform();
    }

    public void enterEmail(String email) {
        Actions action = new Actions(driver);
        action.moveToElement(txtEmailInContactForm).click().sendKeys(email).perform();
    }

    public void enterMessage(String message) {
        Actions action = new Actions(driver);
        action.moveToElement(txtMessageInContactForm).click().sendKeys(message).perform();
    }

    public void clickBtnSend() throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.moveToElement(btnSendInContactForm).click().perform();
    }

    public String getSubmitSuccessMsg() {
        return lblSubmitSuccessMsg.getText();
    }

}
