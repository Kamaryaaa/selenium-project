package com.cydeo.tests.day09_review_javaFaker_driveUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC1_BingSearch {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
       //1- Open a chrome browser
        //2- Go to: https://bing.com
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigurationReader.getProperty("env"));
    }
    @Test
    public void bing_search_test(){
        //3- Write “apple” in search box
        WebElement inputBox = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
        BrowserUtils.sleep(3);
        inputBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Search";
        BrowserUtils.verifyTitle(driver,expectedTitle);

    }

    @AfterMethod
    public void teardownMethod(){
        BrowserUtils.sleep(1);
        driver.quit();
    }






}
