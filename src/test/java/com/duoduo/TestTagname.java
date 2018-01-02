package com.duoduo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.util.component.LifeCycle;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestTagname {
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
    public void testAtesting() throws InterruptedException, IOException, InterruptedException {
        //打开地址
        webDriver.get("http://sso.jyall.com/user/login");
        Thread.sleep(3000);
        List<WebElement> allInputs=webDriver.findElements(By.tagName("input"));
        WebElement login= webDriver.findElement(By.name("loginName"));
        String s=login.getAttribute("id");
        System.out.println(s);
        for(WebElement e : allInputs){

            if(e.getAttribute("id").equals("jq_user")){

                e.sendKeys("13552076596");

            }else

                System.err.println("定位出错");

            Thread.sleep(3000);

            if(e.getAttribute("id" ).equals("jq_psw")){

                e.sendKeys("123456");

            }else {

                System.err.println("定位出错");
            }
        }
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(".//form[@id='login']/div[4]/button")).click();

    }
}
