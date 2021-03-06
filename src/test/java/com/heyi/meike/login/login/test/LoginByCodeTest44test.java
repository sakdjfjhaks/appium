package com.heyi.meike.login.login.test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginByCodeTest44test {
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

    @Test
    public void run() throws InterruptedException {

        driver.findElementByAndroidUIAutomator("text(\"消息\")").click();
        driver.findElementByAndroidUIAutomator("text(\"每氪\")").click();
        //        driver.findElementByAndroidUIAutomator("text(\".*有.*\")" ).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().textMatches(\".*有.*\")").click();
        Thread.sleep(1500);

    }

    @AfterEach
    public void after() {
        driver.quit();
    }
}