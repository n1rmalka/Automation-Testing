package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions extends Base {
	private static FileInputStream fis;
	public static String cwd = System.getProperty("user.dir");
	public static Properties obj = new Properties();

	/** Locators Property File Method **/
	static {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/* Function to click on a web element */
	public void clickElement(WebElement element, int timeOutInSsec) {

		WebDriverWait wait = null;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, timeOutInSsec);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

	}

	/* Function to send text to a web element */
	public void sendKey(WebElement element, String key, int timeOutInSsec) {

		WebDriverWait wait = null;
		try {
			wait = new WebDriverWait(driver, timeOutInSsec);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(key);
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
	}

	/* Function to check if an element is displayed */
	public boolean isElementDisplayed(WebElement element, int timeOutInSsec) {

		boolean isElementDisplayed = false;
		WebDriverWait wait = null;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, timeOutInSsec);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementDisplayed = element.isDisplayed();
		}

		catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
			isElementDisplayed = false;
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return isElementDisplayed;
	}

	/* Function to get the text of a web element */
	public String getElementText(WebElement element, int timeOutInSsec) {
		WebDriverWait wait = null;
		String text = "";
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, timeOutInSsec);

			wait.until(ExpectedConditions.visibilityOf(element));
			text = element.getText();
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return text;

	}

	/**
	 * Wait For Method for Button
	 */
	public static void waitFor(String object) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		By locator = By.xpath(obj.getProperty(object));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Thread Sleep
	 */
	public static void sleepWait(long wait) {
		try {
			TimeUnit.SECONDS.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* Function to wait for a web element visibility */
	public boolean waitForElementvisible(WebElement element, int timeOutInSsec) {
		try {

			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = null;
			wait = new WebDriverWait(driver, timeOutInSsec);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
			return false;
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return true;
	}

	/* Function to wait for a URL Contains given text */
	public boolean waitForURLContains(String text, int timeOutInSsec) {
		try {

			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = null;
			wait = new WebDriverWait(driver, timeOutInSsec);
			wait.until(ExpectedConditions.urlContains(text));
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
			return false;
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return true;
	}

	/* Function to handle key press */
	public boolean keyPress(String key) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Actions act = new Actions(driver);
			Thread.sleep(2000);

			switch (key) {
			case "BACKSPACE":
				act.sendKeys(Keys.BACK_SPACE).perform();
				Thread.sleep(2000);
				break;
			case "DOWN":
				act.sendKeys(Keys.DOWN).perform();
				Thread.sleep(2000);
				break;
			case "ENTER":
				act.sendKeys(Keys.ENTER).perform();
				Thread.sleep(2000);
				break;
			case "UP":
				act.sendKeys(Keys.UP).perform();
				break;
			case "TAB":
				act.sendKeys(Keys.TAB).perform();
				break;
			case "1":
				act.sendKeys(Keys.NUMPAD1).perform();
				break;
			case "2":
				act.sendKeys(Keys.NUMPAD2).perform();
				break;
			case "3":
				act.sendKeys(Keys.NUMPAD3).perform();
				break;
			case "4":
				act.sendKeys(Keys.NUMPAD4).perform();
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + key);
			}

		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
			return false;
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return true;
	}

	/* Function to get current date */
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	// Assert text present
	// public boolean isTextPresent(WebElement element, String str) {
	// Assert.assertTrue(isElementPresent(element), "Element Locator :"
	// + element + " Not found");
	// String message = element.getText();
	// if (message.contains(str)) {
	// return true;
	// } else {
	// return false;
	// }
	// }

	// Assert element present
	public static Boolean isElementPresent(WebElement element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean result = false;
		try {
			element.isDisplayed();
			result = true;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return result;
	}

	// Get attribute
	public String getAttribute(WebElement element, String attribute, int timeOutInSsec) {
		String text = null;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = null;
			wait = new WebDriverWait(driver, timeOutInSsec);

			wait.until(ExpectedConditions.visibilityOf(element));
			text = element.getAttribute(attribute);
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
		return text;
	}

	// Get scroll
	public void scrollToElement(WebElement element, int timeOutInSsec) {

		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = null;
			wait = new WebDriverWait(driver, timeOutInSsec);

			wait.until(ExpectedConditions.visibilityOf(element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

	}

	// Scroll UP
	public void scrollUp() {

		try {

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

	}

	/**
	 * Dropdown Selection
	 */
	public static void drp_select(WebElement element, String data, int timeOutInSsec) {
		WebDriverWait wait = null;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, timeOutInSsec);
			wait.until(ExpectedConditions.visibilityOf(element));
			Select drp_down = new Select(element);
			drp_down.selectByVisibleText(data);
		} catch (Exception e) {
			e.printStackTrace();
			driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);

		}
		driver.manage().timeouts().implicitlyWait(Base.implicitWait, TimeUnit.SECONDS);
	}

}
