package config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")

public class ApplicationConfigReader {

    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }



    @Property(value = "deviceName")
    private String deviceName;

    @Property(value = "automationName")
    private String automationName;

    @Property(value = "ENV")
    private String Environment;

    @Property(value = "dbUrl")
    private String dbUrl;

    @Property(value = "dbUserName")
    private String dbUserName;

    @Property(value = "dbPassword")
    private String dbPassword;


    @Property(value = "dbPort")
    private String dbPort;

    @Property(value = "appPath")
    private String appPath;


    @Property(value = "userName")
    private String userName;

    @Property(value = "userPassword")
    private String password;




    @Property(value = "To")
    private String[] To;

    @Property(value = "SendEmailAfterExecution")
    private String SendEmailAfterExecution;

    @Property(value = "From")
    private String From;

    @Property(value = "FromPassword")
    private String FromPassword;

    @Property(value = "ProjectDescription")
    private String ProjectDescription;



    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public String getDeviceName() {
        return deviceName;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getEnvironment() {
        return Environment;
    }
    public String getDbPort() {
        return dbPort;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }



    public String[] getTo()
    {
        return To;
    }
    public String getFromEmail()
    {
        return From;
    }
    public String getFromPassword()
    {
        return FromPassword;
    }
    public String getSendEmailAfterExecution()
    {
        return SendEmailAfterExecution;
    }
    public String getProjectDescription()
    {
        return ProjectDescription;
    }



    @Property(value = "baseUrl")
    private String baseUrl;
    public String getbaseUrl() {
        return baseUrl;
    }


    @Property(value = "userNameForAuthentication")
    private String userNameForAuthentication;
    public String getuserNameForAuthentication() {
        return userNameForAuthentication;
    }

    @Property(value = "passwordForAuthentication")
    private String passwordForAuthentication;
    public String getPasswordForAuthentication() {
        return passwordForAuthentication;
    }

    @Property(value = "contentType")
    private String contentType;
    public String getcontentType() {
        return contentType;
    }

}
