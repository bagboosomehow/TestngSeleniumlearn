package com.selenium3;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by APPLE on 2017/10/21.
 */
public class TestNGSeleniumDD2 {
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
    @DataProvider(name="testData")
    public static Object[][] words() throws IOException
    {

        return getData("C:\\test", "3.xlsx", "Sheet1");

    }
    public static Object[][] getData(String filePath,String fileName,String sheetName) throws IOException{
//制作File对象
        File file=new File(filePath+"\\"+fileName);
        FileInputStream input=new FileInputStream(file);
        Workbook workbook=null;
//
        String fileExtensionName=fileName.substring(fileName.indexOf("."));
        if (fileExtensionName.equals(".xlsx")) {
            workbook=new XSSFWorkbook(input);

        }else if (fileExtensionName.equals(".xls")) {
            workbook=new HSSFWorkbook(input);

        }

//获取sheet
        Sheet sheet=workbook.getSheet(sheetName);
//获取总行数
        int row=sheet.getLastRowNum()-sheet.getFirstRowNum();

        List<Object[]> records=new ArrayList<Object[]>();
        for (int i = 1; i < row+1; i++) {
            Row rowValue=sheet.getRow(i);
//声明二个数组用来存储二个数据

            String[] fileds=new String[rowValue.getLastCellNum()];

            for (int j = 0; j < rowValue.getLastCellNum(); j++) {

                fileds[j]=rowValue.getCell(j).getStringCellValue();

            }

            records.add(fileds);
        }

        Object[][] results=new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i]=records.get(i);
        }

        return results;
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
    @Test(dataProvider="testData")
    public void LoginTest(String word1,String word2) throws InterruptedException, IOException {
        webDriver.get("http://www.91testing.net/login");
        login(webDriver, word1, word2);
        Thread.sleep(5000);
        //登录之后的一些操作。

        System.out.println("login success!");


        //退出
        logout(webDriver);



        Thread.sleep(5000);


    }

}
