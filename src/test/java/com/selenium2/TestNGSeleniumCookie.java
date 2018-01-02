package com.selenium2;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

/**
 * Created by APPLE on 2017/10/17.
 */
public class TestNGSeleniumCookie {
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
//获得cookie
        Set<Cookie> coo = webDriver.manage().getCookies();

//打印cookie
        System.out.println(coo);

    }
}
