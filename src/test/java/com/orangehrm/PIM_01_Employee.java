package com.orangehrm;

import com.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.Dashboard;
import pageObjects.orangehrm.Login;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.AddNewEmployee;
import pageObjects.orangehrm.pim.employee.ContactDetails;
import pageObjects.orangehrm.pim.employee.EmployeeListDetail;
import pageObjects.orangehrm.pim.employee.PersonalDetails;
import utilities.ScreenshotUtil;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private Dashboard dashboardPage;
    private Login loginPage;
    private AddNewEmployee addNewEmployeePage;
    private ContactDetails contactDetailsPage;
    private EmployeeListDetail employeeListDetailPage;
    private PersonalDetails personalDetailsPage;

    // Constant test data
    private static final String ADMIN_USERNAME = "Admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String FIRST_NAME = "Method";
    private static final String LAST_NAME = "Hung";
    private static final String AVATAR_IMAGE = "hcmCity.jpg";

    private static final String FIRST_NAME_CHANGE = "SAUL";
    private static final String LAST_NAME_CHANGE = "LE";
    private static final String DRIVER_LICENSE = "15675987";
    private static final String EXPIRE_DATE_DRIVER_LICENSE = "2026-12-12";
    private static final String NATIONAL = "American";
    private static final String MARITAL = "Single";
    private static final String DATE_OF_BIRTH = "2002-04-01";
    private static final String GENDER = "Male";

    private String employeeID;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getWebdriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUserName(ADMIN_USERNAME);
        loginPage.enterToPassword(ADMIN_PASSWORD);
        dashboardPage = loginPage.clickToLoginPage();

    }

    @Test
    public void Employee_01_Add_New() {
        employeeListDetailPage = dashboardPage.clickToPIM();
        addNewEmployeePage = employeeListDetailPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(FIRST_NAME);
        addNewEmployeePage.enterToClassNameTextbox(LAST_NAME);

        employeeID = addNewEmployeePage.getEmployeeID();
        personalDetailsPage = addNewEmployeePage.clickToSaveButton();
        Assert.assertEquals(personalDetailsPage.getMessageValidate(), "Successfully Saved");
        Assert.assertEquals(personalDetailsPage.getTitleEmployee(), "Personal Details");
    }

    @Test
    public void Employee_02_Upload_Avatar() throws InterruptedException {
        personalDetailsPage.clickToElementAvatarImage();
        Thread.sleep(3000);
        String beforeChangeAvatar = ScreenshotUtil.captureScreenshot(driver);

        personalDetailsPage.uploadMultipleFiles(driver, AVATAR_IMAGE);
        personalDetailsPage.clickToSaveBtnAvatar();

        Assert.assertEquals(personalDetailsPage.getMessageValidate(), "Successfully Updated");
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(personalDetailsPage.getTitleEmployee(), "Change Profile Picture");
        Assert.assertFalse(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeChangeAvatar));
    }

    @Test
    public void Employee_03_Edit_Employee_Personal_Details(){
        personalDetailsPage.openPersonalDetailPage();

        personalDetailsPage.enterToFirstNameTextbox(FIRST_NAME_CHANGE);
        personalDetailsPage.enterToLastNameTextbox(LAST_NAME_CHANGE);

        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        System.out.println(employeeID);
        personalDetailsPage.enterToDriverLicenseTextbox(DRIVER_LICENSE);
        personalDetailsPage.enterToLicenseExpiryDate(EXPIRE_DATE_DRIVER_LICENSE);
        personalDetailsPage.selectNationalDropdown(NATIONAL);
        personalDetailsPage.selectMaritalStatusDropdown(MARITAL);
        personalDetailsPage.enterToDateOfBirthTextbox(DATE_OF_BIRTH);

        personalDetailsPage.selectGenderMaleRadioButton(GENDER);
        personalDetailsPage.clickSaveButton();

        Assert.assertEquals(personalDetailsPage.getMessageValidate(), "Successfully Updated");

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstNameValue(),FIRST_NAME_CHANGE);
        Assert.assertEquals(personalDetailsPage.getLastNameValue(),LAST_NAME_CHANGE);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(),employeeID);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateValue(),EXPIRE_DATE_DRIVER_LICENSE);
        Assert.assertEquals(personalDetailsPage.getNationalDropdownValue(),NATIONAL);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(),MARITAL);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthValue(),DATE_OF_BIRTH);
        Assert.assertTrue(personalDetailsPage.isGenderMaleValue(GENDER));



    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
