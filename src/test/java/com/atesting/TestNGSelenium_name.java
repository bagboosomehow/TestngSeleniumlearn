package com.atesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by APPLE on 2017/9/20.
 */
public class TestNGSelenium_name {
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
        webDriver.findElement(By.name("_username")).sendKeys("atestingred");

        webDriver.findElement(By.name("_password")).sendKeys("atestingred");
        List<WebElement> allButtons =webDriver.findElements(By.tagName("button"));

        //找到button 登录

        for(WebElement e : allButtons) {

            if (e.getAttribute("type").equals("button")) {

                e.click();  //判断button的标签的type属性的值是不是button,如是，点击

            }
        }
           // webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("ATesting"));

        Thread.sleep(5000);

    }
    @Test
    public void testlogin() throws InterruptedException , IOException,InterruptedException {
        webDriver.get("http://www.91testing.net/login");
        Thread.sleep(3000);
        webDriver.findElement(By.name("_username")).sendKeys("atestingred");

        webDriver.findElement(By.name("_password")).sendKeys("");
        List<WebElement> allButtons =webDriver.findElements(By.tagName("button"));

        //找到button 登录

        for(WebElement e : allButtons) {

            if (e.getAttribute("type").equals("button")) {

                e.click();  //判断button的标签的type属性的值是不是button,如是，点击

            }
        }
        // webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("ATesting"));

        Thread.sleep(5000);

    }
}
