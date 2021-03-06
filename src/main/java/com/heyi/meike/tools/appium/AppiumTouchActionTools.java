package com.heyi.meike.tools.appium;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTouchActionTools {
    /**
     * 单点
     */
    public static void singleTouchAction(AndroidDriver driver, int xOffset, int yOffset) {
        new TouchAction(driver).press(new PointOption().withCoordinates(xOffset, yOffset)).release().perform();
    }

    //todo

    /**
     * 下滑
     */
    public static void swipeDown(AndroidDriver driver) {
        new TouchAction(driver).longPress(new PointOption().withCoordinates(100, 300))
                .moveTo(new PointOption().withCoordinates(100, 800))
                .release().perform();
    }
    /**
     * 上滑
     */
    public static void swipeUp(AndroidDriver driver) {
        new TouchAction(driver).longPress(new PointOption().withCoordinates(100, 800))
                .moveTo(new PointOption().withCoordinates(100, 300))
                .release().perform();
    }
    /**
     * 多指下滑
     */
    public static void swipeUpByFightNum(AndroidDriver driver, int xOffset, int yOffset, int fightNum) {
        int step = 10;
        MultiTouchAction multiTouchAction = new MultiTouchAction(driver);

        if (fightNum < 1 || fightNum > 5) {
            return;
        }

        for (int i = 0; i < fightNum; i++) {
            TouchAction touchAction = new TouchAction(driver).longPress(new PointOption().withCoordinates(xOffset + i * step, yOffset))
                    .moveTo(new PointOption().withCoordinates(xOffset + i * step, yOffset + 300))
                    .release();
            multiTouchAction.add(touchAction);
        }

        multiTouchAction.perform();
    }

    /**
     * 判断组件是否存在
     * */
    public static Boolean existElementByAndroidUIAutomator(AndroidDriver driver,String uiText){
        try {
            driver.findElementByAndroidUIAutomator("text(\""+uiText+"\")");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
