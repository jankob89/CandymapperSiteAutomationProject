package tests;

import factory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import testinit.BaseTests;
import util.ConfigReader;

public class ContactUsFormTests extends BaseTests {

    private final String email = ConfigReader.getProperty("email");
    private final String username = ConfigReader.getProperty("username");

    @Test
    public void sendMessageWithCorrectData() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
        homePage.enterName(username);
        homePage.enterEmail(email);
        homePage.enterMessage("Random message");
        homePage.clickBtnSend();
        Assert.assertEquals(homePage.getSubmitSuccessMsg(),
                "Thank you for your inquiry! We will get back to you within 48 hours.");
    }
}
