package com.heyi.meike.my;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetUpTest {
    protected AndroidDriver driver = null;

    @BeforeEach
    public void first() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "10.0"); //安卓操作系统版本
        cap.setCapability("deviceName", "Android Emulator"); //安卓操作系统版本
        cap.setCapability("appPackage", "com.heyi.meike");//被测app的包名
        cap.setCapability("appActivity", ".MainActivity");//被测app的入口Activity名称
        cap.setCapability("noReset", true);//不清空数据
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
    }

    @AfterEach
    public void after() {
//        driver.quit();
    }

    @Test
    public void run() throws InterruptedException {
//
        driver.findElementByAndroidUIAutomator("text(\"我的\")").click();
        //设置键
        driver.findElementByAndroidUIAutomator("text(\"\ue685\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
        //设置键
        driver.findElementByAndroidUIAutomator("text(\"\ue685\")").click();

        driver.findElementByAndroidUIAutomator("text(\"个人资料\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();

        driver.findElementByAndroidUIAutomator("text(\"账号管理\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();

        driver.findElementByAndroidUIAutomator("text(\"关于每氪\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();

        driver.findElementByAndroidUIAutomator("text(\"用户协议\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();

        driver.findElementByAndroidUIAutomator("text(\"用户隐私\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();

        driver.findElementByAndroidUIAutomator("text(\"意见反馈\")").click();
        //返回键
        driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();

        driver.findElementByAndroidUIAutomator("text(\"检查更新\")").click();


        driver.findElementByAndroidUIAutomator("text(\"退出账号\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"使用账号密码登录\")").click();
        driver.findElementByAndroidUIAutomator("text(\"请输入手机号码\")").sendKeys("17862462918");
        driver.findElementByAndroidUIAutomator("text(\"请输入密码\")").sendKeys("123456");

        driver.findElementByAndroidUIAutomator("text(\"登录\")").click();


        Thread.sleep(1500);
    }
}
