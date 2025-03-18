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
    public void Employee_Add_New() {
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
    public void Employee_Upload_Avatar() throws InterruptedException {
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

    @AfterClass
    public void after() {
        driver.quit();
    }
}
