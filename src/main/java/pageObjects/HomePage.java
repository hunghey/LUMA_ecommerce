package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import pageUIs.HomePageUI;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogo() {
        isElementDisplayed(driver, HomePageUI.landingLogo);
    }

    public ProductList headerTransitNavigationMenu(String menu, String submenu) {
        if (menu == null || menu.isEmpty()) {
            System.out.println("Menu is EMPTY");
        } else {
            System.out.println("Navigating Menu: " + menu);
            sleepInSeconds(2);
            hoverToElement(driver, HomePageUI.headerNavigationMenu, menu);
        }
        if (submenu == null || submenu.isEmpty()) {
            System.out.println("SubMenu is EMPTY");
        } else {
            clickToElement(driver, HomePageUI.headerNavigationMenu, submenu);
        }
        return PageGenerator.getProductListPage(driver);
    }
}
