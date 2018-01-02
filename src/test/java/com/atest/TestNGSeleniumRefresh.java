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
public class TestNGSeleniumRefresh {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
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

        Thread.sleep(3000);
        //和手动操作f5是一样的
        webDriver.navigate().refresh();


        Thread.sleep(5000);
    }
}
