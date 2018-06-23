package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import libs.UIActions;

public class ServicePage extends ParentPage
{
    @FindBy(xpath = "(.//*[@class='content-header']/h1)")
    WebElement header;

    @FindBy(xpath = "(.//*[@class='box-tools']/a)[1]")
    WebElement addServiceButton;

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {return uiactions.getTextFromElement(header);}

    public void clickAddService()
    {
        uiactions.clickToElement(addServiceButton);
    }
}