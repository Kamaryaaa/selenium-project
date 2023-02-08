package com.cydeo.tests.day12_review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_DoubleClick_Practice {



    @Test
    public void tc1_double_click_test(){
//1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        // using w3Page obj to reach the element and using actions to be able to double-click it
        W3Page w3Page=new W3Page();

        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(w3Page.paragraph).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        //NOTE: FOLLOW POM
        String attributeValue = w3Page.paragraph.getAttribute("style");
        String expectedAttributeValue="red";
        Assert.assertTrue(attributeValue.contains(expectedAttributeValue));



    }
}
