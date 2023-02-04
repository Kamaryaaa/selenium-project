package com.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_test() throws IOException {
        //1-create obj of properties
        Properties properties = new Properties();

        //2-we need to open the file in the java memory using fileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //3-load the properties file in the properties obj
        properties.load(file);
        //4-use the "properties" obj to read value from the file
        System.out.println("properties.get(\"browser\") = " + properties.get("browser"));
        System.out.println("properties.get(\"env\") = " + properties.get("env"));
        System.out.println("properties.get(\"username\") = " + properties.get("username"));
        System.out.println("properties.get(\"password\") = " + properties.get("password"));
    }
}
