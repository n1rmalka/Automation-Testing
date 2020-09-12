package Automation;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	static String currentDirectory;
	static int implicitWait = 20;

	

	public static WebDriver getDriver() throws IOException {
		prop = new Properties();
		currentDirectory = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				currentDirectory + "\\src\\test\\java\\Automation\\global.properties");

		prop.load(fis);

		System.setProperty("webdriver.chrome.driver",
				currentDirectory + "\\src\\test\\java\\Automation\\chromedriver.exe");
		// driver = new ChromeDriver();
		if (prop.getProperty("headless").equalsIgnoreCase("Y")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		return driver;

	}

	
}
