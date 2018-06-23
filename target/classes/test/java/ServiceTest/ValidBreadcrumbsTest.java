package ServiceTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class ValidBreadcrumbsTest extends ParentTest
{

    public ValidBreadcrumbsTest(String browser)
    {
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
        servicePage.clickBreadcrumbsHomeElement();
        checkAcceptanceCriteria("On HomePage", homePage.getHeaderText(), "Главная");

    }
}
