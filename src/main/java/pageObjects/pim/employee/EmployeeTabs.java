package pageObjects.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.pim.employee.EmployeeTabUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver){ this.driver = driver; }

    public PersonalDetails openPersonalDetailPage(){
        waitForElementClickable(driver, EmployeeTabUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EmployeeTabUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
    public ContactDetails openContactDetailsPage(){
        waitForElementClickable(driver, EmployeeTabUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EmployeeTabUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getContactDetailsPage(driver);
    }

}
