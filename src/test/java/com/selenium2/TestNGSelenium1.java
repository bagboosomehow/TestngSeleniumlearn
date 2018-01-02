package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by APPLE on 2017/10/22.
 */
public class TestNGSelenium1 {
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
        webDriver.get("http://www.91testing.net/login");



        Thread.sleep(3000);
        webDriver.findElement(By.linkText("立即注册")).click();

        String register_handle = webDriver.getWindowHandle();
        System.out.print(register_handle);
        List<WebElement> allInputs =webDriver.findElements(By.tagName("input"));
        for(WebElement e : allInputs) {

            if (e.getAttribute("name").equals("emailOrMobile")) {

                e.sendKeys("40938499@qq.com");//用户名
            }
            if (e.getAttribute("name").equals("nickname")) {

                e.sendKeys("atestingred");//输入密码
            }
            if (e.getAttribute("name").equals("password")) {

                e.sendKeys("atestingred");//输入密码
            }
        }
        webDriver.findElement(By.id("register-btn")).click();
        System.out.print("sucess");
        Thread.sleep(5000);
            }
}
