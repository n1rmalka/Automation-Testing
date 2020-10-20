package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.BillingPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Automation.Base;

public class LoginStepDefinition extends Base {
	// public WebDriver driver;
	LoginPage loginPage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;
	public String time = new SimpleDateFormat("HHmmss").format(new Date());

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

	@And("^click on logout and verify the message$")
	public void click_on_logout_and_verify_the_message() throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.clicklogout();
		loginPage.verifyLogout();

	}

	@And("^browser is closed$")
	public void browser_is_closed() throws Throwable {
		driver.quit();
	}

	@And("^Click on Account information and edit the information \"([^\"]*)\",\"([^\"]*)\" and save information$")
	public void click_on_account_information_and_edit_the_information_and_save_information(String firstname,
			String lastname) throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.clickAccountEdit();
		loginPage.enterFirstname(firstname);
		loginPage.enterLastname(lastname);
		loginPage.clickbtnSave();

	}

	@And("^Click on Add and Fill the billing details of the user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and Save$")
	public void click_on_add_and_fill_the_billing_details_of_the_user_and_save(String firstname, String lastname,
			String address1, String address2, String state, String city, String postalcode, String phonenumber)
			throws Throwable {
		if (driver.toString().contains("Add")) {

			loginPage.clickbillingAdd();
		} else {

			loginPage.clickbillingEdit();

		}

		Thread.sleep(1000);
		billingPage = new BillingPage(driver);
		billingPage.enterBillfirstname(firstname);
		billingPage.enterBilllastname(lastname);
		billingPage.enterBilladdr_1(address1);
		billingPage.enterBilladdr_2(address2);
		billingPage.drpBillState(state);
		billingPage.enterBillcity(city);
		billingPage.enterBillpostalcode(postalcode);
		billingPage.enterBillphonenumber(phonenumber + time);
		loginPage.clickbtnSave();

	}

	@And("^Click on Add and Fill the shipping details of the user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and Save$")
	public void click_on_add_and_fill_the_shipping_details_of_the_user_and_save(String firstname, String lastname,
			String address1, String address2, String state, String city, String postalcode, String phonenumber)
			throws Throwable {
		if (driver.toString().contains("Add")) {

			loginPage.clickshippingAdd();

		} else {

			loginPage.clickshippingEdit();

		}
		Thread.sleep(1000);
		billingPage.enterShippingfirstname(firstname);
		billingPage.enterShippinglastname(lastname);
		billingPage.enterShippingaddr_1(address1);
		billingPage.enterShippingaddr_2(address2);
		billingPage.drpShippingState(state);
		billingPage.enterShippingcity(city);
		billingPage.enterShippingpostalcode(postalcode);
		billingPage.enterShippingphonenumber(phonenumber + time);
		loginPage.clickbtnSave();

	}

}