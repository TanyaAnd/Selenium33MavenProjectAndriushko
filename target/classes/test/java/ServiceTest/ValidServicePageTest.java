package ServiceTest;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidServicePageTest extends ParentTest
{
    public ValidServicePageTest(String browser) {
        super(browser);
    }

    @Test
    public void validServiceTest()
    {
        loginPage.OpenPageLogin();
        loginPage.inputToLoginField("Student");
        loginPage.inputToPasswordField("909090");
        loginPage.clickSubmitButton();
        homePage.clickServiceLink();
        checkAcceptanceCriteria("Service header text is expected", servicePage.getHeaderText(), "Обслуживание Список");
        servicePage.clickAddService();
        checkAcceptanceCriteria("Add header text is expected",serviceAddPage.getHeaderText(), "Словарь");
    }
}
