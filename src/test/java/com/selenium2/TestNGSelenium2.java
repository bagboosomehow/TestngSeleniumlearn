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
 * Created by APPLE on 2017/10/22.
 */
public class TestNGSelenium2 {
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
        webDriver.get("http://www.91testing.net/login");
        webDriver.findElement(By.linkText("立即注册")).click();
        Thread.sleep(3000);
        String text = "atestingred";
        String email="40938499@qq.com";
        Thread.sleep(3000);
        String js = "var email1=document.getElementById('register_emailOrMobile'); email1.value='" + email + "';";
        ((JavascriptExecutor) webDriver).executeScript(js);
        Thread.sleep(3000);
        String js1 = "var username=document.getElementById('register_nickname'); username.value='" + text + "';";
        ((JavascriptExecutor) webDriver).executeScript(js1);
        Thread.sleep(3000);
        String js2 = "var password=document.getElementById('register_password'); password.value='" + text + "';";
        ((JavascriptExecutor) webDriver).executeScript(js2);
        Thread.sleep(3000);

        WebElement element = webDriver.findElement(By.id("register-btn"));// 是某个注册按钮

        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);

    }
}
