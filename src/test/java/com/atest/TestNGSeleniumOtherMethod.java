package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/9.
 */
public class TestNGSeleniumOtherMethod {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
      //  System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
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
        webDriver.navigate().refresh();
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");

        webDriver.findElement(By.id("login_password")).sendKeys("atestingred");
        //submit
        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).submit();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("91Testing"));

        Thread.sleep(5000);
    }
    @Test
    public void testAtesting1() throws InterruptedException , IOException,InterruptedException {

        Thread.sleep(3000);
        webDriver.get("http://www.91testing.net/login");

        Thread.sleep(3000);
        webDriver.navigate().refresh();
        webDriver.findElement(By.id("login_username")).sendKeys("atestingred");

        webDriver.findElement(By.id("login_password")).sendKeys("a1111");
        //submit
        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).submit();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("91Testing"));

        Thread.sleep(5000);
    }
}
