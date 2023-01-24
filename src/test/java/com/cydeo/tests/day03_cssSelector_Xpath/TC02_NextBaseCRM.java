package com.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC02_NextBaseCRM {
    public static void main(String[] args) {

     //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedLabel="Remember me on this computer";
        String actualLabel = driver.findElement(By.className("login-item-checkbox-label")).getText();
        if(actualLabel.equals(expectedLabel)){
            System.out.println("Label verification is PASSED!!!");
        }else {
            System.out.println("Label verification is FAILED!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedLinkText="FORGOT YOUR PASSWORD?";
        String actualLinkText = driver.findElement(By.className("login-link-forgot-pass")).getText();
        System.out.println("actualLinkText = " + actualLinkText);
        System.out.println("expectedLinkText = " + expectedLinkText);
        if (actualLinkText.equals(expectedLinkText)) {

            System.out.println("Link text verification is PASSED!!!");
        }else {
            System.out.println("Link text verification is FAILED!!!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedHREFvalue = "forgot_password=yes";
        String actualHREFvalue= driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        if(actualHREFvalue.contains(expectedHREFvalue)){
            System.out.println("href Value verification is PASSED!!!");
        }else{
            System.out.println("href Value verification is FAILED!");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.





    }
}
