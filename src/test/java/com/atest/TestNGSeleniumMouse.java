package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/12.
 */
public class TestNGSeleniumMouse {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        //System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
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

        Thread.sleep(5000);
        //鼠标悬停
        Actions action = new Actions(webDriver);

        action.clickAndHold(webDriver.findElement(By.linkText("立即注册"))).perform();
        //左键单击
       // action.click(webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button"))).perform();
        //鼠标双击

       // action.doubleClick(webDriver.findElement(By.linkText("立即注册"))).perform();


        Thread.sleep(5000);

        //Thread.sleep(5000);


        Assert.assertTrue(webDriver.getTitle().contains("91Testing"));

        Thread.sleep(5000);
    }
}
