package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BaseComponent {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    protected final By txtEmail = By.cssSelector("input[data-aid=\"MEMBERSHIP_SSO_LOGIN_EMAIL\"]");
    protected final By txtPassword = By.cssSelector("input[data-aid=\"MEMBERSHIP_SSO_LOGIN_PASSWORD\"]");
    protected final By btnSignIn = By.cssSelector("button[data-aid=\"MEMBERSHIP_SSO_SUBMIT\"]");
    protected final By lblInvalidMailPass = By.cssSelector("p[data-aid=\"MEMBERSHIP_SSO_ERR_REND\"]");
    protected final By lblEmptyEmail = By.cssSelector("form[data-aid=\"MEMBERSHIP_SSO_FORM_REND\"] div:nth-child(1) p");
    protected final By lblEmptyPassword = By.cssSelector("form[data-aid=\"MEMBERSHIP_SSO_FORM_REND\"] div:nth-child(2) p");

    public void enterEmail(String email) {
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        enterText(txtPassword, password);
    }

    public void clickSignInBtn() {
        clickElement(btnSignIn);
    }

    public MyAccountPage signInWithCorrectData() {
        clickElement(btnSignIn);
        return new MyAccountPage(driver);
    }

    public String getInvalidEmailPassText() {
        return findElement(lblInvalidMailPass).getText();
    }

    public String getEmptyEmailMsg() {
        return findElement(lblEmptyEmail).getText();
    }

    public String getEmptyPasswordMsg() {
        return findElement(lblEmptyPassword).getText();
    }
}
