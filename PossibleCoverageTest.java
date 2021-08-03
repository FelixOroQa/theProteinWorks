package com.ProteinWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PossibleCoverageTest {
    WebDriver driver;
    String browserType = "chrome";
    public WebDriverWait wait;

    @BeforeMethod
    public void beforeTest(){
        driver = utilsPackProteins.DriverFactory.open(browserType);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to("https://pensive-darwin.theproteinworks.com/customer/account/login");
    }

    @Test
    public void enterValidSignInCredentials(){

        WebElement enterValidUsername = driver.findElement(By.id("email"));
        enterValidUsername.sendKeys("felix.oro@theproteinworks.com");

        WebElement enterValidPassword = driver.findElement(By.id("pass"));
        enterValidPassword.sendKeys("password");

        WebElement clickSignInButton = driver.findElement(By.id("send2"));
        clickSignInButton.click();
    }
    @Test
    public void enterInvalidSignInCredentials(){

        WebElement enterInvalidUsername = driver.findElement(By.id("email"));
        enterInvalidUsername.sendKeys("felix.oro@theprotein");

        WebElement enterInvalidPassword = driver.findElement(By.id("pass"));
        enterInvalidPassword.sendKeys("Leggings");

        WebElement clickSignInButton = driver.findElement(By.id("send2"));
        clickSignInButton.click();
    }
    @Test
    public void searchForItems(){
        WebElement searchForItems = driver.findElement(By.id("search"));
        searchForItems.sendKeys("Ridiculous Vegan Protein Bar");
        searchForItems.sendKeys(Keys.ENTER);
    }

    @Test
    public void clickLinksOnPage(){
        WebElement clickOnCertainLinks = driver.findElement(By.className("menu-title"));
        clickOnCertainLinks.click();
    }


    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

}

