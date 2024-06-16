package general;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.venturedive.base.database.connection.SonarDB;
import com.venturedive.base.exception.APIException;
import com.venturedive.base.model.ExecutionStats;
import com.venturedive.base.utility.JIRA;
import com.venturedive.base.utility.MessagesIntegration;
import com.venturedive.base.utility.TestRail;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.venturedive.base.utility.SendEmailAfterExecution.sendReportAfterExecution;


public class BaseTest {
    SonarDB dbconn= new SonarDB();

    static Date startTime = null;
    static Date endTime = null;
    static Integer passedCount = 0;
    static Integer failedCount = 0;
    static Integer skippedCount = 0;
    static ArrayList<String> automationSteps;
    static Integer beforeAddingStepsLength;
    static Integer afterAddingStepsLength;
    static Integer beforeAddingExpectedResultLength;
    static Integer afterAddingExpectedResultLength;
    static ArrayList<String> expectedResults;
    static ArrayList<File> screenShotCollection = new ArrayList<File>();

    private static ExtentTest logger;



    @BeforeSuite()
    public void startReport() throws MalformedURLException, IOException, DeviceNotFoundException, SQLException {


        MainCall.startReport();
        WebDriverFactory.startDriver();
        startTime = getTime();
        automationSteps = new ArrayList<String>();
        expectedResults=new ArrayList<String>();


    }

    @BeforeMethod()
    public void beforeTest(Method method)  {
        beforeAddingStepsLength=automationSteps.size();
        beforeAddingExpectedResultLength=expectedResults.size();
        System.out.println("before"+beforeAddingStepsLength);
        System.out.println("before"+beforeAddingExpectedResultLength);

        logger = MainCall.getExtentReport().startTest(method.getName(), "");
        logger.setStartedTime(getTime());



    }

    @AfterMethod()
    public void QuitDriver(ITestResult result, ITestContext ctx, Method method) throws IOException, APIException, APIException {

        afterAddingStepsLength=automationSteps.size();
        afterAddingExpectedResultLength=expectedResults.size();

        try
        {
            if (result.getStatus() == ITestResult.FAILURE) {
                failedCount++;
                logger.log(LogStatus.FAIL, "Test Case Failed reason is: " + result.getThrowable());
                logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshots.takeScreenshot(result.getMethod().getMethodName())));
                System.out.println("After Actual"+afterAddingStepsLength);
                System.out.println("After Expected"+afterAddingExpectedResultLength);
                screenShotCollection.add(Screenshots.screenShot);
                JIRA.CreateJiraWithScreenShot(result, Screenshots.screenShot , beforeAddingStepsLength, afterAddingStepsLength, automationSteps);
                JIRA.PostMobileIssuesJira();

            }
            else if (result.getStatus() == ITestResult.SKIP) {
                skippedCount++;
                logger.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
            }
            else {
                passedCount++;
                logger.log(LogStatus.PASS, result.getMethod().getMethodName() + " is Passed");

            }


            logger.setEndedTime(getTime());
            MainCall.getExtentReport().endTest(logger);
        }


        finally {

        }
       TestRail.getCaseIdandResultmobile(result,ctx,method,beforeAddingStepsLength,afterAddingStepsLength,automationSteps,beforeAddingExpectedResultLength,afterAddingExpectedResultLength,expectedResults,null);
    }

    private Date getTime()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    @AfterSuite()
    public void endReport() throws Exception {
        WebDriverFactory.finishDriver();
        MainCall.getExtentReport().flush();
        MainCall.getExtentReport().close();

        endTime = getTime();
        TestRail.createSuite();
        TestRail.updateTestRail();
        TestRail.AttachImagesWithTestResults(screenShotCollection);
        dbconn.insertReportingDataIntoDB(startTime, passedCount, failedCount, skippedCount, startTime, endTime); //need to open after jira integration

        ExecutionStats executionStats = new ExecutionStats();
        executionStats.passed=passedCount;
        executionStats.failed=failedCount;
        executionStats.skipped=skippedCount;
        executionStats.reportURL=MainCall.reportPath;
        executionStats.executionDateTime=endTime;
        MessagesIntegration.sendStatsToWorkspace(executionStats);
        sendReportAfterExecution(passedCount, failedCount, skippedCount);



    }
}
