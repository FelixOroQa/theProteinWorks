package com.ProteinWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class NumberOfLinksTest {
    WebDriver driver;
    String browserType = "chrome";
    public WebDriverWait wait;
    String homePage = "https://pensive-darwin.theproteinworks.com/products/protein-shakes";
    String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;

    @BeforeMethod
    public void beforeTest(){
        driver = utilsPackProteins.DriverFactory.open(browserType);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to("https://pensive-darwin.theproteinworks.com/products/protein-shakes");
    }

    @Test
    public void numberOfLinkTest(){
        WebElement numberOfLinksOnPage = driver.findElement(By.className("page-wrapper"));
        System.out.println(numberOfLinksOnPage.findElements(By.tagName("a")).size());

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

}

