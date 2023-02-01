package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
    this class will be storing only the utility methods that can be used across the project
     */
public class BrowserUtils {
    /*
    this method will accept int in seconds and excute Thread.sleep method for given second
     */


    public static void sleep(int second){
        second *=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }

    }


    public static void switchWindowAndVerify(WebDriver driver,String expectedInURL, String expectedInTitle){

        Set<String> windowHandlers=driver.getWindowHandles();

        for (String eachHandler : windowHandlers) {
            driver.switchTo().window(eachHandler);
            System.out.println("Current URL: = " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }






}
