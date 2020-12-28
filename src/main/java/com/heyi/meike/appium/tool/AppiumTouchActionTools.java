package com.heyi.meike.appium.tool;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTouchActionTools {
    public static void singleTouchAction(AndroidDriver driver,int xOffset,int yOffset){
        new TouchAction(driver).press(new PointOption().withCoordinates(xOffset,yOffset)).release().perform();
    }

    //todo
    public static void swipeUp(AndroidDriver driver){
        new TouchAction(driver).longPress(new PointOption().withCoordinates(100,300))
                .moveTo(new PointOption().withCoordinates(100,800))
                .release().perform();
    }

    /**
     * 多指下滑
     * */
    public static void swipeUpByFightNum(AndroidDriver driver,int xOffset,int yOffset,int fightNum){
        int step = 10;
        MultiTouchAction multiTouchAction = new MultiTouchAction(driver);

        if(fightNum<1||fightNum>5){
            return;
        }

        for(int i=0;i<fightNum;i++){
            TouchAction touchAction =  new TouchAction(driver).longPress(new PointOption().withCoordinates(xOffset+ i*step,yOffset))
                    .moveTo(new PointOption().withCoordinates(xOffset+ i*step ,yOffset+300))
                    .release();
            multiTouchAction.add(touchAction);
        }

        multiTouchAction.perform();
    }
}
