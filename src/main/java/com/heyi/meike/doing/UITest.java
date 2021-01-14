package com.heyi.meike.doing;

import com.heyi.meike.tools.appium.AppiumTouchActionTools;
import com.heyi.meike.tools.cmd.CmdTools;
import com.heyi.meike.tools.thread.StartAppiumByPortThread;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

class UITestRunnable implements Runnable {
   public static void main(String[] args) throws Exception {
       List<String> deviceList = CmdTools.getAdbDevices();
       int port = 4721;
       for(String deviceUUID : deviceList){
           new StartAppiumByPortThread(port).start();
           Thread.sleep(10000);
           new Thread(new UITestRunnable(port, deviceUUID)).start();
           port++;
       }
   }

   private AndroidDriver driver;
   private String uuid;

   public AndroidDriver getDriver() {
       return driver;
   }

   public void setDriver(AndroidDriver driver) throws Exception {
       this.driver = driver;
   }

   public UITestRunnable(int port, String uuid) throws Exception {
       this.uuid=uuid;
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
//
           driver.findElementByAndroidUIAutomator("text(\"我的\")").click();
           Thread.sleep(1000);
           //设置键
           driver.findElementByAndroidUIAutomator("text(\"\ue685\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);
           //设置键
           driver.findElementByAndroidUIAutomator("text(\"\ue685\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"个人资料\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"账号管理\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"关于每氪\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"用户协议\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"用户隐私\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"意见反馈\")").click();
           Thread.sleep(1000);
           //返回键
           driver.findElementByAndroidUIAutomator("text(\"\uE6B6\")").click();
           Thread.sleep(1000);

           if(!AppiumTouchActionTools.existElementByAndroidUIAutomator(driver,"检查更新")){
               AppiumTouchActionTools.swipeUp(driver);
           }
           driver.findElementByAndroidUIAutomator("text(\"检查更新\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"退出账号\")").click();
           Thread.sleep(1000);

           Thread.sleep(1000);
           driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"使用账号密码登录\")").click();
           Thread.sleep(1000);

           driver.findElementByAndroidUIAutomator("text(\"请输入手机号码\")").sendKeys("17862462918");
           driver.findElementByAndroidUIAutomator("text(\"请输入密码\")").sendKeys("123456");

           driver.findElementByAndroidUIAutomator("text(\"登录\")").click();


           Thread.sleep(1500);
       } catch (Exception e) {
           System.out.println("uuid:" + uuid);
           System.out.println("classname:" + this.getClass().getName());
//            System.out.println("classname:" + this.getClass().getSimpleName());
           e.printStackTrace();
       }
   }
}
