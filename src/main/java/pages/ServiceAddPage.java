package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import libs.UIActions;

public class ServiceAddPage extends ParentPage
{
    @FindBy(xpath = "(.//*[@id='service_apparat']/a)[1]")
    WebElement serviceLink;

    @FindBy(xpath = "(.//*[@class='content-header']/h1)")
    WebElement header;

    public ServiceAddPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {return uiactions.getTextFromElement(header);}


}
