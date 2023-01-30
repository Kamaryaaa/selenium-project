package com.cydeo.tests.day06_alerts_iFrame_windows;

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

public class DropDowns_TC6_TC7_TC8 {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void dropdowns_task6(){
        //3. Select “December 1st, 1933” and verify it is selected.
        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number
        WebElement year = driver.findElement(By.id("year"));
        WebElement month= driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1933");

        Select selectMonth = new Select(month);
        selectMonth.selectByValue("11");

        Select selectDay = new Select(day);
        selectDay.selectByIndex(0);

        //verifying
        String expectedYear="1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth=selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);




    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void dropdowns_task7() throws InterruptedException {
        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        Thread.sleep(2000);

        selectState.selectByVisibleText("Illinois");
        //4. Select Virginia
        Thread.sleep(2000);

        selectState.selectByValue("VA");
        //5. Select California
        Thread.sleep(2000);

        selectState.selectByIndex(5);
        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
        String expectedSelection = "California";
        String actualSelection = selectState.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSelection,actualSelection);

    }

    @Test
    public void dropdowns_task8() throws InterruptedException {
        //3. Click to non-select dropdown
        WebElement htmlDropdown = driver.findElement(By.id("dropdownMenuLink"));
        htmlDropdown.click();
        Thread.sleep(2000);
        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        facebookLink.click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }




}
