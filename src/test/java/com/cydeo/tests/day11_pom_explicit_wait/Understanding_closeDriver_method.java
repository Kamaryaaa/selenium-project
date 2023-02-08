package com.cydeo.tests.day11_pom_explicit_wait;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {

    @Test
    public void test1(){
        Driver.getDriver().get("https://hoogle.com");

    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://hoogle.com");
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://hoogle.com");
    }




}
