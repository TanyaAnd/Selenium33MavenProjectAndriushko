package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import libs.UIActions;

public class ServicePage extends HomePage
{
    @FindBy(xpath = "(.//*[@id='service_apparat']/a)[1]")
    WebElement serviceLink;

    @FindBy(xpath = "(.//*[@class='content-header']/h1)")
    WebElement header;

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    public void clickServiceLink()
    {
        uiactions.clickToElement(serviceLink);
    }

    public String getHeaderText() {return uiactions.getTextFromElement(header);}
}