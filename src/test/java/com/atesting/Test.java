package com.atesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/15.
 */
public class Test {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        // System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();

    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    @org.testng.annotations.Test
    public void testBaiDun() throws InterruptedException , IOException,InterruptedException {
        webDriver.get("http://www.91testing.net/login");
        Thread.sleep(3000);
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");

        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");

        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();



    }
}
