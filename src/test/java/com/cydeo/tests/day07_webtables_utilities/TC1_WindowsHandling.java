package com.cydeo.tests.day07_webtables_utilities;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC1_WindowsHandling {
    WebDriver driver;

    @BeforeMethod
    public void startupMethod() {
        //. Create new test and make set-ups
        //2. Go to : https://www.amazon.com
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }

    @Test
    public void window_handling_test() {
        //3. Copy and paste the lines from below into your class

        //Lines to be pasted:
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.

        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> windowHandlers = driver.getWindowHandles();
        for (String eachHandler : windowHandlers) {
            driver.switchTo().window(eachHandler);
            System.out.println("Current URL: = " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }
        //5. Assert: Title contains “Etsy”
        //String expectedTitle = "Etsy";
        //String actualTitle = driver.getTitle();
        //System.out.println("actualTitle = " + actualTitle);
        //Assert.assertTrue(actualTitle.contains(expectedTitle));
        BrowserUtils.verifyTitleContains(driver, "Etsy");

    }

    @Test
    public void window_handling_test2() {
        //3. Copy and paste the lines from below into your class

        //Lines to be pasted:
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.

        //4. Create a logic to switch to the tab where Etsy.com is open
        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");


    }

    @AfterMethod
    public void teardownMethod(){
        BrowserUtils.sleep(2);
        driver.quit();
    }
}