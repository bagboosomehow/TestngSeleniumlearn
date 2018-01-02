package com.selenium3;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BB {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.91testing.net/login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBb() throws Exception {
    // 登录练习
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("img.avatar-xs")).click();
    driver.findElement(By.cssSelector("li.user-nav-li-logout > a")).click();
    driver.findElement(By.name("_username")).clear();
    driver.findElement(By.name("_username")).sendKeys("atestingred");
    driver.findElement(By.name("_password")).clear();
    driver.findElement(By.name("_password")).sendKeys("atestingred");
    driver.findElement(By.xpath("//div[4]/button")).click();
    assertEquals(driver.getTitle(), "91Testing - 免费软件测试教程|自动化测试教程|性能测试教程|接口测试教程|安全测试教程 - Powered By EduSoho");
    try {
      assertEquals(driver.getTitle(), "91Testing - 免费软件测试教程|自动化测试教程|性能测试教程|接口测试教程|安全测试教程 - Powered By EduSoho");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("91Testing - 免费软件测试教程|自动化测试教程|性能测试教程|接口测试教程|安全测试教程 - Powered By EduSoho".equals(driver.getTitle())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
