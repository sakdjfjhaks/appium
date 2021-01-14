package com.heyi.meike.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectTest {
    /** 同意 */
    @FindBy(xpath = "//*[@text='同意']")
    public WebElement agreeWebElement;


    /** 初始化操作：在首页点击我的10足按钮 */
    public void agree() {
        // 在首页点击我的10足按钮
        this.agreeWebElement.click();
    }
}
