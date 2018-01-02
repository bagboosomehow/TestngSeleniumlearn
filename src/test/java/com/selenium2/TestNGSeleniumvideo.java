package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/19.
 */
public class TestNGSeleniumvideo {
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
        webDriver.get("http://videojs.com/");

        WebElement video = webDriver.findElement(By.xpath("//body/section/div/video"));
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
//获得视屏的URL
        Thread.sleep(5000);
        jse.executeScript("return arguments[0].currentSrc;",video);
//播放视屏，播放15 秒钟
        Thread.sleep(5000);
        jse.executeScript("return arguments[0].play()", video);
        Thread.sleep(1500);
//暂停视屏


        jse.executeScript("arguments[0].pause()", video);
        Thread.sleep(3000);
    }
}