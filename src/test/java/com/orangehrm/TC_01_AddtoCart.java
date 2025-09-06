package com.orangehrm;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private HomePage homePage;

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
                .productDetailsPage_Check_AddSucess("1");

    }
//    @AfterClass
//    public void after() {
//        driver.quit();
//    }
}
