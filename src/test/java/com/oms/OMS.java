package com.oms;

import com.oms.pages.AddItemPage;
import com.oms.pages.ItemManagementPage;
import com.oms.pages.LogInPage;
import com.oms.pages.UserInfoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OMS{
    private WebDriver webDriver;
    private LogInPage logInPage;
    private UserInfoPage userInfoPage;
    ItemManagementPage itemManagementPage;
    AddItemPage addItemPage;

    @BeforeClass
    public void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:8080/OMS/");
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
    }

    @Test/*(description = "To verify that user is logged in to the system")*/
    public void omsLogin(){
        logInPage = new LogInPage(webDriver);
        userInfoPage = logInPage.logIn();
        Assert.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/OMS/userInfo.htm");
    }

    @Test(groups = "localizationTesting", dependsOnMethods = "omsLogin")
    public void enLocalization(){
        Assert.assertTrue(webDriver.findElement(By.linkText("en")).isEnabled());
    }

    @Test(groups = "localizationTesting")
    public void uaLocalization(){
        Assert.assertTrue(webDriver.findElement(By.linkText("ua")).isEnabled());
    }

    @Test/*(dependsOnMethods = {"omsLogin"},
          description = "To verify that user is on Item Management page")*/
    public void omsItemManagementPage(){
        itemManagementPage = userInfoPage.openItemManagementPage();
        Assert.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/OMS/itemManagement.htm");
    }

    @Test/*(dependsOnMethods = {"omsItemManagementPage"},
          description = "To verify that Add Item page is opened")*/
    public void omsAddItemPage(){
        addItemPage = itemManagementPage.openAddItemPage();
        Assert.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/OMS/addItem.htm");
    }
}
