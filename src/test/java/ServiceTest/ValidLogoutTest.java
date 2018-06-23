package ServiceTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class ValidLogoutTest extends ParentTest
{

    public ValidLogoutTest(String browser) {
        super(browser);
    }

    @Test
    public void validServiceAddTest()
    {
        loginPage.OpenPageLogin();
        loginPage.inputToLoginField("Student");
        loginPage.inputToPasswordField("909090");
        loginPage.clickSubmitButton();
        homePage.clickServiceLink();
        checkAcceptanceCriteria("Service header text is expected", servicePage.getHeaderText(), "Обслуживание Список");
        homePage.clickUserDropdown();
        homePage.clickLogoutButton();
        Assert.assertTrue("Succesfully loged out", loginPage.checkSuccessfulLogout());
    }
}
