package com.cydeo.tests.review.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.tesla.com");

        Thread.sleep(3000);

        driver.quit();







    }
}
