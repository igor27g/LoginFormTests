package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    protected WebDriverWait wait;

    By emailLoginInput = By.cssSelector("input[id='email']");
    By passwordLoginInput = By.cssSelector("input[id='passwd']");
    By signInButton = By.cssSelector("button[id='SubmitLogin']");
    By alertText = By.cssSelector("div.alert.alert-danger>ol>li");

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,15);
    }

    public LoginPage loginUser(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLoginInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLoginInput)).sendKeys(password);
        clickSignButton();
        return this;
    }

    public String getAlertText() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(alertText)).getText();
        return text;
    }

    private void clickSignButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

}
