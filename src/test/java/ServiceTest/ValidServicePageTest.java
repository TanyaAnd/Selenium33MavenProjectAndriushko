package ServiceTest;

import org.junit.Test;
import parentTest.ParentTest;


public class ValidServicePageTest extends ParentTest
{
    public ValidServicePageTest(String browser) {
        super(browser);
    }

    @Test
    public void validLoginTest()
    {
        servicePage.clickServiceLink();
        checkAcceptanceCriteria("Title is not expected", servicePage.getHeaderText(), "Обслуживание");
    }
}
