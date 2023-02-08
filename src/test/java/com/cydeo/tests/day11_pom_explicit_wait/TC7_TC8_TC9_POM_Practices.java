package com.cydeo.tests.day11_pom_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC7_TC8_TC9_POM_Practices {
    LibraryLoginPage loginPage;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com/login.html");
        loginPage=new LibraryLoginPage();
    }

    @Test
    public void tc7_field_required_error_message_test(){

        //TC #7: Required field error message test


        //3- Do not enter any information
        LibraryLoginPage loginPage= new LibraryLoginPage();
        //4- Click to “Sign in” button
        loginPage.signInButton.click();
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
        Assert.assertTrue(loginPage.fieldRequiredErrorMessage.isDisplayed());

   }


   @Test
    public void tc8_invalid_email_format_error_message_test(){

        //TC #8: Invalid email format error message test

       //3- Enter invalid email format
       loginPage.emailInput.sendKeys("username");
       loginPage.signInButton.click();

       //4- Verify expected error is displayed:
       //Expected: Please enter a valid email address.
       //
       //NOTE: FOLLOW POM DESIGN PATTERN
       Assert.assertTrue( loginPage.enterValidEmailErrorMessage.isDisplayed());

   }

   @Test
   public void tc9_library_negative_login(){
        //3- Enter incorrect username or incorrect password
       loginPage.emailInput.sendKeys("kar@gmail.com");
       loginPage.passwordInput.sendKeys("user");
       loginPage.signInButton.click();
       //4- Verify title expected error is displayed:
       //Expected: Sorry, Wrong Email or Password
       Assert.assertTrue(loginPage.wrongEmailOrPassword.isDisplayed());
   }



   @AfterMethod
    public void teardownMethod(){
        Driver.closeDriver();
   }
}
