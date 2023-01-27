package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC2_RadioButtonHandling {
    public static void main(String[] args) {


//TC #2: Radiobutton handling
//1. Open Chrome browser
        //Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//3. Click to “Hockey” radio button
        WebElement HockeyRadioButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        HockeyRadioButton.click();
//4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("HockeyRadioButton.isSelected() expected true= actual " + HockeyRadioButton.isSelected());
//USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS





    }
}
