package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

/**
 * Created by APPLE on 2017/10/16.
 */
public class TestNGSeleniumWindows {
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
        webDriver.get("http://www.91testing.net/login");
        //获得当前窗口句柄 ，打印输出

        String login_handle = webDriver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println(login_handle);
        webDriver.findElement(By.linkText("登录帐号")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("立即注册")).click();
        //获取多个window句柄
        Set<String> handles = webDriver.getWindowHandles();
        //遍历
        for (String handle : handles) {
            //13是登录页面句柄
            if (handle.equals(13) == false) {
                //切换到注册页面
                webDriver.switchTo().window(handle);
                System.out.println("now register window!");
                Thread.sleep(2000);
                webDriver.findElement(By.name("emailOrMobile")).sendKeys("40938499@qq.com");
                webDriver.findElement(By.name("nickname")).sendKeys("atestingred");
                webDriver.findElement(By.name("password")).sendKeys("atestingred");
                webDriver.findElement(By.id("register-btn")).click();
                System.out.print("sucess");

            }
        }
    }
}
