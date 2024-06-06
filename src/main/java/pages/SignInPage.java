package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseComponent {

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-aid=\"MEMBERSHIP_SSO_LOGIN_EMAIL\"]")
    WebElement txtEmail;
    @FindBy(css = "input[data-aid=\"MEMBERSHIP_SSO_LOGIN_PASSWORD\"]")
    WebElement txtPassword;
    @FindBy(css = "button[data-aid=\"MEMBERSHIP_SSO_SUBMIT\"]")
    WebElement btnSignIn;
    @FindBy(css = "p[data-aid=\"MEMBERSHIP_SSO_ERR_REND\"]")
    WebElement lblInvalidMailPass;
    @FindBy(css = "form[data-aid=\"MEMBERSHIP_SSO_FORM_REND\"] div:nth-child(1) p")
    WebElement lblEmptyEmail;
    @FindBy(css = "form[data-aid=\"MEMBERSHIP_SSO_FORM_REND\"] div:nth-child(2) p")
    WebElement lblEmptyPassword;

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickSignInBtn() {
        btnSignIn.click();
    }

    public MyAccountPage signInWithCorrectData() {
        btnSignIn.click();
        return new MyAccountPage(driver);
    }

    public String getInvalidEmailPassText() {
        return lblInvalidMailPass.getText();
    }

    public String getEmptyEmailMsg() {
        return lblEmptyEmail.getText();
    }

    public String getEmptyPasswordMsg() {
        return lblEmptyPassword.getText();
    }
}
