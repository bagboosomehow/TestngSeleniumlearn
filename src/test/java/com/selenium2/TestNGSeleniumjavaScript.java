package com.selenium2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/19.
 */
public class TestNGSeleniumjavaScript {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void testAtesting() throws InterruptedException, IOException, InterruptedException {

        Thread.sleep(3000);
        webDriver.get("http://www.91testing.net/");
        Thread.sleep(2000);
//将页面滚动条拖到底部
        ((JavascriptExecutor)webDriver).executeScript("window.scrollTo(0,400);");
        Thread.sleep(3000);
        System.out.println("end");

    }
}