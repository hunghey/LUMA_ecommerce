package pageObjects.pim.employee;

import commons.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.pim.employee.EmployeeTabUI;
import pageUIs.pim.employee.PersonalDetailsUI;
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

    public void openPersonalDetailPage() {
        waitForElementClickable(driver, EmployeeTabUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabUI.PERSONAL_DETAIL_LINK);
        waitAllLoadingIconInvisible(driver);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastname) {
        waitForElementVisible(driver, PersonalDetailsUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsUI.LASTNAME_TEXTBOX, lastname);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver,PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToDriverLicenseTextbox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailsUI.DRIVER_LICENSE_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsUI.DRIVER_LICENSE_TEXTBOX, driverLicense);
    }

    public void enterToLicenseExpiryDate(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailsUI.LICENSE_EXPIRE_DATE_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsUI.LICENSE_EXPIRE_DATE_TEXTBOX, licenseExpiryDate);
    }

    public void selectNationalDropdown(String national) {
        waitForElementClickable(driver, PersonalDetailsUI.NATIONAL_PARENT_DROPDOWN);
        selectItemInCustomDropdown(driver, PersonalDetailsUI.NATIONAL_PARENT_DROPDOWN, PersonalDetailsUI.NATIONAL_CHILD_DROPDOWN, national);

    }

    public void selectMaritalStatusDropdown(String marital) {
        waitForElementClickable(driver, PersonalDetailsUI.MARITAL_PARENT_STATUS_DROPDOWN);
        selectItemInCustomDropdown(driver, PersonalDetailsUI.MARITAL_PARENT_STATUS_DROPDOWN, PersonalDetailsUI.MARITAL_CHILD_DROPDOWN, marital);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectGenderMaleRadioButton(String gender) {
        clickToElementByJS(driver, PersonalDetailsUI.GENDER_TEXTBOX,gender);
    }

    public void clickSaveButton() {
        waitForElementVisible(driver, PersonalDetailsUI.SAVE_BTN);
        clickToElement(driver, PersonalDetailsUI.SAVE_BTN);
    }

    public String getFirstNameValue() {
        waitForElementVisible(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLastNameValue() {
        waitForElementVisible(driver, PersonalDetailsUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsUI.LASTNAME_TEXTBOX,"value");
    }

    public String getLicenseExpiryDateValue() {
        waitForElementVisible(driver, PersonalDetailsUI.LICENSE_EXPIRE_DATE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsUI.LICENSE_EXPIRE_DATE_TEXTBOX,"value");
    }

    public String getNationalDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsUI.NATIONAL_SELECTED_DROPDOWN);
        return getElementText(driver, PersonalDetailsUI.NATIONAL_SELECTED_DROPDOWN);
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsUI.MARITAL_STATUS_SELECT_DROPDOWN);
        return getElementText(driver, PersonalDetailsUI.MARITAL_STATUS_SELECT_DROPDOWN);
    }

    public String getDateOfBirthValue() {
        waitForElementVisible(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsUI.DATE_OF_BIRTH_TEXTBOX,"value");
    }

    public boolean isGenderMaleValue(String gender) {
        waitForElementSelected(driver, PersonalDetailsUI.GENDER_TEXTBOX,gender);
        return isElementSelected(driver, PersonalDetailsUI.GENDER_TEXTBOX, gender);

    }
}
