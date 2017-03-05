import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by KJoshi on 03/05/2017.
 */
public class GmailTests {

    private static ChromeDriver driver;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "/Users/KJoshi/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void gmailLoginShouldBeSuccessful(){

        // Go to gmail signIn page
        driver.navigate().to("http://mail.google.com");

        //Enter Username
        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("kbjoshitest");

        //Go to next page
        WebElement nextButton = driver.findElement(By.xpath("//*[@id='next']"));
        nextButton.click();

        // Enter Password
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(By.id("Passwd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement pwdTextBox = driver.findElement(By.id("Passwd"));

        pwdTextBox.click();
        pwdTextBox.clear();
        pwdTextBox.sendKeys("testingrocks");

        //Uncheck "Stay signed in" -- dont save cookies
        WebElement staySignedInCheckbox = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
        staySignedInCheckbox.click();

        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should be present!!",driver.findElements(By.partialLinkText("Inbox")).size()>0);

        //Sign Out
        WebElement profButton = driver.findElement(By.cssSelector("a[title*='Google Account:']"));
        profButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
        WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
        signOutLink.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"next\"]")));
        Assert.assertTrue("Sign In button should exist", driver.findElements(By.xpath("//*[@id=\"next\"]")).size()>0);

    }

    @Test
    public void gmailSendAndReceive(){
        //Sign in
        driver.navigate().to("http://mail.google.com");

        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("kbjoshitest");

        WebElement nextButton = driver.findElement(By.xpath("//*[@id='next']"));
        nextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(By.id("Passwd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement pwdTextBox = driver.findElement(By.id("Passwd"));

        pwdTextBox.click();
        pwdTextBox.clear();
        pwdTextBox.sendKeys("testingrocks");

        WebElement staySignedInCheckbox = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
        staySignedInCheckbox.click();

        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        Assert.assertTrue("Inbox should be present!!",driver.findElements(By.partialLinkText("Inbox")).size()>0);

        //Click Compose
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm'"));
        composeButton.click();

        //Fill in Recipient .//*[@id=':8l']   .//*[@id=':80']
        WebElement toRecipient = driver.findElement(By.cssSelector("textarea[aria-label='To']"));
        toRecipient.click();
        toRecipient.clear();
        toRecipient.sendKeys("kbjoshitest@gmail.com");
        toRecipient.sendKeys(Keys.TAB);

        //Fill in Subject
        WebElement subjectbox = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        subjectbox.click();
        subjectbox.clear();
        final String subjectMatter = "Test email to self";
        subjectbox.sendKeys(subjectMatter);

        //Fill in email body
        WebElement emailBody = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        emailBody.click();
        emailBody.clear();
        final String emailMatter = "Hello! "+ "\n" + "This is a test email to self";
        emailBody.sendKeys(emailMatter );

        //Click send .n1tfz div[role='button']
        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendButton.click();

        //Click inbox again
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (1)")));
        WebElement inboxLink = driver.findElement(By.linkText("Inbox (1)"));
        inboxLink.click();

        //Click email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
        WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
        newEmail.click();

        //Verify the email subject and email body is correct
        WebElement subjectArea = driver.findElement(By.cssSelector("h2[class='hP']"));
        Assert.assertEquals("Title should match", subjectMatter, subjectArea.getText());
        WebElement bodyArea = driver.findElement(By.cssSelector("div[class='nH hx'] div[dir='ltr']"));
        Assert.assertEquals("Email body content should match", emailMatter, bodyArea.getText());

        //Sign out
        WebElement profButton = driver.findElement(By.cssSelector("a[title*='Google Account:']"));
        profButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
        WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
        signOutLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='next']")));
        Assert.assertTrue("Sign In button should exist", driver.findElements(By.xpath("//*[@id='next']")).size()>0);

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
