package com.heyi.meike.tools.preinstall;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OppoPreInstallThread implements Runnable{

    private AndroidDriver driver;
    public AndroidDriver getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver driver) throws Exception {
        this.driver = driver;
    }

    public OppoPreInstallThread(int port, String uuid) throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
//        cap.setCapability("platformVersion", "10.0"); //安卓操作系统版本
//        cap.setCapability("deviceName", "Android Emulator"); //安卓操作系统版本
        cap.setCapability("udid", uuid);//被测app的包名
        cap.setCapability("appPackage", "com.heyi.meike");//被测app的包名
        cap.setCapability("appActivity", ".MainActivity");//被测app的入口Activity名称
        cap.setCapability("noReset", true);//不清空数据
        driver = new AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
    }


    public void after() {
        driver.quit();
    }

    @Override
    public void run() {
        try {
            driver.findElementByAndroidUIAutomator("text(\"我的\")").click();
        } catch (Exception e) {
        }
    }
}
