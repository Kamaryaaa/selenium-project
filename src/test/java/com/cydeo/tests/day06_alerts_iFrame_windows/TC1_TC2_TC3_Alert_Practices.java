package com.cydeo.tests.day06_alerts_iFrame_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC1_TC2_TC3_Alert_Practices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void information_alert_test1() throws InterruptedException {

        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        informationAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expectedText = "You successfully clicked an alert";
        String actualText = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']")).getText();

        Assert.assertEquals(actualText,expectedText,"Result is NOT displayed");

    }
    @Test
    public void confirmation_alert_test2() throws InterruptedException {

        //3. Click to “Click for JS Confirm” button
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        String actualText = driver.findElement(By.xpath("//p[.='You clicked: Ok']")).getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualText,expectedText,"Result is NOT displayed");
    }
    @Test
    public void prompt_alert_test3() throws InterruptedException {

        //3. Click to “Click for JS Prompt” button
        WebElement promptAlertButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptAlertButton.click();
        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        alert.sendKeys("hello");
        Thread.sleep(2000);

        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.
        String expectedText = "You entered: hello";
        String actualText = driver.findElement(By.xpath("//p[.='You entered: hello']")).getText();

        Assert.assertEquals(actualText,expectedText,"Result is NOT displayed");



    }


@AfterMethod
    public void teardownMethod() throws InterruptedException {

    Thread.sleep(2000);
       driver.quit();
}



}
