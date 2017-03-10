package com.kj.pageobjects;

import com.kj.utils.WebUtil;
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
        return WebUtil.getElementText(driver, By.cssSelector("h2[class='hP']"));
    }

    public String getEmailContent(ChromeDriver driver) {
        return WebUtil.getElementText(driver, By.cssSelector("div[class='nH hx'] div[dir='ltr']"));
    }
    
}
