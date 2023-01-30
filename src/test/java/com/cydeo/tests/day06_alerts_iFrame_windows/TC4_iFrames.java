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

public class TC4_iFrames {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/iframe");
    }



    @Test
    public void iframe_tes(){
        //Assert: “Your content goes here.” Text is displayed.
        //driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        WebElement paragraphText = driver.findElement(By.tagName("p"));

        String expectedText = "Your content goes here.";
        String actualText = paragraphText.getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);

        Assert.assertEquals(expectedText,actualText,"Text is NOT displayed");
        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actual = driver.findElement(By.tagName("h3")).getText();
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);

        Assert.assertEquals(expected,actual,"Text is NOT displayed");

    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }




}
