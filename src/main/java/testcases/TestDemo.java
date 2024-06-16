package testcases;

import general.BaseTest;
import general.CommonFunctions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TestDemo {
    public static By path = By.id("io.selendroid.testapp:id/topLevelElementTest");
    @Test
    public static void TestDemo(){
        CommonFunctions.clickFunction(path);
        System.out.println("App launch");
    }
}
