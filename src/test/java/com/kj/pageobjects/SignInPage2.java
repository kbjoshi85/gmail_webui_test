package com.kj.pageobjects;

import com.kj.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KJoshi on 3/6/17.
 */
public class SignInPage2 {

    public void enterPassword(ChromeDriver driver, String s) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("input[id='Passwd']"));
        WebUtil.clearAndSendKeys(driver, By.cssSelector("input[id='Passwd']"), "testingrocks");

    }

    public void uncheckRemeberMe(ChromeDriver driver) {
        WebUtil.click(driver, By.xpath("//*[@id='PersistentCookie']"));
//        WebElement staySignedInCheckbox = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
//        staySignedInCheckbox.click();
    }

    public EmailHomePage clickSignIn(ChromeDriver driver) {
        WebUtil.click(driver, By.id("signIn"));
//        WebElement signInButton = driver.findElement(By.id("signIn"));
//        signInButton.click();

        WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));

//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
//
        return PageFactory.initElements(driver, EmailHomePage.class);
    }
}
