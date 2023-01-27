package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {
     @BeforeClass
    public void setupClass(){
        System.out.println("----> Before class is running");
    }
    @AfterClass
    public void teardownClass(){
        System.out.println("----> After class is running");

    }
   @BeforeMethod
    public void setupMethod(){
        System.out.println("--> Before method is running...");
    }
    @AfterMethod
    public void teardownMethod(){
        System.out.println("-->After method is running...");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running");
        Assert.assertEquals("apple","apple");


    }
     @Test
  public void test2(){
      System.out.println("Test 2 is running...");
  }



}
