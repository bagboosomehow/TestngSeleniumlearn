package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGid {

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
            webDriver.findElement(By.id("jq_user")).clear();
            webDriver.findElement(By.id("jq_user")).sendKeys("13552076596");
            webDriver.findElement(By.id("jq_psw")).clear();
            webDriver.findElement(By.id("jq_psw")).sendKeys("123456");
            webDriver.findElement(By.xpath(".//*[@id='login']/div[4]/button")).click();
            String s=webDriver.getTitle();
            String s1=webDriver.getCurrentUrl();
            System.out.println("网站title是："+s);
            System.out.println("当前url地址是："+s1);
        }
    }

