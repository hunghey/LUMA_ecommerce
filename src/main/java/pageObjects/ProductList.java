package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageUIs.HomePageUI;
import pageUIs.ProductListPageUI;

public class ProductList extends BasePage {
    private WebDriver driver;

    public ProductList(WebDriver driver){ this.driver = driver; }

    public ProductList productListPage_Check_Title(String expectedTitle){
        String actualTitle = getElementText(driver, ProductListPageUI.productListPage_Title);
        Assert.assertEquals(actualTitle, expectedTitle);
        return PageGenerator.getProductListPage(driver);
    }
    
    public ProductDetails productListPage_Transit_ProductDetailsPage(){
        clickToElement(driver,ProductListPageUI.productListPage_FirstProduct);
        return PageGenerator.getProductDetailsPage(driver);
    }
    
}
