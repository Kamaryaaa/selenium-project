package com.cydeo.tests.day08_properties_config_reader;

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

public class TC4_use_config_reader {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //Go to: https://practice.cydeo.com/web-tables
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.get(ConfigurationReader.getProperty("googleURL"));
        BrowserUtils.sleep(1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void google_search_title(){
        //3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
        //4- Verify title:
        //Expected: apple - Google Search
        BrowserUtils.sleep(2);
        BrowserUtils.verifyTitle(driver,ConfigurationReader.getProperty("searchValue")+" - Google Search");
    }
    @AfterMethod
    public void tearDownMethod(){
        BrowserUtils.sleep(1);
        driver.quit();
    }
}
