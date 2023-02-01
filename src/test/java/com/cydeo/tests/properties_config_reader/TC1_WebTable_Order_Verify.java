package com.cydeo.tests.properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC1_WebTable_Order_Verify {
    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        //Go to: https://practice.cydeo.com/web-tables
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/web-tables");
        BrowserUtils.sleep(1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




    }
    @Test
    public void webTable_order_verify_name_test(){
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement Bob = driver.findElement(By.xpath(
                "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]"));
                            //  "//table[@class='SampleTable']//td[.='Bob Martin']"
        String expectedName = "Bob Martin";
        String actualName = Bob.getText();
        Assert.assertEquals(expectedName,actualName,"Text verification is FAILED!");

        //3. Verify Bob Martin’s order date is as expected
        //: 12/31/2021
        WebElement orderDate = driver.findElement(By.xpath(
                "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[7]/td[5]"));
                          //  "//table[@class='SampleTable']//td[.='12/31/2021']":can't make sure it is Bobs order
                          //  "//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"
                         //  "//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"

        String expectedDate = "12/31/2021";
        String actualDate = orderDate.getText();
        Assert.assertEquals(actualDate,expectedDate,"Order date verification FAILED!!!");

    }

    @Test
    public void test2_use_order_verify_method(){
        String alexandra_gray = WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("alexandra_gray = " + alexandra_gray);
        String ned_stark = WebOrderUtils.returnOrderDate(driver, "Ned Stark");
        System.out.println("ned_stark = " + ned_stark);
    }

     @Test
     public void test3(){
        WebOrderUtils.orderVerify(driver,"Bart Fisher","01/16/2021");
     }


@AfterMethod
    public void tearDownMethod(){
    BrowserUtils.sleep(1);
    driver.quit();
}

}
