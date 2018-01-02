package com.Atest.method;

import com.Atest.page.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by APPLE on 2017/10/30.
 */
public class LoginMethod extends LoginPage {

    private WebDriver webDriver;


    public LoginMethod(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    /**
     * 打开登录页面
     *
     * 登录页面url
     */
    public void openUrl() {

        webDriver.get(super.url);
    }

    /**
     * 执行登录
     *
     * @param name 用户名
     * @param pwd  密码
     */
    public void login(String name, String pwd) throws InterruptedException {
        NAME_INPUT.sendKeys("");
        NAME_INPUT.clear();
        NAME_INPUT.sendKeys(name);
        PWD_INPUT.sendKeys("");
        PWD_INPUT.clear();
        PWD_INPUT.sendKeys(pwd);
        Thread.sleep(2000);
        LOGIN_BUTTON.click();
    }


}