package selenium_tools;

import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

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

    protected final String DRIVER_DIR = "drivers/";
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

    public static String getTestClassName(){
        return testClassName;
    }


    private static final String URL = "https://localhost/tallerlavi3";

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
    	DesiredCapabilities capability = DesiredCapabilities.chrome();
    	System.setProperty(CHROME_DRIVER_PROPERTY, "C:/Users/Lleir Garcia/git/proyectofinal-sqa/resource/drivers/chromedriver.exe");
    	capability.setBrowserName("chrome");
    	capability.setPlatform(Platform.MAC);
    	
    	WebDriver driver = null;
    	try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.33:5566/wd/hub"), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
//        String browser = System.getProperty("selenium.browser");
        String browser = "chrome";
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
        // Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
        // Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
        // Thread.sleep(1000);
        // Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
//		driver.quit();
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

    public abstract void setUser(String userr);

    public abstract void setPassword(String passwordd);

    public abstract String getApp();

    public abstract void setTestNameClass(String testNameClass);

}