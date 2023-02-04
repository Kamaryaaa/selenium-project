package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRM_Sending_Messages extends TestBase {


@Test
    public void sending_messages_test(){
    //       1. Users are already login and on the homepage
    driver.get(ConfigurationReader.getProperty("CRM_url"));
    CRM_Utilities.login_crm(driver);
    //       2. Users click the MESSAGE tab
    WebElement messageTab= driver.findElement(By.id("feed-add-post-form-tab-message"));
    messageTab.click();

    //       3. Users write test message
    //WebElement innerHTML = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
    BrowserUtils.sleep(2);
    WebElement msgFrame=driver.findElement(By.tagName("body"));
    msgFrame.sendKeys("Finally successes");

    //       4. Users click the SEND button
    driver.switchTo().defaultContent();
    WebElement sendBtn= driver.findElement(By.id("blog-submit-button-save"));
    sendBtn.click();
    BrowserUtils.sleep(2);
    //       5. Verify the message is displayed on the feed
    WebElement message=driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
    String expectedDisplay="Finally successes";
    Assert.assertTrue(message.getText().equals(expectedDisplay));
    System.out.println("message.getText() = " + message.getText());


}


}
