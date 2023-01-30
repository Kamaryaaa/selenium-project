package com.cydeo.tests.day06_alerts_iFrame_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC5_WindowsPractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/windows");
    }
    @Test
    public void multiple_window_test(){
        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"Title Mismatch");

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        System.out.println("Title before click: "+driver.getTitle());

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();
        System.out.println("Title after click: "+driver.getTitle());


        //6. Switch to new Window. we need to use driver.getWindowHandles() method
        //1 main window// 2 - 2nd window

        for ( String each: driver.getWindowHandles()  ) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: "+driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterSwitching = "New Window";
        actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitleAfterSwitching,actualTitle);


        driver.switchTo().window(mainHandle);
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }




}
