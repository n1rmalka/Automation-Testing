package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.Base;

@RunWith(Cucumber.class)
public class LoginStepDefinition extends Base {
	// public WebDriver driver;
	LoginPage loginPage;
	CheckoutPage checkoutPage;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		if (driver == null) {
			driver = Base.getDriver();
		}
		if (driver.toString().contains("(null)")) {
			driver = Base.getDriver();
		}
		driver.navigate().to("https://dev.trakti.com/en/accounts/authenticate/");
	}

	@And("^login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_something_and_something(String username, String password) throws Throwable {
		if (checkoutPage == null) {
			checkoutPage = new CheckoutPage(driver);
			checkoutPage.enterUsername(username);
			checkoutPage.enterPassword(password);
			checkoutPage.clickLogin();
			Thread.sleep(6000);

		}
	}

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
			loginPage.verifyLogin();
		}
	}

	@And("^billing details section should be displayed$")
	public void billing_details_section_should_be_displayed() throws Throwable {
		checkoutPage.verifyBillingDetailsDisplayed();
	}

	@And("^browser is closed$")
	public void browser_is_closed() throws Throwable {
		driver.quit();
	}

}