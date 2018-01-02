package com.selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/21.
 */
public class TestNGSeleniumM_login {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();


    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    public  void login(WebDriver driver){
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");

        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");
        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(webDriver.getTitle().contains("91Testing - 免费软件测试教程"));

    }
    //退出方法
    public  void logout(WebDriver driver) throws InterruptedException , IOException,InterruptedException {
        Actions action = new Actions(webDriver);
       // webDriver.findElement(By.className("avatar-xs")).click();
        action.clickAndHold(webDriver.findElement(By.className("avatar-xs"))).perform();
//打开搜索设置

            Thread.sleep(6000);

        webDriver.findElement(By.linkText("退出登录")).click();
        Thread.sleep(2000);

    }

    @Test
    public void testAtesting() throws InterruptedException , IOException,InterruptedException {
        webDriver.get("http://www.91testing.net/login");

        Thread.sleep(3000);
        //登录
        login(webDriver);
        Thread.sleep(5000);
        System.out.println("login success!");
        //登录之后的一些操作。
        //....
        //退出
        logout(webDriver);



        Thread.sleep(5000);

    }

}
