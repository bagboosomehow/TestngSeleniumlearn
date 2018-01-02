package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/15.
 */
public class TestNGSeleniumlearn1 {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
      //  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
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
        webDriver.findElement(By.linkText("立即注册")).click();
        webDriver.findElement(By.id("register_emailOrMobile")).sendKeys("40938499@qq.com");
        webDriver.findElement(By.id("register_emailOrMobile")).sendKeys(Keys.TAB);
        webDriver.findElement(By.id("register_nickname")).sendKeys("atesting11");
        webDriver.findElement(By.id("register_nickname")).sendKeys(Keys.TAB);

        webDriver.findElement(By.id("register_password")).sendKeys("atesting11");
        webDriver.findElement(By.id("register_password")).sendKeys(Keys.TAB);
        webDriver.findElement(By.id("register-btn")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        webDriver.navigate().refresh();
        //键盘操作登录功能


        Thread.sleep(5000);
        //立即注册界面    的注册功能的键盘操作

    }
}
