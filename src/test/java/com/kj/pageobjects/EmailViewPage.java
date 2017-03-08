package com.kj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KJoshi on 3/7/17.
 */
public class EmailViewPage {
    public String getEmailSubjectText(ChromeDriver driver) {
        WebElement subjectArea = driver.findElement(By.cssSelector("h2[class='hP']"));
        return subjectArea.getText();
    }

    public String getEmailContent(ChromeDriver driver) {
        WebElement emailContent = driver.findElement(By.cssSelector("div[class='nH hx'] div[dir='ltr']"));
        return emailContent.getText();
    }

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
}
