package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SeleniumKey {
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
        System.out.println(webDriver.findElement(By.xpath(".//*[@id='login']/div[4]/button")).getText());
        System.out.println(webDriver.findElement(By.xpath(".//*[@id='login']/div[4]/button")).getSize());
        webDriver.findElement(By.id("jq_user")).clear();
        webDriver.findElement(By.id("jq_user")).sendKeys("13552076596");

       // webDriver.findElement(By.id("jq_user")).sendKeys(Keys.CONTROL,"a");
      //  webDriver.findElement(By.id("jq_user")).sendKeys(Keys.CONTROL,"c");
        Thread.sleep(3000);
        webDriver.findElement(By.id("jq_psw")).clear();
        webDriver.findElement(By.id("jq_psw")).sendKeys("123456");
        webDriver.findElement(By.id("jq_psw")).sendKeys(Keys.TAB);
       // webDriver.findElement(By.id("jq_user")).sendKeys(Keys.CONTROL,"v");
        //webDriver.findElement(By.id("jq_psw")).isDisplayed();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(".//*[@id='login']/div[4]/button")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        System.out.println(webDriver.getCurrentUrl());
        Assert.assertTrue(webDriver.getCurrentUrl().equals("http://www.jyall.com/"));
        System.out.println(webDriver.getTitle());
        Assert.assertTrue(webDriver.getTitle().equals("家园网-家庭大商品消费O2O服务平台"));

        //if(webDriver.getTitle().equals("家园网-家庭大商品消费O2O服务平台")){
        //    System.out.println("登录成功");
        //}else
       //     System.out.println("登录失败");
    }
}
