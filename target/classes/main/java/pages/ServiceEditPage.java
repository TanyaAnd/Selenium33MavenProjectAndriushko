package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceEditPage extends ParentPage
{
    @FindBy(name = "delete")
    WebElement deleteButton;

    public ServiceEditPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteButton()
    {
        uiactions.clickToElement(deleteButton);
    }
}
