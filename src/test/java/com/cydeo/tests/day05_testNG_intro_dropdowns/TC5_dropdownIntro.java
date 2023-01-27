package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC5_dropdownIntro {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        //1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.Go to https://www.cydeo.com
        driver.get("https://practice.cydeo.com/dropdown");

    }
    @Test
    public void simpleDropdown(){
        //Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        //creating select class obj, and passing the dropdown web element into the constructor

        Select select = new Select(simpleDropdown);

        String expectedDefaultValue="Please select an option";
        String actualDefaultValue=select.getFirstSelectedOption().getText();

        Assert.assertTrue(actualDefaultValue.equals(expectedDefaultValue));

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State

        //WebElement stateSelection = driver.findElement(By.xpath("//select[@id='state']"));
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String expectedText = "Select a State";
        String actualText = selectState.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText,expectedText);
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
