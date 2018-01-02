package com.atesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/9/21.
 */
public class TestNGSelenium_partial_link_text {
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
        webDriver.findElement(By.partialLinkText("立即")).click();

        Thread.sleep(3000);
        webDriver.findElement(By.name("emailOrMobile")).sendKeys("40938499@qq.com");
        webDriver.findElement(By.name("nickname")).sendKeys("atestingred");
        webDriver.findElement(By.name("password")).sendKeys("atestingred");
        webDriver.findElement(By.id("register-btn")).click();
        System.out.print("sucess");
        Thread.sleep(3000);

        Thread.sleep(5000);
        //Assert.assertTrue(webDriver.getTitle().contains("ATesting"));

        Thread.sleep(5000);

    }
}
