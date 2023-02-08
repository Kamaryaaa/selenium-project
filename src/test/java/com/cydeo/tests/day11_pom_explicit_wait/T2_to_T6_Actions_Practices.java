package com.cydeo.tests.day11_pom_explicit_wait;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_to_T6_Actions_Practices {

    @BeforeMethod
    public void setupMethod(){
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }


    @Test
    public void test2_default_value_verification(){

        //2. Verify big circle default text is as below.
        WebElement bigCircleDefaultText= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //3. Assert:
        //-Text in big circle changed to: “Drag the small circle here.”
        System.out.println("bigCircleDefaultText.getText() = " + bigCircleDefaultText.getText());
        Assert.assertEquals(bigCircleDefaultText.getText(),"Drag the small circle here.");
    }
    @Test
    public void test3_drag_and_drop(){
        //TC3 #: Drag and drop into the big circle
        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle= Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));


        //2. Drag and drop the small circle to bigger circle.
        //creating actions obj
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(1);
       // actions.dragAndDrop(smallCircle,bigCircle).perform();
        actions.clickAndHold(smallCircle).pause(1000).release().perform();


        //3. Assert:
        //-Text in big circle changed to: “You did great!”
    }

    @Test
    public void test4_click_and_hold(){
        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle= Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));


        //2. Drag and drop the small circle to bigger circle.
        //creating actions obj
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(1);
        // actions.dragAndDrop(smallCircle,bigCircle).perform();
        actions.clickAndHold(smallCircle).pause(1000).
                moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO"))).pause(1000).perform();
        String expectedText = "Drop here.";
        WebElement bigCircleDefaultText= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));


        Assert.assertEquals(expectedText,   bigCircleDefaultText.getText());


    }

    @Test
    public void test5_drop_outside_big_circle(){
        //2. Drag and drop the small circle to bigger circle.
        //3. Assert:
        //-Text in big circle changed to: “Try again!”


        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle= Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));



        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(1);
        actions.clickAndHold(smallCircle).pause(1000).
                moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO"))).pause(1000).release().perform();
        String expectedText = "Try again!";
        WebElement bigCircleDefaultText= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));


        Assert.assertEquals(expectedText,   bigCircleDefaultText.getText());


    }

    @Test
    public void test6_drag_and_hover(){
        //Drag the small circle on top of the big circle, hold it, and verify.
        //3. Assert:
        //-Text in big circle changed to: “Now drop...”


        WebElement bigCircle= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle= Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(1);

        actions.clickAndHold(smallCircle).pause(1000).
                moveToElement(bigCircle).pause(1000).perform();
        String expectedText = "Now drop...";

        WebElement bigCircleDefaultText= Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Assert.assertEquals(expectedText,bigCircleDefaultText.getText());


    }


    @AfterMethod
    public void teardownMethod(){
        BrowserUtils.sleep(1);
        Driver.closeDriver();
    }


}
