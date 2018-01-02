package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/22.
 */
public class TestNGSelenium3 {
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
        webDriver.get("http://www.91testing.net/login?");
        Thread.sleep(3000);
        //JavascriptExecutor jsr = ((JavascriptExecutor)webDriver);

        //jsr.executeAsyncScript("", arg1);
        String mail = "22222222@qq.com";
        String np = "atesting";
        //String text = "atestingred";
        String js2 = "var username=document.getElementById('register_emailOrMobile'); username.value='" + mail + "';";
        String js = "var username=document.getElementById('register_nickname'); username.value='" + np + "';";
        ((JavascriptExecutor) webDriver).executeScript(js);
        String js1 = "var username=document.getElementById('register_password'); username.value='" + np + "';";
        ((JavascriptExecutor) webDriver).executeScript(js1);
        Thread.sleep(3000);
        //WebElement element = webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button"));

        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@id=\"register-btn\"]")));
        //((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

}

