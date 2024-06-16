package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class Scn1Test {
    @Test
    public void Test() {
        MainCall.scn2.selectDirectory();
        MainCall.scn2.enterUsername();
        MainCall.scn2.enterEmail();
        MainCall.scn2.enterPassword();
        MainCall.scn2.enterName();
        MainCall.scn2.selectProgrammingLanguage();
        MainCall.scn2.clickCheckBox();
        MainCall.scn2.verifyingRegisterUser();
        MainCall.scn2.registeringUser();
        MainCall.scn2.clickOnBrowser();
        MainCall.scn2.enteringNameForCar();
        MainCall.scn2.selectingCar();
        MainCall.scn2.sendingTheName();
        MainCall.scn2.assertingName();
        MainCall.scn2.assertingCarName();
    }
}
