package com.orangehrm;

import commons.BaseTest;
import models.Employee;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.Login;
import pageObjects.PageGenerator;
import pageObjects.pim.employee.AddNewEmployee;
import pageObjects.pim.employee.ContactDetails;
import pageObjects.pim.employee.EmployeeListDetail;
import pageObjects.pim.employee.PersonalDetails;
import utilities.ScreenshotUtil;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private Dashboard dashboardPage;
    private Login loginPage;
    private AddNewEmployee addNewEmployeePage;
    private ContactDetails contactDetailsPage;
    private EmployeeListDetail employeeListDetailPage;
    private PersonalDetails personalDetailsPage;
    private Employee employee;

//    // Constant test data
//    private static final String ADMIN_USERNAME = "Admin";
//    private static final String ADMIN_PASSWORD = "admin123";
//    private static final String FIRST_NAME = "Method";
//    private static final String LAST_NAME = "Hung";
//    private static final String AVATAR_IMAGE = "hcmCity.jpg";
//
//    private static final String FIRST_NAME_CHANGE = "SAUL";
//    private static final String LAST_NAME_CHANGE = "LE";
//    private static final String DRIVER_LICENSE = "15675987";
//    private static final String EXPIRE_DATE_DRIVER_LICENSE = "2026-12-12";
//    private static final String NATIONAL = "American";
//    private static final String MARITAL = "Single";
//    private static final String DATE_OF_BIRTH = "2002-04-01";
//    private static final String GENDER = "Male";

    private String employeeID;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getWebdriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);
        employee = new Employee();

        employee.setUsername("Admin");
        employee.setPassword("admin123");
        employee.setFirstname("Nguyen Thu");
        employee.setLastname("Hung");
        employee.setAvtImg("hcmCity.jpg");

        employee.setChangeFirstname("Tran Bao");
        employee.setChangeLastname("Tram");
        employee.setDeliverLicense("15675987");
        employee.setExpireDateDriverLicense("2026-12-12");
        employee.setNational("American");
        employee.setMarital("Single");
        employee.setDateOfBirth("2002-04-01");
        employee.setGender("Male");

        loginPage.enterToUserName(employee.getUsername());
        loginPage.enterToPassword(employee.getPassword());
        dashboardPage = loginPage.clickToLoginPage();

    }

    @Test
    public void Employee_01_Add_New() {
        employeeListDetailPage = dashboardPage.clickToPIM();
        addNewEmployeePage = employeeListDetailPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(employee.getFirstname());
        addNewEmployeePage.enterToClassNameTextbox(employee.getLastname());

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

        personalDetailsPage.uploadMultipleFiles(driver, employee.getAvtImg());
        personalDetailsPage.clickToSaveBtnAvatar();

        Assert.assertEquals(personalDetailsPage.getMessageValidate(), "Successfully Updated");
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(personalDetailsPage.getTitleEmployee(), "Change Profile Picture");
        Assert.assertFalse(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeChangeAvatar));
    }

    @Test
    public void Employee_03_Edit_Employee_Personal_Details(){
        personalDetailsPage.openPersonalDetailPage();

        personalDetailsPage.enterToFirstNameTextbox(employee.getChangeFirstname());
        personalDetailsPage.enterToLastNameTextbox(employee.getChangeLastname());

        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        System.out.println(employeeID);
        personalDetailsPage.enterToDriverLicenseTextbox(employee.getDeliverLicense());
        personalDetailsPage.enterToLicenseExpiryDate(employee.getExpireDateDriverLicense());
        personalDetailsPage.selectNationalDropdown(employee.getNational());
        personalDetailsPage.selectMaritalStatusDropdown(employee.getMarital());
        personalDetailsPage.enterToDateOfBirthTextbox(employee.getDateOfBirth());

        personalDetailsPage.selectGenderMaleRadioButton(employee.getGender());
        personalDetailsPage.clickSaveButton();

        Assert.assertEquals(personalDetailsPage.getMessageValidate(), "Successfully Updated");

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstNameValue(),employee.getChangeFirstname());
        Assert.assertEquals(personalDetailsPage.getLastNameValue(),employee.getChangeLastname());
        Assert.assertEquals(personalDetailsPage.getEmployeeID(),employeeID);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateValue(),employee.getExpireDateDriverLicense());
        Assert.assertEquals(personalDetailsPage.getNationalDropdownValue(),employee.getNational());
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(),employee.getMarital());
        Assert.assertEquals(personalDetailsPage.getDateOfBirthValue(),employee.getDateOfBirth());
        Assert.assertTrue(personalDetailsPage.isGenderMaleValue(employee.getGender()));



    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
