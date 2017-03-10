package com.kj.pageobjects;

import com.kj.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by KJoshi on 3/6/17.
 */
public class SignInPage {

    public void enterUsername(ChromeDriver driver, String s) {
        WebUtil.clearAndSendKeys(driver, By.id("Email"), "kbjoshitest@gmail.com");
    }

    public SignInPage2 clickNextButton(ChromeDriver driver) {
        WebUtil.click(driver, By.xpath("//*[@id='next']"));
//        WebElement nextButton = driver.findElement(By.xpath("//*[@id='next']"));
//        nextButton.click();
        return PageFactory.initElements(driver, SignInPage2.class);
    }

    public boolean signInButtonIsPresent(ChromeDriver driver) {
        WebUtil.waitForElementVisible(driver, By.id("next"));
        return WebUtil.isElementPresent(driver, By.id("next"));
    }
}
