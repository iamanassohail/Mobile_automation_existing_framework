Application properties file :
In this file you need to define your own credentials to run the integrations like
1: JIra username , jira token , testrail credentials and all.

You don't need to define the device name , it will be capture automatically once your device connected with laptop.All you need is to install ADB in your laptop
For linux / android type the command : sudo apt-get install android-tools-adb
once done then check the command : adb devices 
It will return the connected devices name.

For linux /ios : sudo apt install libimobiledevice6 libimobiledevice-utils
To check the connection type : idevicepair pair



Framework is written to help ios and android both so if you are working on ios , create your objects in ios pkg and if working on android then add objects in android package.

log4j.xml and Project logs.xls will be used to maintain the logging of the actions during execution and these actions will be defined in test object classes like "CommonAssertion.actualResult" and "CommonAssertion.expectedResult"

Don't forget to add the actual and expected steps in object class , these will be used in jira and testrail

Common assertion class has all the common assertions that can be used during test automation

Common Function is the collection of common functions related to mobile apps like scroll , tap , touch , swipe

Generic functions will have generic functions related to automation like random number , get current date etc

Db connection is done and user can get the value of column

Api integration has been done wit get (value , body and json response) and post call.
#
######PUSH NOTFICATION
Push notification implementation work is done in after suite method in BaseClass. For now we are using SlackChannel to show result
Google Space can be set up for result in ApplicationConfig.properties File
Moreover com.venturedive library is being updated from 8.6 to 8.9 in pom.xml to inherit changes.

Slack integration: 

 - Slack can be added in ApplicationConfig.properties.file
 - Go to file and add slack webhook url
 - By adding credentials and running scripts results will be notified on mentioned slack webhook
 - Slack webhook url should be added under Email heading.
___
#
###### Pre-requisites (Ubuntu):

1) Java JDK 8 should be installed by using the following commands:

    - `sudo apt install openjdk-8-jdk`


2) Verify that the same version is installed

    - `java -version`
    

3) JAVA_HOME environment variable should be set
    - `export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64`


4) Verify that the variable is set
    - `echo $PATH`


5) Android Studio should be installed


6) ANDROID_HOME environment variable should be set 
    - `export ANDROID_HOME=/home/abc/Android/Sdk`

    - `export ANDROID_SDK_ROOT=/home/abc/Android/Sdk`


8) Maven 3.6 version should be installed by using the following commands
    - `sudo apt install maven`
    - `sudo apt update`


8) To verify the installation, run
    - `mvn -version`
   

7) M2_Home variable should be set
   - `echo 'export M2_HOME=/opt/apache-maven-3.5.4' >> ~/.bashrc`
  
- Restart the system after completing the above steps

#
###### Steps to setup (Ubuntu):

1) Download _Android Studio_ and setup a **virtual device**
   - https://developer.android.com/studio/run/managing-avds


2) Download Nodejs and npm

   - `sudo apt-get install nodejs`
   - `sudo apt-get install npm`

    
3) Install Appium
   - `sudo npm install -g appium`
   

4) Appium is installed in your system, Now let us use the below command in terminal to start the Appium server
   - `appium`
   

5) Install Appium Image
   - https://github.com/appium/appium-desktop/releases/tag/v1.18.3 and download “Appium-linux-1.18.3.AppImage”


6) Once download gets completed, go to downloads, right-click on the downloaded folder, go to permissions, and then click on “Allow executing file as program”.


7) After allowing, double click on the app. This will start the installation process. Once complete double click on the appium icon


8) Clone repo: https://bitbucket.org/venturedive/mobileautomationframework/src/master/

    - On Bitbucket.com, navigate to the main page of the repository.
    - To clone your repository, click on the copy icon
    - Go to the location where you want to clone the repository
    - Make a folder and open it.
    - Right click and open Terminal in that folder
    - Type git clone, and then paste the URL you copied earlier.
    - $ git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
    - Press Enter to create your local clone.


9) Create your own branch
    - Click on Branches Tab in Bitbucket
    - Click on Create branch
    - Type your branch name and click on create


10) Open project on IntelliJ
- Open terminal and run command.
    - mvn clean test
    - git pull
- Checkout your created branch
    - git checkout origin/yourbranchname

11) Start _Appium Server_ (Appium Image) which you installed.


12) Start the Server


13) Click on _**Start Inspector Session**_ denoted with a Search icon and _Edit_ the _Json Representation_ section to add the following Json. 

    -`{
"app": "{PATH OF YOUR BUILD}",
"platformName": "Android",
"platformVersion": "10",
"deviceName": "{NAME OF YOUR VIRTUAL DEVICE}"
}`


14)  Click on _Start Session_.



###### DataBase Connection

db =

dbUrl=

dbUserName=

dbPassword=2

dbPort =

1-for mysql db set **db=mysql**

2-for postgres db set **db=postgres**

3-import venture dive jar in POM

4-initialize dbConnection db class  in MainCall class i.e **DbOperation dbOp = new DbOperation();**

5-DataBase integration example in **objects.Login** class function name **dataBaseQuery()**

########## Demo APK #########

Demo APK has been added in the directory "APK". You dont need to change the app path for the APK.

########## Database operations examples ######

Example database operations (Select, Update, Delete) has been added in pageobject --> android --> LoginView.

1- For select query:  databaseSelectOperation()
2- For update query:  databaseUpdateOperation()
3- For delete query:  databaseDeleteOperation()

###### CQM #######

In order to insert your passed/failed results in CQM database the following values should be set in ApplicationConfig.properties file.

sonarurl= URL
sonaruser = username
sonarpwd  = password
sonarport = 3306

Project = Project name
Platform=Android
BUILD_NUMBER = Build number
GIT_COMMIT = Commit
GIT_BRANCH = Branch name

Now if you dont want to get the coverage count from Test Rail set the following parameters in ApplicationConfig.properties file.

CoverageFromTestRail=False
CoverageCount = Total number of cases

In the BaseTest after suite method, the calculation for passed,failed and skipped cases is added so that after the excution of your test suite
these counts will be populated in the CQM database.

These counts can also be displayed in CQM dashboad by setting the following flag in ApplicationConfig.properties file to 1.

COMPONENT_ID = 1


###### Browserstack#######
Browserstack integration is done 
To integrate appium with browserstack please follow these steps

Step 1
On Application.Config.properties comment down android real device function
add app path,
appActivity
appPackage= 
appPackageValue
Also go to browserStack and upload application that is needed to run test cases.
Step 2:
Go to CapabiltiesGenerator 
add username and key 
Step 3:
Ready to use
On using BrowserStack:
You can go to browserStack portal and can view recording of your cases 
It will tell steps and as well as time taken to execute all cases.
An mobile screen is visible with all executed cases