package tests;

import factory.DriverManager;
import helepers.objects.LinkAndStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import testinit.BaseTests;

import java.util.List;

public class FooterTests extends BaseTests {

    @Test
    public void verifyFooterLinksResponseStatus() {

        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
        List<LinkAndStatus> links = homePage.getFooterLinksAndStatusList();
        SoftAssert softAssert = new SoftAssert();

        links.forEach(l -> softAssert.assertTrue(l.responseCode() < 300 && l.responseCode() >= 200,
                "Wrong response status for: " + l.href() + " response status: " + l.responseCode()));
        softAssert.assertAll();
    }
}
