package com.atesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/9/20.
 */
public class TestNGSelenium_link {
    //找回密码
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();
        webDriver.manage().window().maximize();

    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    @Test
    public void testAtesting() throws InterruptedException , IOException,InterruptedException {
        webDriver.get("http://www.91testing.net/login");
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("找回密码")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.name("form[email]")).sendKeys("40938499@qq.com");
        Thread.sleep(3000);
       // List<WebElement> allButtons =webDriver.findElements(By.tagName("button"));

        //找到button 登录

        webDriver.findElement(By.xpath(".//button[@type='submit'][@data-loading-text='正在发送重设密码邮件...']")).click();

        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("ATesting"));

        Thread.sleep(5000);

    }

}
