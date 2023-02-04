package com.cydeo.utilities;
/*
in this class we will be creating the re-usable logic to read from configuration.properties file
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



        //1-create property obj(create obj)
       private static Properties properties = new Properties();

       static{

           try {
               //2- open file  using FileInputStream and provide the path of the .properties file (open file)
               FileInputStream file = new FileInputStream("configuration.properties");
               //3- load the "properties" obj with file(load properties)
               properties.load(file);

               //close the file in the memory
               file.close();
           } catch (IOException e) {
               System.out.println("File not found with given path!!!");
               e.printStackTrace();
           }
       }


    // create a utility method to use the obj to read
        //4-get the value from the properties file by passing the key(read properties)

    public static String getProperty(String keyword){
           return properties.getProperty(keyword);
    }






}
