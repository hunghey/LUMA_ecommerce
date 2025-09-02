package pageObjects;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.EmployeeListDetail;
import pageUIs.DashboardUI;

public class Luma extends BaseTest {
    private WebDriver driver;

    public HomePage OpenLumaBrowser(String browser, String url, boolean headless) {
        driver = getWebdriver(browser,url, headless);
        return PageGenerator.getHomePage(driver);
    }
}
