package config;


public class ConfigProperties {

    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String deviceName = appConfig.getDeviceName();
    public static String automationName = appConfig.getAutomationName();
    public static String appPath = appConfig.getAppPath();
    public static String userName = appConfig.getUserName();
    public static String password = appConfig.getPassword();


    public static String Environment = appConfig.getEnvironment();
    public static String dbUrl = appConfig.getDbUrl();
    public static String dbUserName = appConfig.getDbUserName();
    public static String dbPassword = appConfig.getDbPassword();
    public static String dbPort = appConfig.getDbPort();


    public static String[] To= appConfig.getTo();
    public static String From=appConfig.getFromEmail();
    public static String FromPassword=appConfig.getFromPassword();
    public static String SendEmailAfterExecution=appConfig.getSendEmailAfterExecution();
    public static String ProjectDescription=appConfig.getProjectDescription();

    public static String baseUrl=appConfig.getbaseUrl();
    public static String userNameForAuthentication=appConfig.getuserNameForAuthentication();
    public static String userPasswordForAuthentication=appConfig.getPasswordForAuthentication();
    public static String contentType=appConfig.getcontentType();


}
