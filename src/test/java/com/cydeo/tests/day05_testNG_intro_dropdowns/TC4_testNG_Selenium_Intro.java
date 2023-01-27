package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC4_testNG_Selenium_Intro {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.Go to https://www.cydeo.com
        driver.get("https://www.cydeo.com");

    }
@Test
    public void test1_cydeo_title_verification(){



    //3.Verify title
    //Expected: Cydeo
    String expectedTitle = "Cydeo";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);

    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



}
