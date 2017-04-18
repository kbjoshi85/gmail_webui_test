import com.kj.categories.Critical;
import com.kj.categories.Major;
import com.kj.pageobjects.*;
import com.kj.utils.WebUtil;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by KJoshi on 03/05/2017.
 */
public class GmailTest {

    private static ChromeDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "/Users/KJoshi/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    @Category({Critical.class})
    @Test
    public void gmailLoginShouldBeSuccessful(){

        //1.   Go to gmail signIn page
        SignInPage signInPage = WebUtil.goToSignInPage(driver);

        //2.Enter Username
        signInPage.enterUsername(driver, "kbjoshitest@gmail.com");

        //3. Go to next page
        SignInPage2 signInPage2 = signInPage.clickNextButton(driver);

        //4. Enter Password
        signInPage2.enterPassword(driver, "testingrocks");

        //5. Uncheck "Stay signed in" -- dont save cookies
        signInPage2.uncheckRemeberMe(driver);

        //6. Click Sign In Button
        EmailHomePage emailHomePage = signInPage2.clickSignIn(driver);

        //7. Verify login was successful
        Assert.assertTrue("Inbox should be present!!",emailHomePage.inboxIsPresent(driver));

        //8. Sign Out
        signInPage = emailHomePage.signOut(driver);

        //9. Verify user signed out successfully
        Assert.assertTrue("Sign In button should exist", signInPage.signInButtonIsPresent(driver));

    }

    @Category({Major.class})
    @Test
    public void gmailSendAndReceive(){
        //Sign in
        //1.   Go to gmail signIn page
        SignInPage signInPage = WebUtil.goToSignInPage(driver);

        //2.Enter Username
        signInPage.enterUsername(driver, "kbjoshitest@gmail.com");

        //3. Go to next page
        SignInPage2 signInPage2 = signInPage.clickNextButton(driver);

        //4. Enter Password
        signInPage2.enterPassword(driver, "testingrocks");

        //5. Uncheck "Stay signed in" -- dont save cookies
        signInPage2.uncheckRemeberMe(driver);

        //6. Click Sign In Button
        EmailHomePage emailHomePage = signInPage2.clickSignIn(driver);

        //7. Verify login was successful
        Assert.assertTrue("Inbox should be present!!",emailHomePage.inboxIsPresent(driver));

        //Click Compose
        emailHomePage.clickOnCompose(driver);

        //Fill in Recipient
        emailHomePage.enterRecipient(driver, "kbjoshi85@gmail.com");

        //Fill in Subject
        final String subjectMatter = "Test email to self";
        emailHomePage.enterSubject(driver, subjectMatter);

        //Fill in email body
        final String emailMatter = "Hello, "+ "\n" + "This is a test email to self";
        emailHomePage.enterEmailBody(driver, emailMatter);

        //Click send
        emailHomePage.clickOnSendButton(driver);

        //Click inbox again
        emailHomePage.clickOnInbox(driver);

        //Click email
        EmailViewPage emailViewPage = emailHomePage.goToEmailViewPage(driver);

        //Verify the email subject and email body is correct
        String actualSubject = emailViewPage.getEmailSubjectText(driver);
        Assert.assertEquals("Title should match", subjectMatter, actualSubject);

        String actualEmailContent = emailViewPage.getEmailContent(driver);
        Assert.assertEquals("Email body content should match", emailMatter, actualEmailContent);

        //Sign out
        signInPage = emailHomePage.signOut(driver);

        //Verify user signed out successfully
        Assert.assertTrue("Sign In button should exist", signInPage.signInButtonIsPresent(driver));

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
