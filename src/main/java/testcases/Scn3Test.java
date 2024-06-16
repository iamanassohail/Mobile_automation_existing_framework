package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class Scn3Test {
    @Test
    public void Test(){
        MainCall.scn3.clickOnProgressBarButton();
        MainCall.scn3.waitForProgressBarVisibility();
        MainCall.scn3.waitForRegisterUserView();
        MainCall.scn3.navigateBack();
        MainCall.scn3.clickOnToastButton();
        MainCall.scn3.waitForToast();
        MainCall.scn3.clickOnFocusButton();
        MainCall.scn3.focusOnInputField();
    }
}
