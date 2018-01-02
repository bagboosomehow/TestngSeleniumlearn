package com.atesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/9/21.
 */
public class TestNGSeleniumXPath {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void testAtesting() throws InterruptedException, IOException, InterruptedException {
        webDriver.get("http://www.91testing.net/login");
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("atestingred");
        webDriver.findElement(By.xpath("//input[starts-with(@id,'login_pa')]")).sendKeys("atestingred");
        //webDriver.findElement(By.xpath("//input[contains(@id,'login_pa')]")).sendKeys("atestingred");
        //webDriver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("atestingred");
       //password输入框的xpath定位
        //webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();
        //webDriver.findElement(By.xpath("//button[text()='登录']")).click();
        webDriver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        Thread.sleep(5000);
        WebElement abc;
        abc = webDriver.findElement(By.xpath("//img[@class='avatar-xs']"));
                Actions builder = new Actions(webDriver);
        builder.moveToElement(abc).build().perform();
       // builder.click().perform();
        //webDriver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(15000);
        Assert.assertTrue(webDriver.getTitle().contains("ATesting"));

        Thread.sleep(5000);

    }
}