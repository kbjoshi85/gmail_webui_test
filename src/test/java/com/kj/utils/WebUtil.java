package com.kj.utils;

import com.kj.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by KJoshi on 3/6/17.
 */
public class WebUtil {

    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }


}
