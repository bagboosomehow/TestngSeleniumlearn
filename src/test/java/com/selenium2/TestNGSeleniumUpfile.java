package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/17.
 */
public class TestNGSeleniumUpfile {
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
        webDriver.get("file:///c:/test/upfile.html");
        Thread.sleep(3000);
        webDriver.findElement(By.name("file")).sendKeys("c:\\test\\upload_file.txt");
        Thread.sleep(5000);

    }
}
