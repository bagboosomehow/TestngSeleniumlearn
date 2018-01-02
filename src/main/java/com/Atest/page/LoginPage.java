package com.Atest.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by APPLE on 2017/10/30.
 */
public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login_username")
    @CacheLookup
    protected static WebElement NAME_INPUT;//账号输入框

    @FindBy(id = "login_password")
    @CacheLookup
    protected static WebElement PWD_INPUT;//密码输入框

    @FindBy(xpath = "//button[contains(text(),'登录')]")
    @CacheLookup
    protected static WebElement LOGIN_BUTTON;//用户登录按钮
    protected static String url="http://www.91testing.net/login";
}
