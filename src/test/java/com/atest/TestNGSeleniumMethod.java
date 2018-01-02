package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/9.
 */
public class TestNGSeleniumMethod {
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
        //清空账号输入框
        webDriver.findElement(By.id("login_username")).clear();
        Thread.sleep(1000);
        //输入账号   // clear清空输入框， sendkeys输入， click 点击
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");
        //清空密码输入框
        webDriver.findElement(By.id("login_password")).clear();
        Thread.sleep(1000);
        //输入密码
        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");
        Thread.sleep(1000);
        //点击登录按钮
        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("91Testing"));

        Thread.sleep(5000);
    }
}
