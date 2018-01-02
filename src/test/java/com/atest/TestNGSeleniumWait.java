package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by APPLE on 2017/10/14.
 */
public class TestNGSeleniumWait {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();



    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    @Test
    public void testAtesting() throws InterruptedException , IOException,InterruptedException {


        webDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        webDriver.get("http://www.91testing.net/login");

        Thread.sleep(3000);
        webDriver.navigate().refresh();
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");

        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");

        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        webDriver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        Assert.assertTrue(webDriver.getTitle().equals("91Testing - 免费软件测试教程|自动化测试教程|性能测试教程|接口测试教程|安全测试教程 - Powered By EduSoho"));

        Thread.sleep(5000);
    }
}
