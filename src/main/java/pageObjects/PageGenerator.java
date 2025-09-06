package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static HomePage getHomePage(WebDriver driver){
        return new HomePage(driver);
    }

    public static ProductList getProductListPage(WebDriver driver){
        return new ProductList(driver);
    }

    public static ProductDetails getProductDetailsPage(WebDriver driver){
        return new ProductDetails(driver);
    }
}
