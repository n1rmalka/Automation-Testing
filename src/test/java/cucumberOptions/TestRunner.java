package cucumberOptions;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Dictionary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeSuite;
import org.testng.reporters.Files;

import com.aventstack.extentreports.ExtentReporter;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;

import Automation.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {

		"classpath:features/Home.feature",

		"classpath:features/SearchAddToCart.feature",

		"classpath:features/HomeAddToCart.feature",

		"classpath:features/SignIn.feature",

		"classpath:features/Login.feature",

		"classpath:features/Signup.feature"

}, glue = "stepDefinitions", monochrome = true, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:", "pretty",
		"html:target/cucumber", "json:target/cucumber.json", "junit:target/cukes.xml" }
// ,tags = { "@test1" }
)
public class TestRunner extends Base {

	private static String outputDir = "/test-output/" + new Date();
	private String timestamp = new SimpleDateFormat("_HHmmss").format(new Date());
	public static ExtentReports extent;

	@Before
	public void init() throws IOException, AWTException {

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(outputDir + "/ExtentReport" + timestamp + ".html");
	}

	@After
	public static void loadreportfile(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows");
		driver.close();
	}

}
