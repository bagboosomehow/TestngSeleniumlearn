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
 * Created by APPLE on 2017/9/22.
 */
public class TestNGSeleniumCss {
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
        webDriver.findElement(By.cssSelector("#login_username")).sendKeys("atestingred");

        webDriver.findElement(By.cssSelector("#login_password")).sendKeys("atestingred");
        //webDriver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.btn-block.js-btn-login")).click();
        webDriver.findElement(By.cssSelector("form#login-form>div>button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("ATesting"));

        Thread.sleep(5000);

    }
}
