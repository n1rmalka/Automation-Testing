/**
 * 
 */
package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import Automation.Base;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.BillingPage;
import pageObjects.CheckoutPage;
import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SigninPage;

public class SignInStepDefinition extends Base {

	String storetitle;
	String LostPassword;
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;
	SigninPage signinPage;
	ForgetPasswordPage forgetpasswordPage;

	public SignInStepDefinition() {

	}

	@And("^Click on Signin and verify the title$")
	public void click_on_signin_and_verify_the_title() {
		signinPage = new SigninPage(driver);
		signinPage.clickSigninLink();
		Assert.assertTrue(driver.getPageSource().contains("Returning Customer"));

	}

	@And("^Click submit and validate the message \"([^\"]*)\" \"([^\"]*)\"$")
	public void click_submit_and_validate_the_message(String Expectedresultuser, String ExpectedresultPassword)
			throws Throwable {
		signinPage.clickBtnSubmit();

		String actual_msg_loginuser = driver.findElement(By.xpath("//label[@id='loginusername-error']")).getText();
		String expect_msg_loginuser = Expectedresultuser;

		// Verify error message
		Assert.assertEquals(actual_msg_loginuser, expect_msg_loginuser);

		String actual_msg_loginpassword = driver.findElement(By.xpath("//label[@id='loginpassword-error']")).getText();
		String expect_msg_loginpassword = ExpectedresultPassword;
		Assert.assertEquals(actual_msg_loginpassword, expect_msg_loginpassword);

	}

	@And("^Click on Forgot your password link$")
	public void click_on_forgot_your_password_link() {
		signinPage.clickForgetPasswordLink();
	}

	@And("^Enter Email address \"([^\"]*)\" and click on submit button$")
	public void enter_email_address_and_click_on_submit_button(String email) {
		signinPage.enterEmail(email);
		signinPage.clickBtnSubmit();
	}

	@And("^Verify the lost password page title \"([^\"]*)\"$")
	public void verify_the_lost_password_page_title(String lostpassword) {
		LostPassword = driver.findElement(By.xpath("//span[@class='bx_can']")).getText();
		System.out.println(LostPassword);
		Assert.assertEquals(lostpassword, storetitle);
	}

	@And("^Click on Return to log in link$")
	public void click_on_return_to_log_in_link() {
		signinPage.clickRecoveryLink();

	}

	@And("^Click on Resend recovery link$")
	public void click_on_resend_recovery_link() {
		signinPage.clickResendRecoveryLink();
	}

	@And("^Open email and enter email address \"([^\"]*)\"$")
	public void open_email_and_enter_email_address_something(String email) throws Exception, InterruptedException {
		homePage = new HomePage(driver);
		homePage.clearbrowserhistory();
		forgetpasswordPage = new ForgetPasswordPage(driver);
		forgetpasswordPage.OpenMail(email);
	}

	@And("^Enter the \"([^\"]*)\" and the \"([^\"]*)\" and click on submit button$")
	public void enter_the_and_the_and_click_on_submit_button(String newpassword, String confirmpassword) {
		signinPage.enterNewPassword(newpassword);
		signinPage.enterConfirmPassword(confirmpassword);
		signinPage.clickBtnSubmit();
	}

	@And("^Enter \"([^\"]*)\", \"([^\"]*)\" and click on submit button$")
	public void enter_and_click_on_submit_button(String username, String password) {
		signinPage.enterUsername(username);
		signinPage.enterPassword(password);
		signinPage.clickBtnSubmit();

	}

}
