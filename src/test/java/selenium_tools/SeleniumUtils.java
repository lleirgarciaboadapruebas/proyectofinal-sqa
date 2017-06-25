package selenium_tools;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;

/**
 * @author fphilip@houseware.es
 */
public class SeleniumUtils {

	private static final int DEFAULT_WAIT_4_ELEMENT = 7;
	private static final int DEFAULT_WAIT_4_PAGE = 12;

	// Static Utils

	public static void waitForPageLoaded(WebDriver driver, long timeOutSegundos) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutSegundos);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			assertFalse("Timeout (" + timeOutSegundos + ") esperando que la carga de la pagina se complete.", true);
		}
	}

	public static WebElement waitForElement(WebDriver driver, final By elemento, long timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WebElement waitForElementPresent(WebDriver driver, final By elemento, long timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<WebElement> waitForListElementsPresent(WebDriver driver, final By elemento, long timeOutInSeconds) {
		List<WebElement> elements;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until((new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return areElementsPresent(driverObject, elemento);
				}
			}));
			elements = driver.findElements(elemento);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return elements; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static WebElement waitForElementRefresh(WebDriver driver, final By elemento, long timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					driverObject.navigate().refresh(); // refresh the page
														// ****************
					return isElementPresentAndDisplay(driverObject, elemento);
				}
			});
			element = driver.findElement(elemento);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean waitForTextPresent(WebDriver driver, final By elemento, final String text, long timeOutInSeconds) {
		boolean isPresent = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return isTextPresent(driverObject, elemento, text); // is
																		// the
																		// Text
																		// in
																		// the
																		// DOM
				}
			});
			isPresent = isTextPresent(driver, elemento, text);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return isPresent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean waitForJavaScriptCondition(WebDriver driver, final String javaScript, long timeOutInSeconds) {
		boolean jscondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
				}
			});
			jscondition = (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return jscondition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean waitForJQueryProcessing(WebDriver driver, long timeOutInSeconds) {
		boolean jQcondition = false;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			new WebDriverWait(driver, timeOutInSeconds) {
			}.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																								// implicitlyWait
			return jQcondition;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jQcondition;
	}

	public static void nullifyImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
	}

	public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
	}

	public static void resetImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS); // reset
																							// implicitlyWait
	}

	public static void resetImplicitWait(WebDriver driver, int newWaittime_InSeconds) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																		// implicitlyWait()
		driver.manage().timeouts().implicitlyWait(newWaittime_InSeconds, TimeUnit.SECONDS); // reset
																							// implicitlyWait
	}

	public static boolean isTextPresent(WebDriver driver, By elemento, String text) {
		try {
			return driver.findElement(elemento).getText().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static boolean isElementPresent(WebDriver driver, By elemento) {
		try {
			driver.findElement(elemento);// if it does not find the element
											// throw NoSuchElementException,
											// which calls "catch(Exception)"
											// and returns false;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean areElementsPresent(WebDriver driver, By elemento) {
		try {
			driver.findElements(elemento);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresentAndDisplay(WebDriver driver, By elemento) {
		try {
			return driver.findElement(elemento).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (StaleElementReferenceException e){
			return isElementPresentAndDisplay(driver, elemento);
		}
	}
}
