package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageUIs.oranghrm.pim.employee.PersonalDetailsUI;
import utilities.ImageComparison;
import utilities.ScreenshotUtil;

public class PersonalDetails extends BasePage {
    private WebDriver driver;

    public PersonalDetails(WebDriver driver){ this.driver = driver; }

    public String getMessageValidate() {
        waitForElementVisible(driver, PersonalDetailsUI.MESSAGE_VALIDATE);
        return getElement(driver,PersonalDetailsUI.MESSAGE_VALIDATE).getText();
    }

    public String getTitleEmployee() {
        waitForElementVisible(driver, PersonalDetailsUI.MAIN_TITLE);
        return getElement(driver, PersonalDetailsUI.MAIN_TITLE).getText();
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailsUI.EMPLOYEE_IMAGE);
    }

    public void clickToElementAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailsUI.EMPLOYEE_IMAGE);
    }

    public void clickToSaveBtnAvatar() {
        waitForElementClickable(driver, PersonalDetailsUI.SAVE_BTN_CHANGE_PROFILE);
        clickToElement(driver, PersonalDetailsUI.SAVE_BTN_CHANGE_PROFILE);
    }

    public boolean isProfileAvatarUpdateSuccess(String beforeChangeAvatar) throws InterruptedException {
        waitForElementVisible(driver,PersonalDetailsUI.SAVE_BTN_CHANGE_PROFILE);
        Thread.sleep(3000);
        String afterChangeAvatar = ScreenshotUtil.captureScreenshot(driver);
        return ImageComparison.compareImages(beforeChangeAvatar,afterChangeAvatar);
    }

}
