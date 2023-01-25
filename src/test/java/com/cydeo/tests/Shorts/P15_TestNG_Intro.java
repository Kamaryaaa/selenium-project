package com.cydeo.tests.Shorts;

import org.testng.Assert;
import org.testng.annotations.*;

public class P15_TestNG_Intro {
     @Test(priority = 1)
    public void testTwoPlusFive(){
         System.out.println("testTwoPlusFive is running...");
         Assert.assertEquals(2+5,7);
    }
    @Test(priority = 2)
    public void testApple(){
        System.out.println("testApple is running...");

        Assert.assertEquals("apple","apple");
    }
@BeforeMethod
    public void setUpMethod(){
        System.out.println("Before Method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("tearDownMethod is running...");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("tearDownClass is running...");
    }


}
