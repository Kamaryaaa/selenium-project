package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        // this line will maximize the currently opened window
        driver.manage().window().maximize();

        driver.get("https://www.tesla.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //use navigate back() to go back

        Thread.sleep(3000);
        driver.navigate().back();
        // use navigate to forward()

        Thread.sleep(3000);
      driver.navigate().forward();


        Thread.sleep(3000);
        driver.navigate().refresh();

        //navigate to():
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);



        // get title of the webpage



        Thread.sleep(3000);// close all the opened driver
        driver.quit();






    }
}
