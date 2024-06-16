package general;

import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.mockito.internal.matchers.Null;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


//import static general.CapabilitiesGenerator.getVersion;
import static general.CapabilitiesGenerator.getVersion;


public class WebDriverFactory {
    public static AppiumDriver driver;
    public static AndroidDriver _driver;

    public static AppiumDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }
    public static AndroidDriver<WebElement> getAndroidDriver()
    {
        if (_driver != null) {
            return _driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static AppiumDriver startDriver() throws IOException, DeviceNotFoundException {
        //switch (getVersion())
//        {
//            case "Android":
        //http://127.0.0.1:4723/wd/hub http://0.0.0.0:4723/wd/hub
        _driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesGenerator.getCapabilities());

        driver=((AppiumDriver<MobileElement>)_driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver);
//                break;
//
//            case "iOS":
//                driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), CapabilitiesGenerator.getCapabilities());
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        }
        return driver;
    }



//    public static AppiumDriver startDriver() throws IOException, DeviceNotFoundException {
//        switch (getVersion())
//        {
//            case "Android":
//                _driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), CapabilitiesGenerator.getCapabilities());
//
//                driver=((AppiumDriver<MobileElement>)_driver);
//
//                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//                System.out.println(driver);
//                break;
//
//            case "iOS":
//                driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), CapabilitiesGenerator.getCapabilities());
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        }
//        return driver;
//    }




    public static void finishDriver() throws IOException {
        if (driver != null)
        {
            WebDriverWaits.sleep1000();
            driver.quit();
            driver = null;
        }
    }
}
