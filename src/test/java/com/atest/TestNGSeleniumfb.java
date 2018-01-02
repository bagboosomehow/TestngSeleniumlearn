package com.atest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/9.
 */
public class TestNGSeleniumfb {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        //System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();



    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    @Test
    public void testForword() throws InterruptedException , IOException,InterruptedException {
        System.out.println("browser back and forward.");
        Thread.sleep(3000);
        // 访问91testing的网站
        System.out.printf("now accesss %s \n", "http://www.91testing.net/login");
        webDriver.get("http://www.91testing.net/login");
        //访问www.baidu.com
        System.out.printf("now accesss %s \n", "www.baidu.com");
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        // 切换到91testing
        System.out.printf("now back to %s \n", "http://www.91testing.net/login");
        webDriver.navigate().back();

        Thread.sleep(3000);
        //切换到百度
        System.out.printf("forward to %s \n", "www.baidu.com");
        webDriver.navigate().forward();

        Thread.sleep(3000);
        //刷新 类似于按f5
        webDriver.navigate().refresh();

        Thread.sleep(5000);


    }
}
