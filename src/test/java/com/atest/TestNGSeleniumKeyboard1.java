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
public class TestNGSeleniumKeyboard1 {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        //System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
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
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");
        webDriver.findElement(By.id("login_username")).sendKeys(Keys.CONTROL,"a");
        webDriver.findElement(By.id("login_username")).sendKeys(Keys.CONTROL,"c");
        Thread.sleep(3000);
        webDriver.findElement(By.id("login_username")).sendKeys(Keys.TAB);
        webDriver.findElement(By.id("login_password")).sendKeys(Keys.CONTROL, "v");
        webDriver.findElement(By.id("login_password")).sendKeys(Keys.TAB);
        webDriver.findElement(By.id("login_password")).sendKeys(Keys.TAB);
        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).sendKeys(Keys.ENTER);


       // webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("ATesting"));
    // 注册页面键盘操作复制，粘贴  用户名，密码，  点击登录按钮；

        Thread.sleep(5000);
    }
}
