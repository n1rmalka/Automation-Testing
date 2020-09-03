package stepDefinitions;

import Automation.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Base {

	@Before("@Test")
	public void beforeVerification() {
		System.out.println("Before   hook");
	}

	@After("@SmokeTest")
	public void afterValdiation() {
		driver.close();
	}

	@After("@RegressionTest")
	public void AfterTest() {
		driver.close();
	}

	@Before("@Test")
	public void beforeValdiation() {
		System.out.println("Before  hook");
	}

	@After("@Test")
	public void afterVerification() {
		System.out.println("  After before hook");
	}
}
