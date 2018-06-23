package ServiceTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class ValidServiceAddPageTest extends ParentTest
{
    public ValidServiceAddPageTest(String browser) {
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
        servicePage.clickAddService();
        checkAcceptanceCriteria("Add header text is expected",serviceAddPage.getHeaderText(), "Словарь");
        serviceAddPage.addService("Test23", "Test23", "Сломан датчик", "Петренко Петр Николаевич");
        Assert.assertTrue("Service is present", servicePage.isItemPresentInTheList("Test23"));
    }
}