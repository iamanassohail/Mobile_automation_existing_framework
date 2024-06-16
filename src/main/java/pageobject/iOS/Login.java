package pageobject.iOS;

import general.*;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class Login {
    public Login(){}

    public String btnLater = "Later";
    public String btnLogin = "Login";
    public String txtLogin = "Please login to continue";
    public String profileIcon = "profile icon";
    public String loginProfileIcon = "//XCUIElementTypeButton[@name=\"ProfileEditScreen DefaultImage\"]";
    public String coinImg = "//XCUIElementTypeImage[contains(@name,'Coin')]";
    public String startText = "//XCUIElementTypeStaticText[@name=\"Please enter your profile information\"]";
    public String emailField = "emailText";
    public String passwordField = "passwordText";
    public String loginButton = "LOGIN";
    public String nextBtn = "NEXT";
    public String skipBtn = "//XCUIElementTypeButton[@name=\"Skip\"]";
    public String continueBtn = "//XCUIElementTypeButton[@name=\"Continue\"]";
    public String getMyLocBtn = "//XCUIElementTypeApplication[@name=\"Athan\"]//XCUIElementTypeButton[contains(@name,'Get')]";
    public String allowOption = "Allow";
    public String privacyMsg = "//XCUIElementTypeStaticText[@name=\"By tapping 'Continue' you agree to our Terms & Conditions and Privacy Policy\"]";
    public String modalMsg = "//XCUIElementTypeStaticText[@name=\"Allow “Athan” to access your location while you are using the app?\"]";



    public void tapContinueButton()
    {
        WebDriverWaits.sleep1000();
        WebDriverFactory.getDriver().findElementByXPath(continueBtn).click();

        CommonAssertions.logActualReult("User taps on continue button");
    }

    public void tapGetMyLocBtn()
    {
        WebDriverWaits.sleep1000();
        WebDriverFactory.getDriver().findElementByXPath(getMyLocBtn).click();

        CommonAssertions.logActualReult("User taps on getMyLocation button");
    }

    public void tapAllow()
    {
        WebDriverFactory.getDriver().findElementByAccessibilityId(allowOption).click();
        CommonAssertions.logActualReult("User taps on device Allow prompt button");
    }

    public void verifyPrivacyMessage()
    {
        CommonAssertions.logActualReult("User should be shown privacy message");

        WebDriverWaits.sleep(7000);
        String msg = WebDriverFactory.getDriver().findElementByXPath(privacyMsg).getAttribute("name");
        Assert.assertEquals(msg,"By tapping 'Continue' you agree to our Terms & Conditions and Privacy Policy","No privscy msg shown or screen not displayed");

        CommonAssertions.logExpectedResult("Privacy message successfully verified");
    }

    public void verifyAllowMessage()
    {
        CommonAssertions.logActualReult("Allow pop up should be shown");

        String msg = WebDriverFactory.getDriver().findElementByXPath(modalMsg).getAttribute("name");
        Assert.assertEquals(msg,"Allow “Athan” to access your location while you are using the app?","No privscy msg shown or screen not displayed");

        CommonAssertions.logExpectedResult("Allow prompt message verified");
    }

    public void tapNext()
    {
        CommonAssertions.logActualReult("Tap on next button");

        WebDriverFactory.getDriver().findElementByAccessibilityId(nextBtn).click();
        CommonAssertions.logExpectedResult("User taps on next button");
    }

    public void launchApplication()
    {
        verifyPrivacyMessage();
        tapContinueButton();
        tapGetMyLocBtn();
        verifyAllowMessage();
        tapAllow();
        tapNext();
        tapAllow();
        tapNext();
        verifyHomeScreen();
    }


    //PrayerLogging login Modal Functions
    public void tapLoginOnModal()
    {
        WebDriverFactory.getDriver().findElementByAccessibilityId(btnLogin).click();
    }

    public void tapLaterOnLoginModal()
    {
        WebDriverFactory.getDriver().findElementByAccessibilityId(btnLater).click();
        CommonAssertions.logActualReult ("User taps on LaterOn button on Login Modal");

    }

    public void verifyModalDisplayed()
    {
        MobileElement coin = (MobileElement) WebDriverFactory.getDriver().findElementByXPath(coinImg);
        Assert.assertTrue(coin.getAttribute("name").contains("Coin"),"Coin not displayed on login modal");

        CommonAssertions.logActualReult("Modal is displayed");
    }

    public void verifyLoginMessageOnModal()
    {
        String text = WebDriverFactory.getDriver().findElementByAccessibilityId(txtLogin).getAttribute("value");
        Assert.assertEquals(text,"Please login to continue","Login modal not displayed");

        CommonAssertions.logActualReult("Message on login Modal verified");
    }

    public void tapProfileIcon()
    {
        CommonAssertions.logActualReult("Tap on profile icon");

        MobileElement profile = (MobileElement) WebDriverFactory.getDriver().findElementByAccessibilityId(profileIcon);
        profile.click();

        CommonAssertions.logExpectedResult("User taps on Profile icon in logged out state");
    }

    public void tapLoginProfileIcon()
    {
        MobileElement profile = (MobileElement) WebDriverFactory.getDriver().findElementByXPath(loginProfileIcon);
        profile.click();
        CommonAssertions.logActualReult("User taps on Profile icon in logged in state");


    }

    public void verifyStartMessage()
    {
        CommonAssertions.logActualReult("User should be able to see start message");

        String text = WebDriverFactory.getDriver().findElementByXPath(startText).getAttribute("value");
        Assert.assertEquals(text,"Please enter your profile information","Login screen message not shown");

        CommonAssertions.logExpectedResult("Message verified on login screen");
    }

    public void enterLoginDetails(String email, String pass)
    {
        WebDriverFactory.getDriver().findElementByAccessibilityId(emailField).sendKeys(email);
        CommonAssertions.logActualReult("User enters email in login form");

        WebDriverFactory.getDriver().findElementByAccessibilityId(passwordField).sendKeys(pass);
        CommonAssertions.logActualReult("User enters password in login form");
    }

    public void tapLoginButton()
    {
        MobileElement loginBtn = (MobileElement) WebDriverFactory.getDriver().findElementByAccessibilityId(loginButton);
        loginBtn.click();
        WebDriverWaits.sleep(2000);
        CommonAssertions.logActualReult("User taps on login button");
    }

    public void verifyHomeScreen()
    {
        CommonAssertions.logActualReult("Verify user is redirected to home screen");
        CommonAssertions.logExpectedResult("Home screen successfully verified, prayer times link displayed");
    }


    public String verifyIfAlreadyLoggedIn()
    {
        String profile = "";
        try {
            profile = WebDriverFactory.getDriver().findElementByXPath(loginProfileIcon).getAttribute("label");
        }
        catch (Exception e)
        {

        }

        return profile;

    }

    public void loginIntoApp(String email, String pass)
    {
        if (!verifyIfAlreadyLoggedIn().contains("ProfileEditScreen"))
        {
            CommonAssertions.logActualReult("User should be logged in");
            MainCall.login.tapProfileIcon();
            verifyStartMessage();
            enterLoginDetails(email, pass);
            tapLoginButton();
        }

        else
            System.out.println("User already logged in");

    }
}
