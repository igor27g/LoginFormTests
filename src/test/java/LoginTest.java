import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void userShouldLogin() {
        LoginPage loginPage = new LoginPage(driver).loginUser(testData.getUser().getEmail(),testData.getUser().getPassword());
        Assertions.assertEquals(testData.getUser().getMyAccountUrl(), driver.getCurrentUrl(),
                "User should login");
    }

    @Test
    public void wrongPasswordToLogin() {
        LoginPage loginPage = new LoginPage(driver).loginUser(testData.getUser().getEmail(),testData.getUser().getWrongPassword());
        Assertions.assertEquals("Authentication failed.", loginPage.getAlertText(),
                "Wrong password was written");
    }

}
