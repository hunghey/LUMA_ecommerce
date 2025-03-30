package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.EmployeeListDetail;
import pageUIs.DashboardUI;

public class Dashboard extends BasePage {
    private WebDriver driver;

    public Dashboard(WebDriver driver){ this.driver = driver; }

    public EmployeeListDetail clickToPIM() {
        waitForElementVisible(driver, DashboardUI.PIM_LINK);
        clickToElement(driver, DashboardUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}
