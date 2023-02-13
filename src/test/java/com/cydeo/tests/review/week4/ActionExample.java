package com.cydeo.tests.review.week4;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionExample {


    @Test
    public void test_hover(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.loginAsSalesManager();

        Actions actions = new Actions(Driver.getDriver());
        DashboardPage dashboardPage = new DashboardPage();
        List<WebElement> main_menues =dashboardPage.mainMenu;
        for(WebElement eachMain : main_menues){
            actions.moveToElement(eachMain).perform();
            BrowserUtils.sleep(2);

        }
        Driver.closeDriver();






    }
    @Test
    public void test_scroll_to_element(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.loginAsSalesManager();

        Actions actions = new Actions(Driver.getDriver());

        Driver.closeDriver();

    }






}

