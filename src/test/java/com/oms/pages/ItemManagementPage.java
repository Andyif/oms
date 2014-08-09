package com.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemManagementPage {
    private WebDriver webDriver;

    public ItemManagementPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public UserInfoPage openUserInfo(){
        webDriver.findElement(By.linkText("Item Management")).click();
        return new UserInfoPage(webDriver);
    }

    public AddItemPage openAddItemPage(){
        webDriver.findElement(By.partialLinkText("Add Product")).click();
        return new AddItemPage(webDriver);
    }
}
