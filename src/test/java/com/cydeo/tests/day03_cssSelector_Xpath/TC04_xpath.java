package com.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC04_xpath {
    public static void main(String[] args) {


        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
                                                                           //"//input[class='login']"
        String expectedText="Log In";
        String actualText=loginButton.getAttribute("value");
        if(actualText.equals(expectedText)){
            System.out.println("Login Button text verification is PASSED!!!");
        }else {
            System.out.println("Login Button text verification is FAILED!");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
        //command+f --> search box in inspec
    }

}
