package com.kj.utils;

import com.kj.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KJoshi on 3/6/17.
 */
public class WebUtil {

    final static int WAIT_FOR_TIME = 30;

    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static void click(ChromeDriver driver, By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public static void waitForElementVisible(ChromeDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementPresent(ChromeDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public static void clearAndSendKeys(ChromeDriver driver, By by, String s) {
        WebElement element = driver.findElement(by);
        //element.click();
        element.clear();
        element.sendKeys(s);
       // element.sendKeys(Keys.TAB);
    }

    public static String getElementText(ChromeDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element.getText();
    }
}
