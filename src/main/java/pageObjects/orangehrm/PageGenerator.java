package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.AddNewEmployee;
import pageObjects.orangehrm.pim.employee.ContactDetails;
import pageObjects.orangehrm.pim.employee.EmployeeListDetail;
import pageObjects.orangehrm.pim.employee.PersonalDetails;

public class PageGenerator {
    public static Login getLoginPage(WebDriver driver){
        return new Login(driver);
    }

    public static Dashboard getDashboardPage(WebDriver driver){
        return new Dashboard(driver);
    }

    public static AddNewEmployee getAddNewEmployeePage(WebDriver driver){
        return new AddNewEmployee(driver);
    }

    public static ContactDetails getContactDetailsPage(WebDriver driver){
        return new ContactDetails(driver);
    }

    public static EmployeeListDetail getEmployeeListPage(WebDriver driver){
        return new EmployeeListDetail(driver);
    }

    public static PersonalDetails getPersonalDetailsPage(WebDriver driver){
        return new PersonalDetails(driver);
    }
}
