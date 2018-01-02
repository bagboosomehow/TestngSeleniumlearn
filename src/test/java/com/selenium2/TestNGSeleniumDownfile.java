package com.selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by APPLE on 2017/10/17.
 */
public class TestNGSeleniumDownfile {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", "c:\\test");
        firefoxProfile.setPreference("browser.download.useDownloadDir", false);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        // WebDriver driver = new FirefoxDriver(firefoxProfile);
        webDriver = new FirefoxDriver();


    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

    @Test
    public void testAtesting() throws InterruptedException, IOException, InterruptedException {

        Thread.sleep(3000);
        webDriver.get("https://pypi.Python.org/pypi/selenium");
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        webDriver.findElement(By.partialLinkText("selenium-3")).click();
       // webDriver.findElement(By.partialLinkText("selenium-3")).sendKeys(Keys.ENTER);
      //  webDriver.switchTo().activeElement().click();


        Thread.sleep(15000);


    }
}