package com.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoPage {

    private WebDriver webDriver;

    public UserInfoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ItemManagementPage openItemManagementPage(){
        webDriver.findElement(By.linkText("Item Management")).click();
        return new ItemManagementPage(webDriver);
    }

}
