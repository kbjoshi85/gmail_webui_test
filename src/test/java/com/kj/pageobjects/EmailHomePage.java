package com.kj.pageobjects;

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
        WebElement profButton = driver.findElement(By.cssSelector("a[title*='Google Account:']"));
        profButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
        WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
        signOutLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"next\"]")));

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean inboxIsPresent(ChromeDriver driver) {
        return driver.findElements(By.partialLinkText("Inbox")).size() > 0;
    }

    public void clickOnCompose(ChromeDriver driver) {
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm'"));
        composeButton.click();
    }

    public void enterRecipient(ChromeDriver driver, String s) {
        WebElement toRecipient = driver.findElement(By.cssSelector("textarea[aria-label='To']"));
        toRecipient.click();
        toRecipient.clear();
        toRecipient.sendKeys("kbjoshitest@gmail.com");
        toRecipient.sendKeys(Keys.TAB);
    }

    public void enterSubject(ChromeDriver driver, String subjectMatter) {
        WebElement subjectbox = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        subjectbox.click();
        subjectbox.clear();
        subjectbox.sendKeys(subjectMatter);
    }

    public void enterEmailBody(ChromeDriver driver, String emailMatter) {
        WebElement emailBody = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        emailBody.click();
        emailBody.clear();
        emailBody.sendKeys(emailMatter);
    }

    public void clickOnSendButton(ChromeDriver driver) {
        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendButton.click();
    }

    public void clickOnInbox(ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (1)")));
        WebElement inboxLink = driver.findElement(By.linkText("Inbox (1)"));
        inboxLink.click();
    }
}
