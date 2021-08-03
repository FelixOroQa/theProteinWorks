package com.ProteinWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RelevantCreateAccountTest {
    WebDriver driver;
    String browserType = "chrome";
    public WebDriverWait wait;

    @BeforeMethod
    public void beforeTest(){
        driver = utilsPackProteins.DriverFactory.open(browserType);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to("https://pensive-darwin.theproteinworks.com/customer/account/create");
    }

    @Test
    public void createAccountTest(){
        WebElement enterFirstnameTextField = driver.findElement(By.id("firstname"));
        enterFirstnameTextField.sendKeys("Felix");

        WebElement enterLastnameTextField = driver.findElement(By.id("lastname"));
        enterLastnameTextField.sendKeys("Oro");

        WebElement enterEmailTextField = driver.findElement(By.id("email_address"));
        enterEmailTextField.sendKeys("felix.oro@theprotein");

        WebElement enterPasswordTextField = driver.findElement(By.id("password"));
        enterPasswordTextField.sendKeys("theProteinTest");

        WebElement enterConfirmedPasswordTextField = driver.findElement(By.id("password-confirmation"));
        enterConfirmedPasswordTextField.sendKeys("theProteinTest");

        WebElement enterGenderTextField = driver.findElement(By.id("gender"));
        enterGenderTextField.sendKeys("Male");

//enterDateOfBirthDatePicker

        //WebElement enterDateOfBirthDatePicker = driver.findElement(By.id("email"));
        //enterDateOfBirthDatePicker.sendKeys("felix.oro@theprotein");


        WebElement enterMobileTextField = driver.findElement(By.id("mobile_number_input"));
        enterMobileTextField.sendKeys("07400223344");

//selectMainGoalList
        //WebElement selectMainGoalList = driver.findElement(By.id("customer_goal"));
        //selectMainGoalList.sendKeys("TestDISCOUNT");


        WebElement enterReferralCodeTextField = driver.findElement(By.id("referrer"));
        enterReferralCodeTextField.sendKeys("TestDISCOUNT");

//not working
        //WebElement enterGetVIPListTextField = driver.findElement(By.id(""));
        //enterGetVIPListTextField.sendKeys("Automation VIP test");


        //click on calendar widget
        WebElement clickOnCalendarWidget = driver.findElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/form[1]/fieldset[1]/div[7]/div[1]/button[1]"));
        clickOnCalendarWidget.click();

        //click on calendar widget
        WebElement clickOnYearWidget = driver.findElement(By.xpath("//option[contains(text(),'1990')]"));
        clickOnYearWidget.click();

        //click on calendar widget
        WebElement clickOnMonthWidget = driver.findElement(By.xpath("//option[contains(text(),'Aug')]"));
        clickOnMonthWidget.click();

        //click on calendar widget
        WebElement clickOnDayWidget = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]"));
        clickOnDayWidget.click();


        WebElement clickCountMeInRadioButton = driver.findElement(By.cssSelector("#is_subscribed_no"));
        clickCountMeInRadioButton.click();

        WebElement clickJoinUpButton = driver.findElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]"));
        clickJoinUpButton.click();
    }
    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

}
