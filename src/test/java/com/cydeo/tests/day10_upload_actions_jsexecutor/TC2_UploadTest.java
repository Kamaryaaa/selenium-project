package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_UploadTest {

@Test
    public void upload_test(){
    //TC #2 Upload Test
    //1. Go to https://practice.cydeo.com/upload
    Driver.getDriver().get(ConfigurationReader.getProperty("cydeo_upload_practice"));

    //2. Find some small file from your computer, and get the path of it.
    String path = "/Users/kamarya/Desktop/HTML_Class/htmlImage.webp";

    //3. Upload the file.//shortcut for search box in inspect: command +shift+c
    WebElement uploadBtn=Driver.getDriver().findElement(By.id("file-upload"));
    BrowserUtils.sleep(2);
    uploadBtn.sendKeys(path);

    WebElement uploadButton=Driver.getDriver().findElement(By.id("file-submit"));
    uploadButton.click();

    //4. Assert:
    //-File uploaded text is displayed on the page
    WebElement text = Driver.getDriver().findElement(By.tagName("h3"));
    Assert.assertTrue(text.isDisplayed());

    Driver.closeDriver();

}


}
