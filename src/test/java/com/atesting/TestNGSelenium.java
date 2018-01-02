package com.atesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;

/**
 * Created by APPLE on 2017/9/16.
 */
public class TestNGSelenium {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
       // System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();

    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    @Test
    public void testBaiDun() throws InterruptedException , IOException,InterruptedException {
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //webDriver.findElement(By.id("kw")).sendKeys("hello baidu");
        //webDriver.findElement(By.id("kw")).clear();
        //webDriver.findElement(By.id("kw")).sendKeys("hello world");
        webDriver.findElement(By.className("s_ipt")).sendKeys("hello world");



        webDriver.findElement(By.id("su")).click();

        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("hello world"));

        Thread.sleep(5000);

    }
}
