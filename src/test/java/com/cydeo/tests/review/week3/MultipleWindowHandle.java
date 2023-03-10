package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowHandle extends TestBase {

    //// TC : Windows handle practice
    //    //    1. Open browser

    //    //

    @Test
    public void multiple_windows_handle_test(){
        //    //    2. Go to website: https://demoqa.com/browser-windows
        driver.get(ConfigurationReader.getProperty("demo.qa.url"));
        //    //    3. Click on New Tab button
        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
        WebElement newWindowMsg = driver.findElement(By.cssSelector("#messageWindowButton"));
//    //    4. Click on New Window button
        //    //    5. Click on New Window Message button
        newTab.click();
        newWindow.click();
        newWindowMsg.click();


        //6. Store parent window handle id in a variable
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String mainWindow = driver.getWindowHandle();
        System.out.println("mainWindow = " + mainWindow);
        //    //    7. Store all window handle ids in to a Set
        Set<String> allWindowHandle=driver.getWindowHandles();
        //    //    9. Print out each window id
        for (String each : allWindowHandle) {
            driver.switchTo().window(each);
            System.out.println("each = " + each);
            //System.out.println("Current window title: "+driver.getTitle());

            driver.switchTo().window(mainWindow);

        }

    }
}
