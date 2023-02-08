package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_Registration_Form {
    @Test
    public void registration_form(){
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker=new Faker();
        //3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());
        //4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());
        //5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("kali456");
        //6. Enter email address
        WebElement emailAddress= Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailAddress.sendKeys("1245dfgs@hotmail.com");
        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("345457ghf");
        //8. Enter phone number
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("567-345-3456");
        //9. Select a gender from radio buttons
        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        gender.click();
        //10.Enter date of birth
        WebElement dob = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dob.sendKeys("12/12/2003");
        //11.Select Department/Office
        WebElement departmentOffice = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(departmentOffice);
        select.selectByVisibleText("Department of Engineering");
        //12.Select Job Title
        WebElement jobTitle = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));
        Select select1=new Select(jobTitle);
        select1.selectByVisibleText("Developer");
        //13.Select programming language from checkboxes
        WebElement programmingLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='javascript']"));
        programmingLanguage.click();
        //14.Click to sign up button
        WebElement signupBtn= Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signupBtn.click();
        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.
        String expectedText = "You’ve successfully completed registration!";
       WebElement successMessage = Driver.getDriver().findElement(By.tagName("p"));
        Assert.assertTrue(successMessage.isDisplayed());

        Driver.closeDriver();


    }




}
