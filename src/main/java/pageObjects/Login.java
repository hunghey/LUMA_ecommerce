package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class Login extends BasePage {
    private WebDriver driver;

    public Login(WebDriver driver){ this.driver = driver; }

    public void enterToUserName(String username) {
       waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
       sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);

    }

    public void enterToPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

    }

    public Dashboard clickToLoginPage() {
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}
