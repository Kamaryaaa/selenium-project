package com.cydeo.tests.day02_findElements_GetText_GetAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC05_GetTextAndGetAttributePractice {
    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form
        String expectedHeader="Registration form";
        String actualHeader=driver.findElement(By.tagName("h2")).getText();
        System.out.println("actualHeader = " + actualHeader);
        System.out.println("expectedHeader = " + expectedHeader);
        if(actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASSED!!");
        }else {
            System.out.println("Header verification FAILED!");
        }

        //4- Locate “First name” input box
        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String expectedResult="first name";
        String actualResult=driver.findElement(By.name("firstname")).getAttribute("placeholder");
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);
        if(actualResult.equals(expectedResult)){
            System.out.println("PlaceHolder attribute's value verification PASSED!!");

        }else {
            System.out.println("PlaceHolder attribute's value verification FAILED!");

        }
    }
}
