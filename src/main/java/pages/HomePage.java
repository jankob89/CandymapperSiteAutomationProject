package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseComponent {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected final By btnPopupClose = By.cssSelector("svg[id*=\"popup-widget\"]");
    protected final By menuMembershipIcon = By.cssSelector("span[id*=\"membership-icon\"]");
    protected final By menuSignInLink = By.cssSelector("ul[id*=\"membershipId-loggedout\"] li:nth-child(1) a");
    protected final By header = By.cssSelector("h1[id*=\"dynamic-tagline\"]");
    protected final By dropdownCounty = By.id("tCounty");
    protected final By iFrame = By.cssSelector("div[id=\"bs-6\"] span iframe");
    protected final By txtNameInContactForm = By.cssSelector("div[class=\"widget widget-contact widget-contact-contact-2\"] " +
            "div[data-aid=\"CONTACT_FORM_NAME\"] input");
    protected final By txtEmailInContactForm = By.cssSelector("div[class=\"widget widget-contact widget-contact-contact-2\"] " +
            "div[data-aid=\"CONTACT_FORM_EMAIL\"] input");
    protected final By txtMessageInContactForm = By.cssSelector("div[class=\"widget widget-contact widget-contact-contact-2\"] " +
            "textarea[data-aid=\"CONTACT_FORM_MESSAGE\"]");
    protected final By btnSendInContactForm = By.cssSelector("div[class=\"widget widget-contact widget-contact-contact-2\"] button");
    protected final By lblSubmitSuccessMsg = By.cssSelector("div[data-aid=\"CONTACT_FORM_SUBMIT_SUCCESS_MESSAGE\"] span");
    protected final By sectionWithIFrame = By.cssSelector("div[id=\"bs-6\"]");

    public void closePopupWidget() {
        clickElement(btnPopupClose);
    }

    public void openNestedSideMenuMembership() {
        clickElement(menuMembershipIcon);
    }

    public SignInPage goToMyAccountPage() {
        clickElement(menuSignInLink);
        return new SignInPage(driver);
    }

    public String getHeaderText() {
        return findElement(header).getText();
    }

    public void selectCountyByValue(String value) {
        moveToElementUsingActionsClass(sectionWithIFrame);
        driver.switchTo().frame(findElement(iFrame));
        Select select = new Select(findElement(dropdownCounty));
        select.selectByValue(value);
        driver.switchTo().defaultContent();
    }

    public String getSelectedCounty() {
        driver.switchTo().frame(findElement(iFrame));
        Select select = new Select(findElement(dropdownCounty));
        String selectedOption = select.getFirstSelectedOption().getText();
        driver.switchTo().defaultContent();
        return selectedOption;
    }

    public void enterName(String name) {
        enterTextUsingActionsClass(txtNameInContactForm, name);
    }

    public void enterEmail(String email) {
        enterTextUsingActionsClass(txtEmailInContactForm, email);
    }

    public void enterMessage(String message) {
        enterTextUsingActionsClass(txtMessageInContactForm, message);
    }

    public void clickBtnSend() {
        threadSleep(3000);
        clickElementUsingActionsClass(btnSendInContactForm);
    }

    public String getSubmitSuccessMsg() {
        return findElement(lblSubmitSuccessMsg).getText();
    }

}
