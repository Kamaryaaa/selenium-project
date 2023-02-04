package com.cydeo.tests.day09_review_javaFaker_driveUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC2_DriverUtil_Practice {

    //WebDriver driver;
    //
    //
    //    @BeforeMethod
    //    public void setupMethod(){
    //        //1- Open a Chrome browser
    //        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
    //        driver.manage().window().maximize();
    //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //    }
    @Test
    public void bing_search_test(){
        //2- Go to: https://bing.com
        //3- Write “apple” in search box
        //Driver.getDriver()  ---> will return me the "driver"
        //instead of writing "driver", from now on, we will write Driver.getDriver()
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@id='sb_form_q']"));
        BrowserUtils.sleep(3);
        inputBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Search";
        BrowserUtils.verifyTitle(Driver.getDriver(),expectedTitle);

    }

    @Test
    public void bing_search_test2(){
        //2- Go to: https://bing.com
        //3- Write “apple” in search box
        //Driver.getDriver()  ---> will return me the "driver"
        //instead of writing "driver", from now on, we will write Driver.getDriver()
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@id='sb_form_q']"));
        BrowserUtils.sleep(3);
        inputBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Search";
        BrowserUtils.verifyTitle(Driver.getDriver(),expectedTitle);

    }

    @AfterMethod
    public void teardownMethod(){
        BrowserUtils.sleep(1);
        //Driver.getDriver().quit();
        Driver.closeDriver();
    }
}
