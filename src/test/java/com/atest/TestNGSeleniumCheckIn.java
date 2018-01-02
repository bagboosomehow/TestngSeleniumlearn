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
 * Created by APPLE on 2017/10/14.
 */
public class TestNGSeleniumCheckIn {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
       //String s= System.setProperty("webdriver.firefox.marionette","C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
     // System.setProperty("webdriver.gecko.driver","C:\\Python27\\geckodriver.exe");
     //   System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
       //options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine

      //  FirefoxDriver driver = new FirefoxDriver();

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
        //webDriver.navigate().refresh();
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");

        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");


        Thread.sleep(1000);
        Assert.assertTrue(webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).getText().equals("登录"));

        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
        //System.out.println(webDriver.findElement(By.id("login_password")).getText());
        Assert.assertTrue(webDriver.getTitle().contains("91Testing"));

        Thread.sleep(5000);
        // http://www.91testing.net/login
        //获取title,url, gettext() 文本信息
        //String 变量,t_, u_,gett 比较是否相等;

       Assert.assertTrue(webDriver.getTitle().equals("91Testing - 免费软件测试教程|自动化测试教程|性能测试教程|接口测试教程|安全测试教程 - Powered By EduSoho"));
        Assert.assertTrue(webDriver.getCurrentUrl().equals("http://www.91testing.net/"));

    }


}
