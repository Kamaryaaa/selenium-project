package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableDemoTest extends TestBase {

    @Test
    public void read_from_table_test(){
        //    // 2. Go to https://practice.cydeo.com/tables
        driver.get(ConfigurationReader.getProperty("practice_cydeo_url"));

        //    // 3. Print table1 data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println("table1 in text = " + table1.getText());
        //    // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));
        //    // 5. print all column names in single line
        WebElement allColumn = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("allColumn.getText() = " + allColumn.getText());
        //    // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> colNames = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("colNames.size() = " + colNames.size());
        for (WebElement eachCol : colNames) {
            System.out.println("eachCol.getText() = " + eachCol.getText());
            
        }
    }


}
