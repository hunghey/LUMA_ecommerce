package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){ this.driver = driver; }

    public void checkLogo(){
        isElementDisplayed(driver, HomePageUI.landingLogo);
    }

    public ProductList headerTransitNavigationMenu(String menu, String submenu, String submenu2){
        if (menu == null || menu.isEmpty()) {
            System.out.println("Menu is EMPTY");
        } else {
            System.out.println("Navigating Menu: " + menu);
            hoverToElement(driver,HomePageUI.headerNavigationMenu, menu);
        }
        if (submenu == null || submenu.isEmpty()) {
            System.out.println("SubMenu is EMPTY");
        } else if (submenu2 == null || submenu2.isEmpty()) {
            clickToElement(driver,HomePageUI.headerNavigationMenu, submenu);
        } else {
            hoverToElement(driver,HomePageUI.headerNavigationMenu, submenu);
        
            if (submenu2 == null || submenu2.isEmpty()) {
                System.out.println("SubMenu2 is EMPTY");
            } else {
                clickToElement(driver,HomePageUI.headerNavigationMenu, submenu2);
            }
        }
        return PageGenerator.getProductListPage(driver);
    }
}
