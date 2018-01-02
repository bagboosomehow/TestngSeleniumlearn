package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/16.
 */
public class TestNGSeleniumIframe {
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
        webDriver.get("file:///c:/test/frame.html");

        //两者的功能一样
       //webDriver.switchTo().frame("if");
        WebElement xf = webDriver.findElement(By.xpath("//iframe[@id='if']"));
        webDriver.switchTo().frame(xf);

        Thread.sleep(5000);
        webDriver.findElement(By.id("kw")).sendKeys("webdriver");
        webDriver.findElement(By.id("su")).click();

        Thread.sleep(5000);
        webDriver.switchTo().defaultContent();
        //切换frame 记得切换到页面，定位的元素记住是frame里的，还是页面的





    }

}
