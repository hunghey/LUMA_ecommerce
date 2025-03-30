package pageObjects.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.pim.employee.EmployeeListDetailsUI;

public class EmployeeListDetail extends BasePage {
    private WebDriver driver;

    public EmployeeListDetail(WebDriver driver){ this.driver = driver; }

    public AddNewEmployee clickToAddEmployeeButton() {
        waitForElementVisible(driver, EmployeeListDetailsUI.ADD_EMPLOYEE_NAV_BUTTON);
        clickToElement(driver, EmployeeListDetailsUI.ADD_EMPLOYEE_NAV_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }
}
