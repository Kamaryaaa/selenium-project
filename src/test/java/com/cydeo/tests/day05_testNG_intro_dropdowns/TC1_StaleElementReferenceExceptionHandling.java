package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC1_StaleElementReferenceExceptionHandling {
    public static void main(String[] args) {


    //Open Chrome browser
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

    //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

    //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() = expected true, actual " + deleteButton.isDisplayed());
        //5. Click to “Delete” button.
        deleteButton.click();
    //6. Verify “Delete” button is NOT displayed after clicking.
        //use try catch
        try{
            System.out.println("deleteButton.isDisplayed() expected false= actual " + deleteButton.isDisplayed());

        }catch (StaleElementReferenceException e){
            System.out.println("--> StaleElementReferenceException happened due to element being deleted from the page.");
            System.out.println("which concludes our test are -PASSING!-");
            System.out.println("deleteButton.isDisplayed() = false " );
        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


    }
}
