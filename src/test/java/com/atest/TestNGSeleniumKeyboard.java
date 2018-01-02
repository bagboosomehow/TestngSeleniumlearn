package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/14.
 */
public class TestNGSeleniumKeyboard {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
       // System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();


    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    @Test
    public void testAtesting() throws InterruptedException , IOException,InterruptedException {

        Thread.sleep(3000);
        webDriver.get("http://www.91testing.net/login");

        Thread.sleep(3000);
        webDriver.navigate().refresh();
        //键盘操作登录功能
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");
        webDriver.findElement(By.id("login_username")).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");
        webDriver.findElement(By.id("login_password")).sendKeys(Keys.TAB);
        webDriver.findElement(By.id("login_password")).sendKeys(Keys.TAB);
        //enter执行 click
        webDriver.findElement(By.id("login_password")).sendKeys(Keys.ENTER);
        //登录系统

       // webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("91Testing"));

        Thread.sleep(5000);
        //立即注册界面    的注册功能的键盘操作

    }
}
