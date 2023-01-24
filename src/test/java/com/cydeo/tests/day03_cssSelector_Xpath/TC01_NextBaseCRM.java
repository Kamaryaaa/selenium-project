package com.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_NextBaseCRM {
    public static void main(String[] args) {

      //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
        loginBox.sendKeys("incorrectusername");
        //4- Enter incorrect password: “incorrect”
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("incorrectpassword");
        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.

        String expectedResult = "Incorrect login or password";
        String actualResult = driver.findElement(By.className("errortext")).getText();
        if (actualResult.equals(expectedResult)) {
            System.out.println("Eroor massage verification is PASSED!!!");
        }else {
            System.out.println("Error massage verification is FAILED!");
        }





    }
}
