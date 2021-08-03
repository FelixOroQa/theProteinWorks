package com.ProteinWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProteinEndToEndTest {
    WebDriver driver;
    String browserType = "chrome";
    public WebDriverWait wait;

    @BeforeMethod
    public void beforeTest(){
        driver = utilsPackProteins.DriverFactory.open(browserType);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to("https://pensive-darwin.theproteinworks.com");
    }

    @Test
    public void performEndToEndTest(){
        //test will land on the homepage
        //amount of items added to the basket
        //go to the third product from the first carousel
        //select penultimate flavour from list
        //select the second available item in weight
        //add the above to the basket
        //Popup: add the first item
        //proceed to basket
        //try to add to add discount code: TESTDISCOUNT

    }


    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

}
/*
go to website
navigate to login
navigate to homepage
select a product
add item to shopping cart
proceed to checkout
verify item in the shopping cart
 */