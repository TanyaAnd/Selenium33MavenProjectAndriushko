package LoginTest;


import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class ValidLoginWithParamFromExel extends ParentTest
{

    public ValidLoginWithParamFromExel(String browser) {
        super(browser);
    }

    @Test
    public void validLogin() throws IOException {
        Map dataFromExelForValidLoginTest =
                excelDriver.getData
                        (ConfigData.getCfgValue("DATA_FILE"), "validLogOn");
        loginPage.OpenPageLogin();
        loginPage.inputToLoginField(dataFromExelForValidLoginTest.get("login").toString());
        loginPage.inputToPasswordField(dataFromExelForValidLoginTest.get("pass").toString());
        loginPage.clickSubmitButton();
        checkAcceptanceCriteria
                ("Avatart is not present", homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria
                ("Title is not excepted", homePage.getTitle(), "Учет запчастей");
    }
}
