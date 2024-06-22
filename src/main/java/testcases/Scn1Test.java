package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class Scn1Test {
    @Test
    public void Test() {
        MainCall.scn.selectDirectory();
        MainCall.scn.enterUsername();
        MainCall.scn.enterEmail();
        MainCall.scn.enterPassword();
        MainCall.scn.enterName();
        MainCall.scn.selectProgrammingLanguage();
        MainCall.scn.clickCheckBox();
        MainCall.scn.verifyingRegisterUser();
        MainCall.scn.registeringUser();
        MainCall.scn.clickOnBrowser();
        MainCall.scn.enteringNameForCar();
        MainCall.scn.selectingCar();
        MainCall.scn.sendingTheName();
        MainCall.scn.assertingName();
        MainCall.scn.assertingCarName();
    }
}
