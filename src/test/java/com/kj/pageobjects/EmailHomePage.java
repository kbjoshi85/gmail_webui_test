package com.kj.pageobjects;

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
}
