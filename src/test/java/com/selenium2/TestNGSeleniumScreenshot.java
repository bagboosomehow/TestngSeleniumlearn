package com.selenium2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by APPLE on 2017/10/19.
 */
public class TestNGSeleniumScreenshot {
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
    public void testlogin() throws InterruptedException, IOException, InterruptedException {

        Thread.sleep(3000);
        webDriver.get("http://www.91testing.net/");
        try {
            File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
           //文件名测试用例铭 testlogin_longpage
            FileUtils.copyFile(srcFile, new File("c:\\test\\screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}