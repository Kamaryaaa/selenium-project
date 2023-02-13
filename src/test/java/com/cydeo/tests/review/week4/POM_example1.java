package com.cydeo.tests.review.week4;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class POM_example1 {

    @Test
    public void test1(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.loginDriver();
        Driver.closeDriver();
    }
    @Test
    public void test2(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.loginAsSalesManager();
        Driver.closeDriver();
    }

    @Test
    public void test3(){

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.loginAsStoresManager();
        Driver.closeDriver();
    }

}
