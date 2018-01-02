package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SeleniumMouse {
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
        Actions action = new Actions(webDriver);
        action.click(webDriver.findElement(By.id("jq_user"))).sendKeys("13552076596").perform();
        Thread.sleep(3000);
        action.click(webDriver.findElement(By.id("jq_psw"))).sendKeys("123456").perform();
        Thread.sleep(3000);
        action.doubleClick(webDriver.findElement(By.xpath(".//*[@id='login']/div[4]/button"))).perform();
        Thread.sleep(3000);
    }
}