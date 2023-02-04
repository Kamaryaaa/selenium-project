package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPractice extends TestBase {



//    WebDriver driver;
//
//
//    @BeforeMethod
//    public void setupMethod(){
//        //    1. Open browser
////    2. Go to website: https://practice.cydeo.com/javascript_alerts
//        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get("https://practice.cydeo.com/javascript_alerts");
//
//    }
    @Test
    public void prompt_alert_test(){
        driver.get("https://practice.cydeo.com/javascript_alerts");
       // 3. Click to “Click for JS Prompt” button
        WebElement jsPromptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptAlert.click();

//    4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        alert.sendKeys("hello");
        BrowserUtils.sleep(1);
//    5. Click to OK button from the alert
        BrowserUtils.sleep(1);
        alert.accept();
//    6. Verify “You entered: hello” text is displayed.
         WebElement resultText=driver.findElement(By.id("result"));
         String actualText=resultText.getText();
         String expectedText = "You entered: hello";
        Assert.assertEquals(expectedText,actualText,"Text verification FAILED!!!");

    }

//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }




}
