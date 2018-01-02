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
public class TestNGSeleniumTagName {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
      //  System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();
      //  webDriver.manage().window().maximize();

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
        //找所有输入框Input
        List<WebElement> allInputs =webDriver.findElements(By.tagName("input"));
        for(WebElement e : allInputs) {

            if (e.getAttribute("id").equals("login_username")) {

                e.sendKeys("atestingred");//用户名
            }
            if (e.getAttribute("id").equals("login_password")) {

                e.sendKeys("atestingred");//输入密码
            }
        }
        webDriver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getTitle().contains("91esting"));

        Thread.sleep(5000);

    }

}
