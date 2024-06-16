package general;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericFunctions {

    public static By byNextDate                = By.id("android:id/next");
    public static By bySelectNextDate          = By.xpath("//android.view.View[@text='14']");
    public static By byDateOkBtn               = By.id("android:id/button1");



    public static void selectCalenderDate()
    {
        WebDriverFactory.getDriver().findElement(byNextDate).click();
        WebDriverFactory.getDriver().findElement(bySelectNextDate).click();
        WebDriverFactory.getDriver().findElement(byDateOkBtn).click();
    }

    //Fetch Day
    public static String getDayFromDate() {

        Date now = new Date();

//        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
//        System.out.println(simpleDateformat.format(now));

        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return simpleDateformat.format(now);


    }


    //Set device time to any date
    public static void setEmulatorTime(String command) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        // -- Linux --

        // Run a shell command
        processBuilder.command("bash", "-c", command);

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
//        processBuilder.command("cmd.exe", "/c", command);

        // Run a bat file
        //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success! Time changed to"+ " " + EnvGlobals.dateToSet);
                System.out.println(output);
//                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    //Generate Random String
      public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = "dummyKey" + first_letter + other_letters;
        return finalname;
    }
}


