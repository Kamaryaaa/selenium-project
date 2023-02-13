package com.cydeo.tests.review.week4;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {


    @Test
    public void test_scroll_down(){

        Driver.getDriver().get("https://demoqa.com/text-box");
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,100)");
            BrowserUtils.sleep(1);
        }
        Driver.closeDriver();
    }
    @Test
    public void test_scroll_up(){
        Driver.getDriver().get("https://demoqa.com/text-box");
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-100)");
            BrowserUtils.sleep(1);
        }
        Driver.closeDriver();
    }



}
