package com.cydeo.tests.day09_review_javaFaker_driveUtil;

import org.testng.annotations.Test;

public class SingltonPractice {



    @Test
    public void singlton_understanding_test1(){
        String str1 = Singleton.getWord();//something
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();//something
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();//something
        System.out.println("str3 = " + str3);
    }
}
