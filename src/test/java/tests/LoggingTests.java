package tests;

import factory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import testinit.BaseTests;
import util.ConfigReader;

public class SignInOutTests extends BaseTests {

    private final String email = ConfigReader.getProperty("email");
    private final String password = ConfigReader.getProperty("password");
    private final String username = ConfigReader.getProperty("username");
    @Test
    public void signInWithCorrectData() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.enterEmail(email);
        signInPage.enterPassword(password);
        MyAccountPage myAccountPage = signInPage.signInWithCorrectData();
        Assert.assertEquals(myAccountPage.getHeaderText(), "Hello " + username);
    }

    @Test (priority = 1, dependsOnMethods = "signInWithCorrectData")
    public void signOut() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
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

    @Test (priority = 2)
    public void signInWithIncorrectData() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.enterEmail("invalid_email@mail.com");
        signInPage.enterPassword("invalid_password");
        signInPage.clickSignInBtn();
        Assert.assertEquals(signInPage.getInvalidEmailPassText(),
                "The password/email address combo is incorrect.");
    }

    @Test (priority = 3)
    public void signInWithoutData() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
        homePage.openNestedSideMenuMembership();
        SignInPage signInPage = homePage.goToMyAccountPage();
        signInPage.clickSignInBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(signInPage.getEmptyEmailMsg(), "Enter a valid email address.");
        softAssert.assertEquals(signInPage.getEmptyPasswordMsg(), "Passwords can’t be nothing.");
        softAssert.assertAll();
    }
}
