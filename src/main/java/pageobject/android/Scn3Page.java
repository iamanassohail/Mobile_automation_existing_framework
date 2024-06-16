package pageobject.android;

import general.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Scn3Page {
    public static By progressBarButton = By.xpath("//android.widget.Button[@text='Show Progress Bar for a while']");
    public static By progressBarVisibility = By.xpath("//android.widget.ProgressBar");
    public static By userName = By.xpath("//android.widget.TextView[@text='Username']");
    public static By clickOnToastButton = By.xpath("//android.widget.Button[@text='Displays a Toast']");
    public static By toastMessage = By.xpath("//hierarchy/android.widget.Toast");
    public static By focusButton = By.xpath("//android.widget.Button[@text='Display and focus on layout']");
    public static By focusText = By.xpath("//android.widget.TextView[@text='Should only be found once']");
    public void clickOnProgressBarButton(){
        CommonAssertions.logInfo("Clicking on Progressbar button");
        CommonFunctions.clickFunction(progressBarButton);
    }
    public void waitForProgressBarVisibility(){
        CommonAssertions.logInfo("Checking visibility of progress bar and assert");
        WebDriverWaits.visibilityOfElementLocated(progressBarVisibility);
        WebElement web = WebDriverFactory.getDriver().findElement(progressBarVisibility);
        if(web != null){
            boolean bar = true;
            CommonAssertions.logVerifyTrue("Bar is displayed ",bar);
        }
        else{
            boolean bar = false;
            CommonAssertions.logVerifyFalse("Bar is not displayed", bar);
        }
    }
    public void waitForRegisterUserView(){
        CommonAssertions.logInfo("Navigating to Registered user view");
        WebDriverWaits.visibilityOfElementLocated(userName);
    }
    public void navigateBack(){
        CommonFunctions.navigateBack();
        WebDriverFactory.getDriver().navigate().back();
    }
    public void clickOnToastButton(){
        CommonAssertions.logInfo("Clicking on toast button");
        WebDriverFactory.getDriver().findElement(clickOnToastButton).click();
    }
    public void waitForToast(){
        CommonAssertions.logInfo("Asserting toast message ");
        WebElement web = WebDriverFactory.getDriver().findElement(toastMessage);
        String text = web.getText();
        CommonAssertions.logVerifyStringEqual(text, "Hello selendroid toast!","Strings are matched" );
    }
    public void clickOnFocusButton(){
        CommonAssertions.logInfo("Click on focus button");
        WebDriverFactory.getDriver().findElement(focusButton).click();
        WebDriverFactory.getDriver().findElement(focusButton).click();
    }
    public void focusOnInputField(){
        CommonAssertions.logInfo("Checking Active Element");
        WebElement element = WebDriverFactory.getDriver().findElement(By.xpath("//*[@focused=\"true\"]"));
        String resourceId = element.getAttribute("focused");
        CommonAssertions.logVerifyStringEqual(resourceId,"true","Focused flag is");
    }
}
