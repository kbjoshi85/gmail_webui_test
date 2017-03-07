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
public class SignInPage2 {
    public void enterPassword(ChromeDriver driver, String s) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(By.id("Passwd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement pwdTextBox = driver.findElement(By.id("Passwd"));

        pwdTextBox.click();
        pwdTextBox.clear();
        pwdTextBox.sendKeys("testingrocks");
    }

    public void uncheckRemeberMe(ChromeDriver driver) {
        WebElement staySignedInCheckbox = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
        staySignedInCheckbox.click();
    }

    public EmailHomePage clickSignIn(ChromeDriver driver) {
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

        return PageFactory.initElements(driver, EmailHomePage.class);
    }
}
