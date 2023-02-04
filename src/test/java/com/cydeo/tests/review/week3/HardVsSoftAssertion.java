package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardVsSoftAssertion {
    WebDriver driver;

    //   // 1. Open Chrome browser
    //    // 2. Go to https://practice.cydeo.com/registration_form
    //    // 3. Verify title is as expected:
    //    // Expected: "Registration Form"
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/registration_form");
    }

    @Test
    public void registration_form_page_test(){

        String expectedTitle="Registration Form";
        String actualTitle=driver.getTitle();


        Assert.assertEquals(expectedTitle,actualTitle,"Title verification FAILED!!");
        //Assert.assertEquals(driver.getTitle(),"Registration Form");

        // 12. Select "SDET" from Job title dropdown
        Select selectJob=new Select(driver.findElement(By.name("job_title")));
        selectJob.selectByVisibleText("SDET");

        // verify if "SDET" is selected
        Assert.assertTrue(selectJob.getFirstSelectedOption().getText().equals("SDET"));
        /*

        //    // 13. Click to "Java" from languages
        WebElement languages = driver.findElement(By.cssSelector("input[value='java']"));
        languages.click();

        //    // 14. Click to "Sign up" button
        WebElement signupButton = driver.findElement(By.id("wooden_spoon"));
        signupButton.click();
        //    // 15. Verify text displayed on page
        //    //     Expected: "Well done!"
        String expectedText="Well done!";
        String actualText=driver.findElement(By.tagName("h4")).getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);
        Assert.assertEquals(actualText,expectedText);

         */
    }

    @Test
    public void registration_form_page_testSoftAssertion(){

        String expectedTitle="Registration Form";
        String actualTitle=driver.getTitle();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedTitle,actualTitle,"Title verification FAILED!!!");
        System.out.println("After soft assertion failed!");

        // 12. Select "SDET" from Job title dropdown
        Select selectJob=new Select(driver.findElement(By.name("job_title")));
        selectJob.selectByVisibleText("SDET");

        // verify if "SDET" is selected
        softAssert.assertTrue(selectJob.getFirstSelectedOption().getText().equals("SDET"));
        /*

        //    // 13. Click to "Java" from languages
        WebElement languages = driver.findElement(By.cssSelector("input[value='java']"));
        languages.click();

        //    // 14. Click to "Sign up" button
        WebElement signupButton = driver.findElement(By.id("wooden_spoon"));
        signupButton.click();
        //    // 15. Verify text displayed on page
        //    //     Expected: "Well done!"
        String expectedText="Well done!";
        String actualText=driver.findElement(By.tagName("h4")).getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);
        Assert.assertEquals(actualText,expectedText);

         */
    }




    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}

