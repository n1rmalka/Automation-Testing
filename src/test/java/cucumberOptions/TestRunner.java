package cucumberOptions;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import Automation.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"classpath:features/SmokeTest.feature" }, glue = "stepDefinitions", monochrome = true, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:", "pretty", "html:target/cucumber",
				"json:target/cucumber.json", "junit:target/cukes.xml" }, tags = { "@HomepageAddtocart" })
public class TestRunner extends Base {

	private String outputDir = "reportoutput/" + new Date().toString().substring(0, 10);
	private String timestamp = new SimpleDateFormat("_HHmmss").format(new Date());

	@BeforeSuite
	public void setUP_Mobilenop() throws IOException, AWTException {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(outputDir + "/ExtentReport" + timestamp + ".html");
	}

	@AfterClass
	public static void loadreportfile() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}
