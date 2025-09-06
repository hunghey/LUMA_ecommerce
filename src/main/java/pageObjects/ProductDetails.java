package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.HomePageUI;
import pageUIs.ProductDetailsPageUI;
import pageUIs.ProductListPageUI;

public class ProductDetails extends BasePage {
    private WebDriver driver;

    public ProductDetails(WebDriver driver){ this.driver = driver; }

    public ProductDetails productDetailsPage_Check_Title(String expectedTitle ){
        String actualTitle = getElementText(driver, ProductDetailsPageUI.productDetailsPage_Title);
        Assert.assertEquals(actualTitle, expectedTitle);
        return PageGenerator.getProductDetailsPage(driver);
    }

    public ProductDetails productDetailsPage_AddToCart_WithInfo(String size, String color, String qty) {
        clickToElement(driver,ProductDetailsPageUI.productDetailsPage_Size, size);
        clickToElement(driver,ProductDetailsPageUI.productDetailsPage_Color, color);
        sendKeyToElement(driver,ProductDetailsPageUI.productDetailsPage_Qty,qty);
        clickToElement(driver,ProductDetailsPageUI.productDetailsPage_addToCart);
        return PageGenerator.getProductDetailsPage(driver);
    }

    public ProductDetails productDetailsPage_Check_AddSucess(String expectedQty) {
        isElementDisplayed(driver, ProductDetailsPageUI.productDetailsPage_messageSuccess);
        String actualQty = getElementText(driver, ProductDetailsPageUI.productDetailsPage_QtyInCart);
        Assert.assertEquals(actualQty, expectedQty);
        return PageGenerator.getProductDetailsPage(driver);
    }
}
