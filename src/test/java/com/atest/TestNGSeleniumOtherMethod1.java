package com.atest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by APPLE on 2017/10/9.
 */
public class TestNGSeleniumOtherMethod1 {
    WebDriver webDriver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
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
        webDriver.get("http://www.91testing.net/login");

        Thread.sleep(3000);
        webDriver.navigate().refresh();
        WebElement size_username=webDriver.findElement(By.id("login_username"));
        //输入框长框
        System.out.println(size_username.getSize());
        System.out.println(webDriver.findElement(By.id("login_username")).getSize());
        //输入框长度

        WebElement size_password=webDriver.findElement(By.id("login_password"));
        //密码框长度
        System.out.println(size_password.getSize());
       //获取元素属性值 打印输出type值
        System.out.println(size_password.getAttribute("name"));
        //判断是否可以显示    是,ture ,
        System.out.println(size_password.isDisplayed());
        Thread.sleep(5000);
        //class有多个值是active， findElements  用过。
        WebElement text = webDriver.findElement(By.className("active"));
        System.out.println(text.getText());

        Thread.sleep(5000);
        // 用户名，密码输入框的长度，获取属性值，id ,name ,classname
        //判断用户名的输入框是否是可显示的。
        WebElement size_u = webDriver.findElement(By.id("login_username"));
        size_u.getSize();
        size_u.getAttribute("id");
        size_u.getAttribute("name");

        size_u.getAttribute("class");
        size_u.isDisplayed();  //true
        WebElement size_p = webDriver.findElement(By.id("login_password"));
        size_p.getSize();
        size_p.getAttribute("id");
        size_p.getAttribute("name");
        size_p.getAttribute("classname");







    }
}
