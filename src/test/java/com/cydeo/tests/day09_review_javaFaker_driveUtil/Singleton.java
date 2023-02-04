package com.cydeo.tests.day09_review_javaFaker_driveUtil;

public class Singleton {
    //#1 Create private constructor

    private Singleton(){};



    //#2 Private static String
    private static String word;// by default word is null


    //#3 Utility method to return the "private String" we just created
    public static String getWord(){
        if(word ==null){
            System.out.println("First time call. Word obj is null");
            System.out.println("Assining value to ir now");
            word="something";
        }else {
            System.out.println("Word alrady has a value");
        }
        return word;
    }
}
