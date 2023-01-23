package com.cydeo.tests.day02_findElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04_LibraryVerification {
    public static void main(String[] args) {


        //TC #4: Library verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");
        //3. Enter username: “incorrect@email.com”
        driver.findElement(By.className("form-control")).sendKeys("incorrect@email.com");
        //4. Enter password: “incorrect password”
        driver.findElement(By.id("inputPassword")).sendKeys("incorrect password");
        //5. Verify: visually “Sorry, Wrong Email or Password”
        //displayed
        driver.findElement(By.tagName("button")).click();
        //PS: Locate username input box using “className” locator
        //Locate password input box using “id” locator
        //Locate Sign in button using “tagName” locator



    }
}
