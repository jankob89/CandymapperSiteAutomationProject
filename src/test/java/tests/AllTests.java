package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import testinit.BaseTests;
import util.ConfigReader;

public class AllTests extends BaseTests {

    String email = ConfigReader.getProperty("email");
    String password = ConfigReader.getProperty("password");
    String username = ConfigReader.getProperty("username");

    @Test
    public void selectWorcestershireCountyFromSlider() {
        HomePage homePage = new HomePage(driver);
        homePage.selectCountyByValue("SC");
        Assert.assertEquals(homePage.getSelectedCounty(), "Worcestershire");
    }

    @Test (priority = 1)
    public void sendMessageWithCorrectData() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.enterName(username);
        homePage.enterEmail(email);
        homePage.enterMessage("Random message");
        homePage.clickBtnSend();
        Assert.assertEquals(homePage.getSubmitSuccessMsg(),
               "Thank you for your inquiry! We will get back to you within 48 hours.");

    }

    @Test (priority = 2)
    public void signInWithCorrectData() {
        HomePage homePage = new HomePage(driver);
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        MyAccountPage myAccountPage = signInPage.signInWithCorrectData();
        Assert.assertEquals(myAccountPage.getHeaderText(), "Hello " + username);
    }

    @Test (priority = 3)
    public void signOut() {
        HomePage homePage = new HomePage(driver);
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        MyAccountPage myAccountPage = signInPage.signInWithCorrectData();
        myAccountPage.openNestedSideMenuMembership();
        homePage = myAccountPage.signOut();
        Assert.assertEquals(homePage.getHeaderText(), "CandyMapper: \n" +
                "The Website That Goes Wrong!");
    }

    @Test (priority = 4)
    public void signInWithIncorrectData() {
        HomePage homePage = new HomePage(driver);
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.enterEmail("invalid_email@mail.com");
        signInPage.enterPassword("invalid_password");
        signInPage.clickSignInBtn();
        Assert.assertEquals(signInPage.getInvalidEmailPassText(),
                "The password/email address combo is incorrect.");
    }

    @Test (priority = 5)
    public void signInWithoutData() {
        HomePage homePage = new HomePage(driver);
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.clickSignInBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signInPage.getEmptyEmailMsg(), "Enter a valid email address.");
        softAssert.assertEquals(signInPage.getEmptyPasswordMsg(), "Passwords can’t be nothing.");
        softAssert.assertAll();
    }
}
