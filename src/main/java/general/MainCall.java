package general;



import com.venturedive.base.database.connection.DbOperation;
import pageobject.android.*;
import pageobject.iOS.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;



import static config.ConfigProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    public final static String reportPath = System.getProperty("user.dir") + "\\reports\\ExtentReport-"+ new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(Calendar.getInstance().getTime())+".html";
    static ExtentTest test;

    public static ExtentReports startReport(){
        extent = new ExtentReports(System.getProperty("user.dir") +"/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", String.valueOf(Environment));
        return extent;
    }

    public static ExtentReports getExtentReport(){
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }


    public final static DbOperation dbOp = new DbOperation();
    public final static LoginView loginView = new LoginView();

    public final static Scn1Page scn = new Scn1Page();

    public final static Scn3Page scn3 = new Scn3Page();
    public final static Login login = new Login();

    public final static GenericFunctions genericFunctions = new GenericFunctions();




}

