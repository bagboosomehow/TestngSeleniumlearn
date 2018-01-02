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
 * Created by APPLE on 2017/10/15.
 */
public class TestNGSeleniumEles {
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
        webDriver.get("file:///c:/test/checkbox.html");//本地页面


        Thread.sleep(3000);
        List<WebElement> inputs = webDriver.findElements(By.tagName("input"));
        for (WebElement checkbox : inputs) {
            //循环三次,根据checkbox.html里面的input数判断， 也是inputs里的数量
            String type = new String(checkbox.getAttribute("type"));
            if (type.equals("checkbox")) {
                //元素type是checkbox，点选
                checkbox.click();
                Thread.sleep(2000);

            }
        }
    }
}
