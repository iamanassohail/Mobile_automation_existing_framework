package testcases;

import general.MainCall;
import general.BaseTest;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static general.CapabilitiesGenerator.versionName;

public class LoginTest extends BaseTest {

    @Test(description = "224710")  //Test case id from testrail

    public static void applicationLaunch() throws DeviceNotFoundException, IOException, SQLException, InterruptedException {
        //datbase Select operations example
        MainCall.loginView.databaseSelectOperation();


        //datbase Update operations example
        MainCall.loginView.databaseUpdateOperation();


        //datbase Delete operations example
        MainCall.loginView.databaseDeleteOperation();


        if (versionName.equals("Android"))  //to check the platform either ios or android
        {

            MainCall.loginView.loginTheApp();

        }
        else
            MainCall.login.loginIntoApp("abc@abc.com","abc");

    }




    @Test
    public void skip_Ignore_Test (){
        String a ="Skip / Ignore Test";
        if(a.equals("Skip / Ignore Test")){
            throw new SkipException("Skipping / Ignoring - Script not Ready for Execution ");
        }else{
            System.out.println("In else condition");
        }
        System.out.println("Out of the if else condition");
    }


    @Test
    public void test2(){
        Assert.fail("Forcefully Failing the test case");
    }

}
