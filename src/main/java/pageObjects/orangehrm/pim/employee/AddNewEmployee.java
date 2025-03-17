package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.oranghrm.pim.employee.AddNewEmployeeUI;

public class AddNewEmployee extends BasePage {
    private WebDriver driver;

    public AddNewEmployee(WebDriver driver){ this.driver = driver; }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddNewEmployeeUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeeUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToClassNameTextbox(String lastName) {
        waitForElementVisible(driver, AddNewEmployeeUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeeUI.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddNewEmployeeUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddNewEmployeeUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public PersonalDetails clickToSaveButton() {
        waitForElementVisible(driver, AddNewEmployeeUI.SAVE_BUTTON_AT_THE_EMPLOYEE);
        clickToElement(driver, AddNewEmployeeUI.SAVE_BUTTON_AT_THE_EMPLOYEE);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}
