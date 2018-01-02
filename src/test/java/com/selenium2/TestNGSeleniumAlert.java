package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/16.
 */
public class TestNGSeleniumAlert {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

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
        webDriver.get("http://www.baidu.com");
//鼠标悬停相“设置”链接
        Actions action = new Actions(webDriver);
        Thread.sleep(5000);
     action.click(webDriver.findElement(By.linkText("设置"))).perform();
//打开搜索设置
        Thread.sleep(5000);
     webDriver.findElement(By.className("setpref")).click();
       // action.clickAndHold(webDriver.findElement(By.linkText("设置"))).perform();
//打开搜索设置
        Thread.sleep(5000);
//保存设置
    //action.click(webDriver.findElement(By.className("prefpanelgo"))).perform();
     // webDriver.findElement(By.linkText("保存设置")).sendKeys(Keys.ENTER);
      webDriver.findElement(By.className("prefpanelgo")).click();
        Thread.sleep(2000);
//接收弹窗
        webDriver.switchTo().alert().accept();

    }
}
