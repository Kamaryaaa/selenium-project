package com.cydeo.tests.day02_findElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_CydeoVerification {
    public static void main(String[] args) {


           //TC #1: Cydeo practice tool verifications

//1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //          Verify URL contains
        String expectedURL="cydeo";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification passed");
        }else {
            System.out.println("URL verification failed");
        }

        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is passed!!!");
        }else {
            System.out.println("Title verification is FAILED!");
        }

        driver.quit();


    }
        }