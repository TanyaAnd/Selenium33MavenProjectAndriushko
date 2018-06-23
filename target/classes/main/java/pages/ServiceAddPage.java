package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import libs.UIActions;

public class ServiceAddPage extends ParentPage
{
    @FindBy(id = "service_apparat_serviceChanges")
    WebElement serviceChanges;

    @FindBy(id = "service_apparat_serviceOperations")
    WebElement serviceOperations;

    @FindBy(id = "service_apparat_apparat")
    WebElement apparat;

    @FindBy(id = "service_apparat_worker")
    WebElement worker;

    @FindBy(name = "add")
    WebElement addButton;

    @FindBy(xpath = "(.//*[@class='content-header']/h1)")
    WebElement header;

    public ServiceAddPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {return uiactions.getTextFromElement(header);}

    public void inputToServiceChanges(String value)
    {
        uiactions.inputToTextField(serviceChanges, value);
    }

    public void inputToServiceOperations(String value)
    {
        uiactions.inputToTextField(serviceOperations, value);
    }

    public void inputToApparat(String value)
    {
        uiactions.selectDropDownElemByValue(apparat, value);
    }

    public void inputToWorker(String value)
    {
        uiactions.selectDropDownElemByValue(worker, value);
    }

    public void clickAddButton()
    {
        uiactions.clickToElement(addButton);
    }

    public void addService(String changes, String ops, String apparat, String worker)
    {
        inputToServiceChanges(changes);
        inputToServiceOperations(ops);
        inputToApparat(apparat);
        inputToWorker(worker);
        clickAddButton();
    }

}
