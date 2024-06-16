package pageobject.android;

import general.CommonAssertions;
import general.WebDriverFactory;
import general.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Scn1Page {

    String nameOfUser = "QA";
    String nameOfCarToSelect = "Mercedes";
    public static By directoryButton = By.xpath("//android.widget.ImageButton[@content-desc='startUserRegistrationCD']");
    public static By userName = By.id("io.selendroid.testapp:id/inputUsername");
    public static By email = By.id("io.selendroid.testapp:id/inputEmail");
    public static By password = By.id("io.selendroid.testapp:id/inputPassword");
    public static By name = By.id("io.selendroid.testapp:id/inputName");
    public static By dropDown = By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
    public static By programmingLanguage = By.xpath("//android.widget.CheckedTextView[@text='Scala']");
    public static By checkBox = By.id("io.selendroid.testapp:id/input_adds");
    public static By verifyRegisterUser = By.id("io.selendroid.testapp:id/btnRegisterUser");
    public static By registerUser = By.id("io.selendroid.testapp:id/buttonRegisterUser");
    public static By nameOfCar = By.xpath("//android.widget.EditText");
    public static By browser= By.id("io.selendroid.testapp:id/buttonStartWebview");
    public static By carSelect = By.xpath("//android.view.View[@text='Volvo']");
    public By carModelSelect = By.xpath("//android.widget.CheckedTextView[@text='"+ nameOfCarToSelect +"']");
    public static By sendName = By.xpath("//android.widget.Button[@text='Send me your name!']");
    public void selectDirectory(){
        CommonAssertions.logInfo("Clicking on Directory");
        WebDriverFactory.getDriver().findElement(directoryButton).click();
    }
    public void enterUsername(){
        CommonAssertions.logInfo("Entering username");
        WebDriverFactory.getDriver().findElement(userName).sendKeys("QA");
    }
    public void enterEmail(){
        CommonAssertions.logInfo("Entering email");
        WebDriverFactory.getDriver().findElement(email).sendKeys("QA@venturedive.com");
        WebDriverFactory.getDriver().navigate().back();
    }
    public void enterPassword(){
        CommonAssertions.logInfo("Entering password");
        WebDriverFactory.getDriver().findElement(password).sendKeys("12345678");
    }
    public void enterName(){
        CommonAssertions.logInfo("Entering name");
        WebElement web = WebDriverFactory.getDriver().findElement(name);
        web.clear();
        WebDriverFactory.getDriver().findElement(name).sendKeys(nameOfUser);
    }
    public void selectProgrammingLanguage(){
        CommonAssertions.logInfo("Selecting programming language from dropdown");
        WebDriverFactory.getDriver().findElement(dropDown).click();
        WebDriverFactory.getDriver().findElement(programmingLanguage).click();
    }
    public void clickCheckBox(){
        CommonAssertions.logInfo("Checking the checkbox");
        WebDriverFactory.getDriver().findElement(checkBox).click();
    }
    public void verifyingRegisterUser(){
        CommonAssertions.logInfo("Register user (verify)");
        WebDriverFactory.getDriver().findElement(verifyRegisterUser).click();
    }
    public void registeringUser(){
        CommonAssertions.logInfo("Register user");
        WebDriverWaits.visibilityOfElementLocated(registerUser);
        WebDriverFactory.getDriver().findElement(registerUser).click();
    }
    public void clickOnBrowser(){
        WebDriverFactory.getDriver().findElement(browser).click();
    }
    public void enteringNameForCar(){
        CommonAssertions.logInfo("Entering name to send");
        WebDriverWaits.visibilityOfElementLocated(nameOfCar);
        WebElement web = WebDriverFactory.getDriver().findElement(nameOfCar);
        web.clear();
        WebDriverFactory.getDriver().findElement(nameOfCar).sendKeys(nameOfUser);
    }
    public void selectingCar(){
        CommonAssertions.logInfo("Selecting the car");
        WebDriverFactory.getDriver().findElement(carSelect).click();
        WebDriverFactory.getDriver().findElement(carModelSelect).click();
    }
    public void sendingTheName(){
        CommonAssertions.logInfo("Sending the name");
        WebDriverFactory.getDriver().findElement(sendName).click();
    }
    public void assertingName(){
        String text;
        text = '"' + nameOfUser + '"';
        By getNameOfUser = By.xpath("//android.widget.TextView[@text='"+ text +"']");
        WebElement web =  WebDriverFactory.getDriver().findElement(getNameOfUser);
        String getName = web.getText();
        CommonAssertions.logVerifyStringNotEqual(getName,nameOfUser,"Asserting the name");
    }
    public void assertingCarName(){
        String text;
        text = '"' + nameOfCarToSelect.toLowerCase() + '"';
        By getNameOfCar = By.xpath("//android.widget.TextView[@text='"+ text +"']");
        WebElement web =  WebDriverFactory.getDriver().findElement(getNameOfCar);
        String getCarName = web.getText();
        CommonAssertions.logVerifyStringNotEqual(getCarName,nameOfCarToSelect,"Asserting the car name");
    }
}
