package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseComponent {
    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2[data-aid=\"ACCOUNT_DETAILS_HEADING_REND\"] span")
    WebElement header;
    @FindBy(css = "ul[id*=membershipId] li:nth-child(5)")
    WebElement menuSignOutLink;
    @FindBy(css = "span[id*=\"membership-icon\"]")
    WebElement menuMembershipIcon;

    public String getHeaderText() {
        waitUntilVisibilityOf(header);
        return header.getText();
    }

    public HomePage signOut() {
        menuSignOutLink.click();
        return new HomePage(driver);
    }

    public void openNestedSideMenuMembership() {
        menuMembershipIcon.click();
    }

}
