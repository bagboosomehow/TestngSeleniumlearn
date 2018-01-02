package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestNGCSS {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        //设置信息
        webDriver = new FirefoxDriver();
        //初始化窗口并最大化
        // webDriver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //用完了关掉
        webDriver.quit();
    }
@Test
public void testJyall() throws InterruptedException, IOException, InterruptedException {
    //打开地址
    webDriver.get("http://sso.jyall.com/user/login");
    Thread.sleep(3000);
    webDriver.findElement(By.cssSelector("#jq_user")).clear();
    webDriver.findElement(By.cssSelector("#jq_user")).getSize();
    webDriver.findElement(By.cssSelector("#jq_user")).sendKeys("13552076596");
    webDriver.findElement(By.cssSelector("form#login>div>div>input[id='jq_psw']")).clear();
    Thread.sleep(3000);
    webDriver.findElement(By.cssSelector("form#login>div>div>input[id='jq_psw']")).getSize();
    webDriver.findElement(By.cssSelector("form#login>div>div>input#jq_psw")).sendKeys("123456");

    //定位不到用class  webDriver.findElement(By.cssSelector(".jin-pass ischecked")).sendKeys("123456");
    Thread.sleep(3000);

   // webDriver.findElement(By.cssSelector("form#login>div>button")).click();
    webDriver.findElement(By.cssSelector(".btn")).submit();



}
}
