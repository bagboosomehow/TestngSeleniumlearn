package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGXpathLabel {

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
        webDriver.get("http://sso.jyall.com/user/register");
        Thread.sleep(3000);
//        String s1=webDriver.findElement(By.xpath("//dt[text()='手机号码：']/following::dd/input[@id=mobile]")).getAttribute("id");
     //   System.out.println(s1);
        //注册手机号
     //   webDriver.findElement(By.xpath("//dt[text()='手机号码：']/following-sibling::dd/input[@id=mobile]")).click();
    //    webDriver.findElement(By.xpath("//dt[text()='手机号码：']/following-sibling::dd/input[@id=mobile]")).getSize();
        webDriver.findElement(By.xpath("//label[text()='手机号码：']/following::/input[@id=mobile]")).sendKeys("13000999000");

       //设置密码
        String s2=webDriver.findElement(By.id("//lable[text()='设置密码：']/following-sibling::dd/input[@id=password]")).getAttribute("name");
        System.out.println(s2);
        //webDriver.findElement(By.id("//dt[text()='设置密码：']/following-sibling::dd/input[@id=password]")).getSize();
       // webDriver.findElement(By.id("//dt[text()='设置密码：']/following-sibling::dd/input[@id=password]")).clear();
        //webDriver.findElement(By.id("//dt[text()='设置密码：']/following-sibling::dd/input[@id=password]")).sendKeys("123456");
    }
}
