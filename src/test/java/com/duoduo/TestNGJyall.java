package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGJyall {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        //设置信息
        webDriver = new FirefoxDriver();
        //初始化窗口并最大化
       // webDriver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //用完了关掉
        webDriver.quit();
    }
    @Test
    public void testAtesting() throws InterruptedException, IOException, InterruptedException {
        //打开地址
            webDriver.get("http://sso.jyall.com/user/login");
        Thread.sleep(3000);
        webDriver.findElement(By.id("username")).clear();
        //webDriver.findElement(By.name("username")).sendKeys("qiandong");
        // name元素定位 webDriver.findElement(By.name("username")).sendKeys("qiandong");

        webDriver.findElement(By.name("password")).sendKeys("123");
       webDriver.findElement(By.xpath(".//input[@value='登录']")).click();webDriver.findElement(By.xpath("//dt[text()='用户名 Uesr Name']/following-sibling::dd/input[@id='username']")).sendKeys("qiandong");
        // webDriver.findElement(By.xpath(".//form[@id='sbm']/div[1]/input[@id='btnLogin']")).click();


    }
}

