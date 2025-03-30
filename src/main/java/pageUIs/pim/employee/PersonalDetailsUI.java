package pageUIs.pim.employee;

public class PersonalDetailsUI {
    public static final String MAIN_TITLE = "CSS=div.orangehrm-vertical-padding>h6.orangehrm-main-title";
    public static final String EMPLOYEE_IMAGE = "CSS=div.orangehrm-edit-employee-image>img.employee-image";
    public static final String SAVE_BTN_CHANGE_PROFILE = "CSS=div.oxd-form-actions>button";
    public static final String MESSAGE_VALIDATE = "XPATH=//div[@id='oxd-toaster_1']//p[contains(@class,'toast-message')]";

    public static final String FIRSTNAME_TEXTBOX = "NAME=firstName";
    public static final String LASTNAME_TEXTBOX = "NAME=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "XPATH=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_TEXTBOX = "XPATH=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div//input";
    public static final String LICENSE_EXPIRE_DATE_TEXTBOX = "XPATH=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";

    //setTimeout(() => {debugger;}, 3000)
    public static final String NATIONAL_PARENT_DROPDOWN= "XPATH=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONAL_CHILD_DROPDOWN= "XPATH=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]//span";
    public static final String NATIONAL_SELECTED_DROPDOWN = "XPATH=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_PARENT_STATUS_DROPDOWN = "XPATH=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_CHILD_DROPDOWN = "XPATH=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String MARITAL_STATUS_SELECT_DROPDOWN = "XPATH=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
    public static final String DATE_OF_BIRTH_TEXTBOX = "XPATH=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String GENDER_TEXTBOX = "XPATH=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(.,'%s')]/input";
    public static final String SAVE_BTN = "XPATH=//h6[text()='Personal Details']/following-sibling::form//button";

}
