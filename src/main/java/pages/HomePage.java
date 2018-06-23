package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage
{
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    WebElement avatar;

    @FindBy(xpath = "(.//*[@id='service_apparat']/a)[1]")
    WebElement serviceLink;

    @FindBy(xpath = "(.//*[@class='content-header']/h1)")
    WebElement header;

    @FindBy(xpath = ".//*[@class='dropdown user user-menu']/a")
    WebElement userDropdown;

    @FindBy(xpath = ".//*[@class='user-footer']/div[2]/a")
    WebElement logoutButton;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isAvatarPresent()
    {
        return uiactions.isElementPresent(avatar);
    }

    public void clickServiceLink()
    {
        uiactions.clickToElement(serviceLink);
    }

    public String getHeaderText() {return uiactions.getTextFromElement(header);}

    public void clickUserDropdown()
    {
        uiactions.clickToElement(userDropdown);
    }

    public void clickLogoutButton()
    {
        uiactions.clickToElement(logoutButton);
    }

}
