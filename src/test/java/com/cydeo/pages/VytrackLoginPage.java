package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage {


    public VytrackLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath ="//input[@id=\"prependedInput\"]" )
    public WebElement username;

    @FindBy(css = "#prependedInput2")
    public WebElement txt_password;

    @FindBy(id="_submit")
    public WebElement login_btn;

public void loginDriver(){

    username.sendKeys(ConfigurationReader.getProperty("driver_username"));
    txt_password.sendKeys(ConfigurationReader.getProperty("driver_password"));
    login_btn.click();
    }

    public void loginAsSalesManager(){

        username.sendKeys(ConfigurationReader.getProperty("salesmanager_username"));
        txt_password.sendKeys(ConfigurationReader.getProperty("salesmanager_password"));
        login_btn.click();
    }
    public void loginAsStoresManager(){

        username.sendKeys(ConfigurationReader.getProperty("storemanager_username"));
        txt_password.sendKeys(ConfigurationReader.getProperty("storemanager_password"));
        login_btn.click();
    }

    public void login(String userName,String password){
    username.sendKeys(userName);
    txt_password.sendKeys(password);
        BrowserUtils.sleep(2);
    login_btn.click();
    }




}
