package selenium_tools;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lleir on 25/6/17.
 */
public abstract class ABaseTestCase{
    protected static WebDriver driver;
    protected static String baseUrl;
    protected static String user;
    protected static String password;
    protected static String app;
    protected static boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected static WebDriverWait wait;

    protected static boolean detailValidationSteps = true;

    public static void setDetailValidation(boolean detailValidation) {
        detailValidationSteps = detailValidation;
    }

    public static boolean isDetailedTest(){
        return detailValidationSteps;
    }
//
//    public static boolean getDetailValidation(){
//        return System.getProperty(DETAIL_VALIDATION_STEP);
//    }

    public static String getBaseUrl(){
        return baseUrl;
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static boolean getAcceptNextAlert() {
        return acceptNextAlert;
    }

    public static void setAcceptNextAlert(boolean acceptNextAlertt) {
        acceptNextAlert = acceptNextAlertt;
    }

    public static WebDriverWait getWebDriverWait() {
        return wait;
    }

    protected final int TIMEOUT_SECONDS = 10;

    protected final String SCREENSHOTS_DIR = "screenshots/";
    protected final String DRIVER_DIR = "drivers/";
    protected final String SELENIUM_SCREENSHOTS = "selenium.screenshot.dir";
    protected final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
    protected final String IE_DRIVER_NAME = "IEDriverServer.exe";
    protected final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    protected final String CHROME_DRIVER_NAME = "chromedriver.exe";
    protected final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
    protected final String GECKO_DRIVER_NAME = "geckodriver.exe";
    protected final static String DETAIL_VALIDATION_STEP = "detail.validation.step";
    protected String strinit = "Init Test: ";
    protected String strfinish = "OK Finish Test: ";
    public static String testClassName;
    public static String testCaseName;

    public static String getTestClassName(){
        return testClassName;
    }

    public static String getTestCaseName() {
        return testCaseName;
    }


    private static final String URL1 = "https://localhost/tallerlavi3";
    private static final String URL = "https://192.168.1.42/tallerlavi_git";

//    @Before
//    public void seleniumIni() throws Exception {
//        ChromeOptions o = new ChromeOptions();
//        System.setProperty(CHROME_DRIVER_PROPERTY, "C:/Users/Lleir Garcia/git/proyectofinal-sqa/resource/drivers/chromedriver.exe");
//        ArrayList<String> oList = new ArrayList<String>();
//        oList.add("--start-maximize");
//        oList.add("--incognito");
//        o.addArguments(oList);
//        driver = new ChromeDriver(o);
//        driver.get(URL);
//        wait = new WebDriverWait(driver, TIMEOUT_SECONDS);
//
//    }
    @Before
    public void seleniumRemoteHubWebDriver() {
    	DesiredCapabilities capability = null;

    	if(System.getProperty("remote")==null){
    	    ChromeOptions o = new ChromeOptions();

    	  String resource_webdriver = System.getProperty("webdriver.resource.driver");
          String browse = System.getProperty("browse.name");

          
          if(StringUtils.equals(browse, "chrome"))
        	  resource_webdriver += "chromedriver.exe";
	      else if(StringUtils.equals(browse, "firefox"))
	    	  resource_webdriver += "geckodriver.exe";
        
          
          System.out.println(resource_webdriver);
          ArrayList<String> oList = new ArrayList<String>();
          oList.add("--start-maximize");
          oList.add("--incognito");
          o.addArguments(oList);
          driver = new ChromeDriver(o);
          driver.get(URL);
          wait = new WebDriverWait(driver, TIMEOUT_SECONDS);          
    	} 
    	
    	else {
    	
	    	String browser = System.getProperty("browse.name");
	    	System.out.println("browseeee ++++++++++++++++++++++ "+ browser);
	    	
	    	if(StringUtils.equals(browser, "chrome"))
	    		capability = DesiredCapabilities.chrome();
	    	else if(StringUtils.equals(browser, "firefox"))
	    		capability = DesiredCapabilities.firefox();
	
	    	capability.setBrowserName(browser);
	    	System.out.println(browser);
	    	
	    	String platform = System.getProperty("webdriver.platform.name");
	    	System.out.println(platform);
	    	
	    	if(StringUtils.equals(platform, "MAC")){
	    		capability.setPlatform(Platform.MAC);
	    	} else if(StringUtils.equals(platform, "WIN10")){
	    		capability.setPlatform(Platform.WIN10);
	    	}
	    	
	    	
	    	// hay que pasar por parametro el "platform" que define el OS y setear el "BrowserName". esto debe de hacerse en el jenkins
	    	// hay que vigilar con las IPs de los PCs ya que pueden ir cambiando
	    	
	    	String url = System.getProperty("webdriver.url");
	    	System.out.println(url); 
	    	
	    	System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("webdriver.dir"));
	    	System.out.println(CHROME_DRIVER_PROPERTY);
	    	
	    	driver = null;
	    	try {
	            driver = new RemoteWebDriver(new URL(url), capability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	wait = new WebDriverWait(driver, TIMEOUT_SECONDS);
    	driver.get(URL);
    	
    	System.setProperty(SELENIUM_SCREENSHOTS, "C:/Users/Lleir Garcia/git/proyectofinal-sqa2/resource/screenshots");
    }

// /  @Before
//    public void setUp() throws Exception {
//        driver = loadDriver();
//        driver.manage().timeouts().implicitlyWait(TIMEOUT_SECONDS, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, TIMEOUT_SECONDS);
//        String ap 	p = getApp();
//        String baseUrl = System.getProperty("selenium.baseUrl." + app);
//        if (baseUrl != null) {
//            setBaseUrl(baseUrl);
//        }
//        String user = System.getProperty("selenium.user." + app);
//        if (user != null) {
//            setUser(user);
//        }
//        String password = System.getProperty("selenium.password." + app);
//        if (password != null) {
//            setPassword(password);
//        }
//
//        setDetailValidation("0");
//
//    }

    protected WebDriver loadDriver() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String browser = System.getProperty("selenium.browser");
//        String browser = "chrome";
        String remoteWebDriverUrl = System.getProperty("selenium.remotewebdriver.url");
        if (BrowserType.FIREFOX.equals(browser)) {
            /** Firefox Driver **/
            if (remoteWebDriverUrl != null) {
                driver = new RemoteWebDriver(new URL(remoteWebDriverUrl), DesiredCapabilities.firefox());
            } else {
                File firefoxDriver = new File(classLoader.getResource(DRIVER_DIR + GECKO_DRIVER_NAME).getFile());
                System.setProperty(GECKO_DRIVER_PROPERTY, firefoxDriver.getAbsolutePath());
                driver = new FirefoxDriver();
            }
        } else if (BrowserType.CHROME.equals(browser)) { 
            /** Chrome Driver **/
            if (remoteWebDriverUrl != null) {
                driver = new RemoteWebDriver(new URL(remoteWebDriverUrl), DesiredCapabilities.chrome());
            } else {
                File chromeDriver = new File(classLoader.getResource(DRIVER_DIR + CHROME_DRIVER_NAME).getFile());
                System.setProperty(CHROME_DRIVER_PROPERTY, chromeDriver.getAbsolutePath());
                driver = new ChromeDriver();
            }
        } else {
            /** IE Driver **/
            if (remoteWebDriverUrl != null) {
                driver = new RemoteWebDriver(new URL(remoteWebDriverUrl), DesiredCapabilities.internetExplorer());
            } else {
                File ieDriver = new File(classLoader.getResource(DRIVER_DIR + IE_DRIVER_NAME).getFile());
                System.setProperty(IE_DRIVER_PROPERTY, ieDriver.getAbsolutePath());
                driver = new InternetExplorerDriver();
            }
        }

        if (driver == null) {
            throw new Exception("NO DRIVER FOUND");
        }

        return driver;
    }


    protected void switchToFrame(String frameId) {
        driver.switchTo().parentFrame();
        driver.switchTo().frame("CRMApplicationFrame");
        driver.switchTo().frame(frameId);
    }

    protected void waitForElementWithId(String id) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    protected void initTest(String id) {
        this.writeLog(getNameTest());
        java.util.Date dateNow = new Date();
        this.writeLog(strinit + id + " - " + dateNow);
    }

    protected void finishTest(String id) {
        this.writeLog(getNameTest());
        java.util.Date dateNow = new Date();
        this.writeLog(strfinish + id + " - " + dateNow);
        driver.close();
        System.out.println("Test script executed successfully.");
    }

    @After
    public void tearDown() throws Exception {
//         Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
//         Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
//         Thread.sleep(1000);
//         Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
		driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
//		driver = null;
    }


    public void  throwException (String ClassName,String msg, int option) {
        switch (option) {
            case 1:
                System.out.println(ClassName+": "+msg);
                throw new Error(ClassName+": "+msg);
            case 2:
                //CREATE LOG
            default:
                break;
        }
    }

    protected String getNameTest(){
        //Return the name of test
        return new Exception().getStackTrace()[1].getMethodName();
    }

    protected void writeLog(String text){
        //Write in the log
        System.out.println(text);
    }

    protected void Threadsleep() throws InterruptedException{
        Thread.sleep(200);
    }

    protected boolean ifInternetExplorer() throws Exception{
        boolean bReturn = false;
        String browser = System.getProperty("selenium.browser");
        if (BrowserType.FIREFOX.equals(browser))
            bReturn = false;
        else if (BrowserType.CHROME.equals(browser))
            bReturn = false;
        else
            bReturn = true;
        return bReturn;
    }


    public abstract void setBaseUrl(String baseUrl);

    public abstract String getApp();

    public abstract void setTestNameClass(String testNameClass);
    
    public abstract void setTestCaseName(String testCaseName);

}