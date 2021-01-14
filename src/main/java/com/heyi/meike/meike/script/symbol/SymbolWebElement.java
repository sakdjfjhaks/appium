package com.heyi.meike.meike.script.symbol;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SymbolWebElement {
    @FindBy(xpath = "//*[@text='\uE684']")
    private WebElement scan;//扫一扫按钮
    @FindBy(xpath = "//*[@text='\uE685']")
    private WebElement setup;//设置按钮
    @FindBy(xpath = "//*[@text='\uE694']")
    private WebElement chooseButton;//三个点的选择按钮
    @FindBy(xpath = "//*[@text='\uE6C0']")
    private WebElement release;//发布
    @FindBy(xpath = "//*[@text='\uE670']")
    private WebElement like;//点赞
    @FindBy(xpath = "//*[@text='\uE6AA']")
    private WebElement comment;//评论
    @FindBy(xpath = "//*[@text='\uE6E6']")
    private WebElement share;//分享
    @FindBy(xpath = "//*[@text='\uE6B6']")
    private WebElement backup;//返回按钮
    @FindBy(xpath = "//*[@text='\uE6BB']")
    private WebElement edit;//返回按钮



}
