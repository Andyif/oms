package com.oms.pages;

import com.oms.db.DateBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private WebDriver webDriver;

    public LogInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public UserInfoPage logIn(){
        webDriver.findElement(By.name("j_username")).sendKeys(DateBase.getLogin("supervisor"));
        webDriver.findElement(By.name("j_password")).sendKeys(DateBase.getPassword("supervisor"));
        webDriver.findElement(By.name("f")).submit();
        return  new UserInfoPage(webDriver);
    }
}
