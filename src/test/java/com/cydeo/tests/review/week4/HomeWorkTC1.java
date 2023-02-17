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

public class HomeWorkTC1 {



    @Test
    public void vytrack_practice_test(){
        //TC 1:
        //
        //1- Go to "https://qa3.vytrack.com/"
        //2- Login as store manager
        //3- Click Vehicles under Fleet (You will create a custom method I will give main menu and sub menu as a String)
        //Note: put your method in your Dashboard page

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

        VytrackLoginPage vytrackLoginPage= new VytrackLoginPage();

        vytrackLoginPage.loginAsStoresManager();

        DashboardPage dashboardPage=new DashboardPage();

        Actions actions = new Actions(Driver.getDriver());

        List<WebElement> mainMenu= dashboardPage.mainMenu;
        for (WebElement eachMenu : mainMenu) {
            BrowserUtils.getTexts(mainMenu);

        }





    }







}
