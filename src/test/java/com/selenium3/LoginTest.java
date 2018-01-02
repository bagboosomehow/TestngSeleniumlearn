package com.selenium3;

import com.Atest.method.LoginMethod;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by APPLE on 2017/10/30.
 */
public class LoginTest {
    private WebDriver webDriver;

    @DataProvider(name="testData")
    public Object[][] toBeDataProvider() throws ClassNotFoundException, SQLException {
        return getTestData("testdatatestng");
    }
    @BeforeClass
    public void setup() {
      //  webDriver = new FirefoxDriver();

    }

    @AfterClass
    public void teardown() {
      //  webDriver.quit();
    }

    @Test(dataProvider="testData")
    public void logintest (String username,String password,String result) throws InterruptedException {
        webDriver = new FirefoxDriver();
        LoginMethod loginMethod = new LoginMethod(webDriver);
        System.out.println("----打开登录页面----");
        loginMethod.openUrl();
        Thread.sleep(2000);
        loginMethod.login(username, password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(webDriver.getCurrentUrl().contains(result));//验证是否跳转成功指定的页面
            System.out.println("登录测试通过");
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }
    public static Object[][] getTestData(String tableName) throws ClassNotFoundException, SQLException {
        //设定mysql驱动
        Class.forName("com.mysql.jdbc.Driver");
        //建立数据库连接
        Connection conn= (Connection) DriverManager.getConnection("jdbc:mysql://192.168.10.201:3306/javatestdemo", "red", "123456");
        //判断数据库连接是否成功
        if(!conn.isClosed()){
            System.out.println("数据库连接成功");
        }else {
            System.out.println("数据库连接失败");
        }
        //创建Statement对象可以用对应的方法executeQuery(sql语句)获取测试数据
        Statement sta= (Statement) conn.createStatement();
        //创建一个结果集存放数据库执行完sql的数据
        ResultSet rs=sta.executeQuery("select * from worker");

        //声明存放泛型string数组的list对象
        List<Object[]> listStr=new ArrayList<Object[]>();
        int colNum=rs.getMetaData().getColumnCount();
        while(rs.next()){
            String[]str=new String[colNum];
            for (int i = 0; i < str.length; i++) {
                //System.out.println(rs.getString(i+1).toString());
                //resultSet数据集的getString下标是从1开始的
                str[i]=rs.getString(i+1);
            }
            listStr.add(str);
        }
        //关闭数据集
        rs.close();
        //关闭连接
        conn.close();

        //将list对象数据转换成二维数组
        Object[][]results=new Object[listStr.size()][];
        for(int i=0;i<listStr.size();i++){
            results[i]=listStr.get(i);
        }
        return results;
    }
}
