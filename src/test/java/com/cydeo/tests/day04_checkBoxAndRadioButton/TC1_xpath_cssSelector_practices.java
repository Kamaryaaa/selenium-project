package com.cydeo.tests.day04_checkBoxAndRadioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_xpath_cssSelector_practices {
    public static void main(String[] args) {

//TC #1: XPATH and cssSelector Practices
//1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

//2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

//3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
//a. “Home” lin
        //WebElement homeLink=driver.findElement(By.cssSelector("a[class='nav-link']"));
       // WebElement homeLink=driver.findElement(By.cssSelector("a[href='/']"));
        WebElement homeLink=driver.findElement(By.xpath("//a[@href='/']"));
        //WebElement homeLink=driver.findElement(By.xpath("//a[text()='Home']"));


//b. “Forgot password” header
        //WebElement forgotPasswordText=driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        //WebElement forgotPasswordText=driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement forgotPasswordText=driver.findElement(By.cssSelector("div[id='content']>div>h2"));

//c. “E-mail” text
        //WebElement emailText=driver.findElement(By.cssSelector("label[for='email']"));
        //WebElement emailText=driver.findElement(By.cssSelector("div[class='large-6 small-12 columns']>label"));
        WebElement emailText=driver.findElement(By.xpath("//label[@for='email']"));
        //WebElement emailText=driver.findElement(By.xpath("//label[text()='E-mail']"));


//d. E-mail input box
        //WebElement emailInputBox=driver.findElement(By.cssSelector("input[type='text']"));
        //WebElement emailInputBox=driver.findElement(By.cssSelector("input[name='email']"));
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@type='text']"));
        //WebElement emailInputBox=driver.findElement(By.xpath("//*[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$']"));

//e. “Retrieve password” button
        //WebElement retrievePasswordButton=driver.findElement(By.cssSelector("button[id='form_submit']>i"));
        //WebElement retrievePasswordButton=driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        WebElement retrievePasswordButton=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        //WebElement retrievePasswordButton=driver.findElement(By.xpath("//i[text()='Retrieve password']"));

//f. "Powered by Cydeo" text
        //WebElement poweredByCydeoText=driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        //WebElement poweredByCydeoText=driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']>div"));
        WebElement poweredByCydeoText=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        //WebElement poweredByCydeoText=driver.findElement(By.xpath("//div[text()='Powered by ']"));

//4. Verify all web elements are displayed.
        System.out.println("homeLink = " + homeLink.isDisplayed());
        if(homeLink.isDisplayed()){
            System.out.println("Home link verification is PASSED!!!");
        }else {
            System.out.println("Home link verification is FAILED!!!");
        }

        System.out.println("forgotPasswordText = " + forgotPasswordText.isDisplayed());
        if(forgotPasswordText.isDisplayed()){
            System.out.println("Forgot Password Text verification is PASSED!!!");
        }else {
            System.out.println("Forgot Password Text verification is FAILED!!!");
        }

        System.out.println("emailText = " + emailText.isDisplayed());
        if(emailText.isDisplayed()){
            System.out.println("Email Text verification is PASSED!!!");
        }else {
            System.out.println("Email Text verification is FAILED!!!");
        }

        System.out.println("emailInputBox = " + emailInputBox.isDisplayed());
        if(emailInputBox.isDisplayed()){
            System.out.println("Email input box verification is PASSED!!!");
        }else {
            System.out.println("Email input box verification is FAILED!!!");
        }

        System.out.println("retrievePasswordButton = " + retrievePasswordButton.isDisplayed());
        if(retrievePasswordButton.isDisplayed()){
            System.out.println("Retrieve Password Button verification is PASSED!!!");
        }else {
            System.out.println("Retrieve Password Button verification is FAILED!!!");
        }

        System.out.println("poweredByCydeoText = " + poweredByCydeoText.isDisplayed());
        if(poweredByCydeoText.isDisplayed()){
            System.out.println("Powered By Cydeo Text verification is PASSED!!!");
        }else {
            System.out.println("Powered By Cydeo Text verification is FAILED!!!");
        }



driver.quit();


    }

}
