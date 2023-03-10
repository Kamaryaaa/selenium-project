package com.cydeo.tests.day04_checkBoxAndRadioButton;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC3_Checkboxes {
    public static void main(String[] args) {


        //TC#3: Checkboxes
        //1. Go to https://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get("https://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkBox1=driver.findElement(By.cssSelector("input[name='checkbox1']"));
        WebElement checkBox2= driver.findElement(By.xpath("//input[@name='checkbox2']"));
        System.out.println("checkBox1.isSelected() = expected false: actual " + checkBox1.isSelected());//false
        System.out.println("checkBox2.isSelected() = expected true: actual " + checkBox2.isSelected());//true
        //3. Confirm checkbox #2 is SELECTED by default.
        //4. Click checkbox #1 to select it.
        checkBox1.click();
        //5. Click checkbox #2 to deselect it.
        checkBox2.click();
        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkBox1.isSelected() = expected true: actual " + checkBox1.isSelected());//true
        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkBox2.isSelected() = expected false: actual " + checkBox2.isSelected());//false




    }
}
