package com.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

public class LearningProperties {
//java is tracking some information about our computer, our project, and username etc. lets print them out
    @Test
    public void java_properties_reading_test(){
        //key=value

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"email\") = " + System.getProperty("email"));

    }

}
