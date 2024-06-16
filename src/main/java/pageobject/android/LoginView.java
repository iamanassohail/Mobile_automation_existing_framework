package pageobject.android;

import apiCollection.GetResponse;
import general.CommonAssertions;
import general.CommonFunctions;
import general.MainCall;
import general.WebDriverWaits;
import org.openqa.selenium.By;

import java.sql.ResultSet;
import java.sql.SQLException;

import static general.EnvGlobals.projectName;

public class LoginView {
    public static By test = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.TextView[2]");
    public static String selectQuery = "select * from sonardb.automation_report where id =270926;";
    public static String updateQuery = "update sonardb.automation_report set PROJECT_NAME = 'vital' where id =270926;";
    public static String deleteQuery = "delete from  sonardb.automation_report where id =272946;";
    //  public static By textView=By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
public static By textView=By.id("android:id/list");
    public void loginTheApp() throws InterruptedException, SQLException {
        CommonAssertions.logActualReult("Click on the menu");  // Need to at the actual result to maintain the steps


        CommonFunctions.clickFunction(test);

        CommonAssertions.logExpectedResult("Button has been clicked"); //Add expected result of the above action

        WebDriverWaits.visibilityOfElementLocated(textView);  // Explicit wait to the visibility of element

        CommonFunctions.verticalScroll();  // Perform the scroll bt using common functions

        //DbConn.getValueFromColumn(); // Connect with DB to get the value of any column

//       String getBody= GetResponse.getResponseInString();   // Get data from api
//
//        System.out.println(getBody);
//        CommonAssertions.logVerifyFalse("Body is not empty",getBody.isEmpty());  // Pass assertion on api response
//
//        CommonAssertions.logVerifyIntEqual(1,2,"Both equal");  // Fail assertion for the test

    }


    //Database Select  Example
    public void databaseSelectOperation() throws SQLException {
        ResultSet resultSet = MainCall.dbOp.getResult(selectQuery);
        while (resultSet.next()) {
            projectName = resultSet.getString("PROJECT_NAME");
            System.out.println(projectName);
            System.out.println(resultSet.getString("Build"));
            System.out.println(resultSet.getString("platform"));
        }
    }

    //Database Update  Example

    public void databaseUpdateOperation() throws SQLException {
            int count = MainCall.dbOp.executeQuery(updateQuery);
            System.out.println(count + " Number of rows updates");
        }

    //Database Delete  Example

    public void databaseDeleteOperation() throws SQLException {
        int count = MainCall.dbOp.executeQuery(deleteQuery);
        System.out.println(count+" Number of rows deleted");
    }






    }



