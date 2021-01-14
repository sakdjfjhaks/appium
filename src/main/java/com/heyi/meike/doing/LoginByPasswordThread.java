package com.heyi.meike.doing;

import com.heyi.meike.tools.cmd.CmdTools;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LoginByPasswordThread extends Thread{
    private AndroidDriver driver;
    private String uuid;
    private String customerPhone;

    @FindBy(xpath = "//*[@text='同意']")
    public WebElement agree;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver driver,String customerPhone) throws Exception {
        this.driver = driver;
    }

    public LoginByPasswordThread(int port, String uuid,String customerPhone) throws Exception {
        this.uuid=uuid;
        this.customerPhone=customerPhone;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "Appium");//appium做自动化
        cap.setCapability("platformName", "Android"); //安卓自动化还是IOS自动化
        cap.setCapability("udid", uuid);//被测app的包名
        cap.setCapability("appPackage", "com.heyi.meike");//被测app的包名
        cap.setCapability("appActivity", ".MainActivity");//被测app的入口Activity名称
        cap.setCapability("noReset", true);//不清空数据
        driver = new  AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), cap);//把以上配置传到appium服务端并连接手机
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//隐式等待
    }


    public void after() {
        driver.quit();
    }
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
//            PageObjectTest pageObjectTest = PageFactory.initElements(driver, PageObjectTest.class);
//            pageObjectTest.agree();

            driver.findElementByAndroidUIAutomator("text(\"同意\")").click();
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("text(\"使用账号密码登录\")").click();
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("text(\"请输入手机号码\")").sendKeys(customerPhone);
            driver.findElementByAndroidUIAutomator("text(\"请输入密码\")").sendKeys("123456");
            driver.findElementByAndroidUIAutomator("text(\"登录\")").click();
        } catch (Exception e) {
            System.out.println("uuid:" + uuid);
            System.out.println("classname:" + this.getClass().getName());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws  Exception{
        List<String> deviceList = CmdTools.getAdbDevices();
        Long customerPhone=17862462917L;
        int port=4721;
         Executor executor = new ThreadPoolExecutor(4,12,100000L, TimeUnit.SECONDS, new ArrayBlockingQueue(12));

        for(String device:deviceList){
            customerPhone++;
            port++;
            executor.execute(new LoginByPasswordThread(port,device,customerPhone.toString()));
        }
    }
}
