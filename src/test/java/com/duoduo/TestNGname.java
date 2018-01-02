package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGname {
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
      //  webDriver.navigate().refresh();
      //  Thread.sleep(3000);
        //name定位实现
     //   webDriver.findElement(By.name("loginName")).clear();
        //获取输入框大小
      //  WebElement log_size= webDriver.findElement(By.name("loginName"));
     //  log_size .getSize();
        Thread.sleep(5000);
     //  webDriver.findElement(By.name("loginName")).sendKeys("13552076596");
      // webDriver.findElement(By.name("password")).getSize();
      // webDriver.findElement(By.name("password")).clear();
     //   Thread.sleep(3000);
     //   webDriver.findElement(By.name("password")).sendKeys("123456");
        //xpath contain实现定位;
     //   Thread.sleep(3000);
      //webDriver.findElement(By.xpath("//Button[contains(text(),'立即登录')]")).click();

       //classname定位  没有运行成功
       webDriver.findElement(By.className("jin-user")).clear();
        //获取输入框大小
       webDriver.findElement(By.className("jin-user")).getSize();
        Thread.sleep(3000);
        webDriver.findElement(By.className("jin-user")).sendKeys("13552076596");
        webDriver.findElement(By.className("jin-pass")).getSize();
       webDriver.findElement(By.className("jin-pass")).clear();
        Thread.sleep(3000);
       webDriver.findElement(By.className("jin-pass")).sendKeys("123456");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//button[contains(text(),'立即登录']")).click();

        //xpath input 标签 属性=属性值实现定位
     //   webDriver.findElement(By.xpath(".//input[@id='jq_user']")).clear();
        //获取输入框大小
      //  webDriver.findElement(By.xpath(".//input[@id='jq_user']")).getSize();
       // webDriver.findElement(By.xpath(".//input[@id='jq_user']")).sendKeys("13552076596");
       // webDriver.findElement(By.xpath(".//input[@id='jq_psw']")).clear();
       // webDriver.findElement(By.xpath(".//input[@id='jq_psw']")).getSize();
      //  webDriver.findElement(By.xpath(".//input[@id='jq_psw']")).sendKeys("123456");
        //xpath input实现定位
        //webDriver.findElement(By.xpath("//button[text='立即登录']")).click();  定位失败
      //  webDriver.findElement(By.xpath(".//form[@id='login']/div[4]/button")).click();
       // webDriver.findElement(By.xpath("//form[starts-with(@classname,'btn')]")).click();定位失败
    }
}

