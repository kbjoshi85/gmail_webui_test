package com.kj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by KJoshi on 3/6/17.
 */
public class SignInPage {

    public void enterUsername(ChromeDriver driver, String s) {
        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys(s);
    }

    public SignInPage2 clickNextButton(ChromeDriver driver) {
        WebElement nextButton = driver.findElement(By.xpath("//*[@id='next']"));
        nextButton.click();

        return PageFactory.initElements(driver, SignInPage2.class);
    }

    public boolean signInButtonIsPresent(ChromeDriver driver) {
        return driver.findElements(By.xpath("//*[@id=\"next\"]")).size()>0;
    }
}
