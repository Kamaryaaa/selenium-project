package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationForm {

    WebDriver driver;

    //   // 1. Open Chrome browser
    //    // 2. Go to https://practice.cydeo.com/registration_form
    //    // 3. Verify title is as expected:
    //    // Expected: "Registration Form"
    @BeforeMethod
    public void setupMethod(){
         driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/registration_form");
    }

     @Test(priority = 1)
     public void registration_form_page_test(){

         String expectedTitle="Registration Form";
         String actualTitle=driver.getTitle();

         Assert.assertEquals(expectedTitle,actualTitle,"Title verification FAILED!!");
         //Assert.assertEquals(driver.getTitle(),"Registration Form");
     }

     @Test
     public void registration_form_filling_test(){

         //    // 3. Enter First name: "John"
         WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
         firstName.sendKeys("John");

         //    // 4. Enter Last name: "Smith"
             WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
             lastName.sendKeys("Smith");

         //    // 5. Enter Username: "johnsmith123"
             WebElement userName=driver.findElement(By.name("username"));
             userName.sendKeys("johnsmith123");

         //    // 6. Enter Email address: "john.smith@email.com"
             WebElement email = driver.findElement(By.xpath("//input[@placeholder='email@email.com']"));
             email.sendKeys("john.smith@email.com");

         //    // 7. Enter password: "John1234"
             driver.findElement(By.cssSelector("input[name='password']")).sendKeys("John1234");

         //    // 8. Enter Phone number: "123-456-7890"
             WebElement phoneNumber = driver.findElement(By.name("phone"));
             phoneNumber.sendKeys("123-456-7890");

         //    // 9. Click to "Male" from Gender
             WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
             gender.click();

         //    // 10. Enter Date of birth "01/28/1990"
             WebElement DOB=driver.findElement(By.name("birthday"));
             DOB.sendKeys("01/28/1990");

         //    // 11. Select "Department of Engineering" from Department/Office dropdown
             Select selectDepartment = new Select(driver.findElement(By.name("department")));
             selectDepartment.selectByVisibleText("Department of Engineering");
         //    // 12. Select "SDET" from Job title dropdown
             Select selectJob=new Select(driver.findElement(By.name("job_title")));
             selectJob.selectByVisibleText("SDET");

         //    // 13. Click to "Java" from languages
             WebElement languages = driver.findElement(By.cssSelector("input[value='java']"));
             languages.click();

         //    // 14. Click to "Sign up" button
             WebElement signupButton = driver.findElement(By.id("wooden_spoon"));
             signupButton.click();
         //    // 15. Verify text displayed on page
         //    //     Expected: "Well done!"
         String expectedText="Well done!";
         String actualText=driver.findElement(By.tagName("h4")).getText();
         System.out.println("actualText = " + actualText);
         System.out.println("expectedText = " + expectedText);
         Assert.assertEquals(actualText,expectedText);
}


    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(3000);
       driver.quit();
    }


}
