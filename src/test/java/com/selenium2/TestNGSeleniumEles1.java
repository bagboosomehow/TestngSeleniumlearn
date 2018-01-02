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
public class TestNGSeleniumEles1 {
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
        webDriver.get("file:///c:/test/checkbox.html");


        //通过css 找到一组元素 3个 元素
//List<WebElement> checkboxes =
       // webDriver.findElements(By.cssSelector("input[type=checkbox]"));
         //通过xpath 找到一组元素
        List<WebElement>checkboxes =
                webDriver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        Thread.sleep(3000);
//刷新屏蔽
      // webDriver.navigate().refresh();
//把页面上最后1 个checkbox 的勾给去掉
        List<WebElement>allCheckboxes =
                webDriver.findElements(By.cssSelector("input[type=checkbox]"));
        System.out.println(allCheckboxes.size());
        allCheckboxes.get(allCheckboxes.size() - 1).click();
        Thread.sleep(5000);


    }
        }


