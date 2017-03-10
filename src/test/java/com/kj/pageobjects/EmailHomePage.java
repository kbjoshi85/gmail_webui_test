package com.kj.pageobjects;

import com.kj.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KJoshi on 3/6/17.
 */
public class EmailHomePage {


    public SignInPage signOut(ChromeDriver driver) {
        WebUtil.click(driver, By.cssSelector("a[title*='Google Account:']"));

        WebUtil.click(driver, By.id("gb_71"));

        WebUtil.waitForElementVisible(driver, By.id("next"));

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean inboxIsPresent(ChromeDriver driver) {
        return WebUtil.isElementPresent(driver, By.partialLinkText("Inbox"));
    }

    public void clickOnCompose(ChromeDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[role='button'][gh='cm'"));
    }

    public void enterRecipient(ChromeDriver driver, String s) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("textarea[aria-label='To']"), "kbjoshitest@gmail.com");
    }

    public void enterSubject(ChromeDriver driver, String subjectMatter) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("input[name='subjectbox']"), subjectMatter);
    }

    public void enterEmailBody(ChromeDriver driver, String emailMatter) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("div[aria-label='Message Body']"), emailMatter);
    }

    public void clickOnSendButton(ChromeDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[aria-label*='Send']"));
    }

    public void clickOnInbox(ChromeDriver driver) {
        WebUtil.waitForElementVisible(driver, By.linkText("Inbox (1)"));
        WebUtil.click(driver, By.linkText("Inbox (1)"));
    }

    public EmailViewPage goToEmailViewPage(ChromeDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class='y6'] span[id] b"));
//        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_TIME);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebUtil.click(driver, By.cssSelector("div[class='y6'] span[id] b"));
//        WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
//        newEmail.click();

        return PageFactory.initElements(driver, EmailViewPage.class);
    }
}
