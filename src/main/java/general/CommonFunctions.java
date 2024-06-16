package general;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import java.util.List;

import static general.CommonAssertions.logInfo;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class CommonFunctions {
    public static By hamburger=By.xpath("hamburgerId");
    public static By hamburgerMenu=By.id("HamburgerView");
    public static By homeButton=By.id("Home button Id");

    public static int num=0;
    public static String fieldText="abc";


    public static void sendKeysFunction(By fieldLocator, String fieldText)
    {
        WebDriverFactory.getDriver().findElement(fieldLocator).sendKeys(fieldText);
    }
    public static void clearFieldFunction(By fieldLocator)
    {

        WebDriverFactory.getDriver().findElement(fieldLocator).clear();
    }
    public static void clickFunction(By clickElement)
    {
        WebDriverFactory.getDriver().findElement(clickElement).click();
    }

    public static void clickOnHamburger()
    {
        clickFunction(hamburger);
        WebDriverWaits.visibilityOfElementLocated(hamburgerMenu);
        logInfo("Hamburger has opened");
    }

    public static void navigateBack()
    {
        WebDriverFactory.getDriver().navigate().back();
        logInfo("Navigated Back from previous Screen");
    }
    public static void closeKeyboard()
    {
        WebDriverFactory.getDriver().hideKeyboard();
    }
    public static void clickHomeButton()
    {
        WebDriverFactory.getDriver().findElement(homeButton).click();
    }



    public static void dropDownList(By FieldId , String paraName, int xTapped,int yTapped) throws InterruptedException {


        MobileElement field= (MobileElement) WebDriverFactory.getDriver().findElement(FieldId);
        WebDriverWaits.sleep(1000);

        while (!fieldText.equals(paraName)){
            field.click();
            num = num + 30;

            TouchAction touchAction = new TouchAction(WebDriverFactory.getDriver());
            touchAction.tap(PointOption.point(xTapped, yTapped))
                    .perform();
            WebDriverWaits.sleep(1000);
            fieldText=field.getText();
            System.out.println(fieldText);

        }
        num=0;
    }

    public static void MobileCheckbox(By checkBoxLocator, String status)
    {
        MobileElement element = (MobileElement) WebDriverFactory.getDriver().findElement(checkBoxLocator);
        String checkbox = element.getAttribute("checked");
        //    CommonAssertions.logInfo(checkbox);

        if(status.equals("checked") || status.equals("Checked"))
        {
            if(checkbox.equals("false"))
            {
                CommonFunctions.clickFunction(checkBoxLocator);
            }
        }
        else if(status.equals("unchecked") || status.equals("Unchecked"))
        {
            if(checkbox.equals("false"))
            {
                CommonFunctions.clickFunction(checkBoxLocator);
            }

        }
    }

    public static void verticalScroll() {

        Dimension size = WebDriverFactory.getDriver().manage().window().getSize();
        int y_start = (int) (size.height * 0.60);
        int y_end = (int) (size.height * 0.30);
        int x = size.width / 2;
        TouchAction swipe = new TouchAction(WebDriverFactory.getDriver())
                .press(PointOption.point(x,y_start))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(x,y_end))
                .release()
                .perform();


    }

    public static void performSearchThroughSearchBar(String Text , By searchlocator ,By searchResults)
    {
        sendKeysFunction(searchlocator,Text);
        WebDriverWaits.visibilityOfElementLocated(searchResults);
        clickFunction(searchResults);

    }





    public static void dropDownListMoveUp(By FieldId , String paraName, int xTapped,int yTapped) throws InterruptedException {


        MobileElement field= (MobileElement) WebDriverFactory.getDriver().findElement(FieldId);

        WebDriverWaits.sleep(1000);


        while (!fieldText.equals(paraName))
        {

            field.click();
            num=num-30;

            System.out.println(num);
            TouchAction touchAction = new TouchAction(WebDriverFactory.getDriver());
            touchAction.tap(PointOption.point(xTapped, yTapped))
                    .perform();
            WebDriverWaits.sleep(1000);
            fieldText=field.getText();
            System.out.println(fieldText);
        }
        fieldText="abc";
        num=0;


    }

    public static void tapAction(int xTapped, int yTapped)
    {
        WebDriverWaits.sleep(2000);
        TouchAction touchAction = new TouchAction(WebDriverFactory.getDriver());
        touchAction.tap(PointOption.point(xTapped, yTapped))
                .perform();

    }





    public static void selectOverLoop(List<MobileElement> valueOfTheList , String option)
    {



        for (int i = 0; i < valueOfTheList.size(); i++) {
            if (valueOfTheList.get(i).getText().equals(option)) {
                WebDriverWaits.sleep(2000);
                valueOfTheList.get(i).click();
                break;
            }
        }
        CommonAssertions.logInfo("Radio Button "+option+" has been clicked");
    }

    public static void offTheNet()
    {
        WebDriverFactory.getDriver().getSettings();

    }
    public static void scrollToElement(String elementText)
    {
        WebDriverFactory.getDriver().findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"" + elementText + "\"));"));
    }
}
