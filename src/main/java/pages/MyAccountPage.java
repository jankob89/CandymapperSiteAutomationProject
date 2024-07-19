package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BaseComponent {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    protected final By header = By.cssSelector("h2[data-aid=\"ACCOUNT_DETAILS_HEADING_REND\"] span");
    protected final By menuSignOutLink = By.cssSelector("ul[id*=membershipId] li:nth-child(5)");
    protected final By menuMembershipIcon = By.cssSelector("span[id*=\"membership-icon\"]");

    public String getHeaderText() {
        return findElement(header).getText();
    }

    public HomePage signOut() {
        clickElement(menuSignOutLink);
        return new HomePage(driver);
    }

    public void openNestedSideMenuMembership() {
        clickElement(menuMembershipIcon);
    }

}
