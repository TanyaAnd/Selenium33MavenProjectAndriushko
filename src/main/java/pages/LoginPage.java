package pages;

import libs.ConfigData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import libs.UIActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage
{

    // 1) type
//    String LoginFieldName = "_username";
//    String PasswordFieldid = "password";
//    String SubmitButtonType = "submit";

    // 2) type
//    By LoginFieldName = By.name("_username");
//    By PasswordFieldid = By.id("password");
//    By SubmitButtonXpath = By.xpath(".//button[@type='submit']");

    // 3) type. Only with PageFactory.initElements(driver, this)

    @FindBy(name = "_username")
    WebElement LoginFieldName;

    @FindBy(id = "password")
    WebElement PasswordFieldId;

    @FindBy(xpath = ".//button[@type = 'submit']")
    WebElement SubmitButtonXpath;

    public LoginPage(WebDriver driver)
    {
        super(driver); // підтягує дані з class ParentPage
    }

    public void OpenPageLogin()
    {
        try
        {
            driver.get(ConfigData.getCfgValue("base_url") + "/login");
            log.info("Page login was opened");
        }
        catch (Exception e)
        {
            log.error("Can't open URL");
            Assert.fail("Can't open URL");
        }
    }

    public void openPage(String url)
    {
        driver.get(url);
    }

    public void inputToLoginField(String value)
    {
        uiactions.inputToTextField(LoginFieldName, value);
    }

    public void inputToPasswordField(String value)
    {
        uiactions.inputToTextField(PasswordFieldId, value);
    }

    public void clickSubmitButton()
    {
        uiactions.clickToElement(SubmitButtonXpath);
    }

    public void loginUserToTheSystem(String login, String password)
    {
        OpenPageLogin();
        inputToLoginField(login);
        inputToPasswordField(password);
        clickSubmitButton();
    }

}
