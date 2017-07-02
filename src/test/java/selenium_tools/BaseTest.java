package selenium_tools;

import cucumber.api.java.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

/**
 * Created by lleir on 15/6/17.
 */
public class BaseTest  {

    private static final String URL = "http://192.168.1.42/tallerlavi3/";
    private static WebDriver driver;

    @Before
    public void ini(){
        ChromeOptions o = new ChromeOptions();
        ArrayList<String> oList = new ArrayList<String>();
        oList.add("--start-maximize");
        oList.add("--incognito");
        o.addArguments(oList);
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void end() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
