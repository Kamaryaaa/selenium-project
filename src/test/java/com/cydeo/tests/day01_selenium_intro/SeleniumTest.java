package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {


        //1-Setting up the webdriver manager
        WebDriverManager.chromedriver().setup();

        //create the instance of Chrome browser driver
        WebDriver driver=new ChromeDriver();

        //3- test if driver and browser are working as expected
        driver.get("https://www.google.com");

        Thread.sleep(5000);

        driver.close();






    }
}
