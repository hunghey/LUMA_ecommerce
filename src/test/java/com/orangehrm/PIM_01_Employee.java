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
        driver = getWebdriver("chrome","https://magento-demo.mageplaza.com/", false);
    }
    @Test
    public void TC1(){
        HomePage homePage = new HomePage(driver);
        homePage.checkLogo();
        homePage.headerTransitNavigationMenu("Women","Tops",null);  
        System.out.println("aaa");

    }
    @AfterClass
    public void after() {
        driver.quit();
    }
}
