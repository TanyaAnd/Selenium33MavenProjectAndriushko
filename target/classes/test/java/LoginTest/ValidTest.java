package LoginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidTest extends ParentTest
{
    public ValidTest(String browser) {
        super(browser);
    }

//{
    //WebDriver driver;
    //LoginTest loginPage;

    //@Before
    //public void setUp()
   // {
        //File fileFF = new File("drivers/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver1");
        //driver = new ChromeDriver();
        //loginPage = new LoginTest(driver);
    //}
    @Test
    public void validLoginTest()
    {
        loginPage.OpenPageLogin();
        loginPage.inputToLoginField("Student");
        loginPage.inputToPasswordField("909090");
        loginPage.clickSubmitButton();
        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarPresent(),true);
        checkAcceptanceCriteria("Title is not expected", homePage.getTitle(), "Учет запчастей");
    }

    //@After
    //public void tearDown()
    //{
        //driver.quit();
    //}

}

