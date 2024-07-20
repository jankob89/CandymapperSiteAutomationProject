package tests;

import factory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import testinit.BaseTests;

public class DropdownCountyTests extends BaseTests {

    @Test
    public void selectWorcestershireCountyFromDropdown() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.closePopupWidget();
        homePage.selectCountyByValue("SC");
        Assert.assertEquals(homePage.getSelectedCounty(), "Worcestershire");
    }
}
