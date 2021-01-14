package com.heyi.meike.meike.script.startpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage {
    @FindBy(xpath = "//*[@text='同意']")
    public WebElement agreeWebElement;
    @FindBy(xpath = "//*[@text='请输入手机号码']")
    public WebElement customerPhone;
    @FindBy(xpath = "//*[@text='获取验证码']")
    public WebElement getVerificationCode;
    @FindBy(xpath = "//*[@text='请输入验证码']")
    public WebElement verificationCode;
    @FindBy(xpath = "//*[@text='登录/注册']")
    public WebElement loginAndRegister;
    @FindBy(xpath = "//*[@text='使用账号密码登录']")
    public WebElement loginByPassword;
    //第一个图片组件是手机号一键登录，第二个是微信登录
    @FindBy(className = "android.widget.ImageView")
    public List<WebElement> loginButton;
    @FindBy(xpath = "//*[@text='用户使用协议']")
    public WebElement customerUseAgreement;
    @FindBy(xpath = "//*[@text='隐私协议']")
    public WebElement privacyAgreement;
}
