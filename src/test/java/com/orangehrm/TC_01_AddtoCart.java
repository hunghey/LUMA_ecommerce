package com.orangehrm;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC_01_AddtoCart extends BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeTest(){
        driver = getWebdriver("chrome","https://demo.hyva.io/", false);
    }
    @Test
    public void TC1(){
        HomePage homePage = new HomePage(driver);
        homePage.checkLogo();
        homePage.headerTransitNavigationMenu("Women","Tops")
                .productListPage_Check_Title("Tops")
                .productListPage_Transit_ProductDetailsPage()
                .productDetailsPage_Check_Title("Mona Pullover Hoodlie")
                .productDetailsPage_AddToCart_WithInfo("XS","Orange","1")
                .productDetailsPage_Check_AddSucess("1")
                .header_Transit_CartPage()
                .miniCartPopup_Check_Title()
                .miniCartPopup_Check_InProduct("Mona Pullover Hoodlie","XS","Orange","1");
    }
    @AfterClass
    public void after() {
        driver.quit();
    }
}
