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
public class TestNGSeleniumjavaScript1 {
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
        Thread.sleep(3000);
        String text = "atestingred";
        String js = "var username=document.getElementById('login_username'); username.value='" + text + "';";
        ((JavascriptExecutor) webDriver).executeScript(js);
        String js1 = "var username=document.getElementById('login_password'); username.value='" + text + "';";
        ((JavascriptExecutor) webDriver).executeScript(js1);
    //    String js2 = "var username=document.getElementByXpath('login_password'); username.value='" + text + "';";
        Thread.sleep(3000);
        WebElement element = webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button"));// 是某个登录按钮

        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);

    }
}
