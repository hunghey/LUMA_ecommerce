package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.AddNewEmployee;
import pageObjects.pim.employee.ContactDetails;
import pageObjects.pim.employee.EmployeeListDetail;
import pageObjects.pim.employee.PersonalDetails;

public class PageGenerator {

    public static HomePage getHomePage(WebDriver driver){
        return new HomePage(driver);
    }

    public static ProductList getProductListPage(WebDriver driver){
        return new ProductList(driver);
    }

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
