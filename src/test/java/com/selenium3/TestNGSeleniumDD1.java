package com.selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/21.
 */
public class TestNGSeleniumDD1 {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        webDriver=new FirefoxDriver();


    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
    public  void login(WebDriver webDriver,String username,String password)throws InterruptedException , IOException,InterruptedException {
        webDriver.findElement(By.id("login_username")).sendKeys(username);

        webDriver.findElement(By.id("login_password")).sendKeys(password);
        webDriver.findElement(By.xpath(".//form[@id='login-form']/div[4]/button")).click();

        Thread.sleep(5000);

        Assert.assertTrue(webDriver.getTitle().contains("91Testing - 免费软件测试教程"));

    }
        //退出方法
        public  void logout(WebDriver driver) throws InterruptedException , IOException,InterruptedException {
            Actions action = new Actions(webDriver);
            // webDriver.findElement(By.className("avatar-xs")).click();
            action.clickAndHold(webDriver.findElement(By.className("avatar-xs"))).perform();


            Thread.sleep(6000);

            webDriver.findElement(By.linkText("退出登录")).click();
            Thread.sleep(2000);

        }
        @DataProvider(name = "searchWords")
        public static Object[][] words(){
            return new Object [][]{{"atestingred","atestingred","91Testing - 免费软件测试教程"},{"atestingred","1","帐号或密码错误，您还有"},{"1","atestingred","用户名或密码错误"}};
    }

    @Test (dataProvider = "searchWords")
    public void testAtesting(String searchWord1,String searchWord2,String SearchResult) throws InterruptedException , IOException,InterruptedException {
        webDriver.get("http://www.91testing.net/login");

        Thread.sleep(3000);


        login(webDriver,searchWord1,searchWord2);
        Thread.sleep(5000);
        //登录之后的一些操作。
        Assert.assertTrue(webDriver.getPageSource().contains(SearchResult));
        System.out.println("login success!");


        //退出
        logout(webDriver);



        Thread.sleep(5000);

    }
}
