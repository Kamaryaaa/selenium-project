package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {



    // create a private constructor to remove access to this obj

    private Driver(){};

    /*
    we make the WebDriver private, because we want to close access from outside the class.
    we are making it static, because we will use it in a static method.
     */

    private static WebDriver driver;// default driver=null
    /*
     create a re-usable utility method which will return the same driver instance once we call it
     -if an instance doesn't exist, it will create first, and then it will always return same instance;
     */

    public static WebDriver getDriver(){
        /*
        we will read our browser from configuration.properties file.
        this way, we can control which is opened from outside our code
         */
        if(driver==null){
          String browserType = ConfigurationReader.getProperty("browser");
          /*
          depending on browser type returned from the configuration.properties
          switch statement will determine the case, and open matching browser
           */
          switch (browserType){
              case "chrome":
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
                  driver.manage().window().maximize();
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                  break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver = new FirefoxDriver();
                  driver.manage().window().maximize();
                  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                  break;
          }
        }
        return driver;
    }


// create a new Driver.closeDriver();
// it will use .quite method to quit browsers, and then set the driver value back to null
    public static void closeDriver(){
        if(driver != null){
          // this line will terminate the currently existing driver completely,
            driver.quit();
            // we assign value back to null so that my"singlton" can create a newer one if needed
            driver=null;
        }
    }


}
