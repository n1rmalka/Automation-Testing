/**
 * 
 */
package stepDefinitions;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import Automation.Base;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.BillingPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SigninPage;

@RunWith(Cucumber.class)
public class SignInStepDefinition extends Base {

	/**
	 * 
	 */
	String storetitle;
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;
	SigninPage signinPage;

	public SignInStepDefinition() {
		// TODO Auto-generated constructor stub
	}

	@And("^Click on Signin and verify the title \"([^\"]*)\"$")
	public void click_on_signin_and_verify_the_title(String title) {
		signinPage = new SigninPage(driver);
		signinPage.clickSigninLink();
		storetitle = driver.findElement(By.xpath("//*[@id='LoginForm']/p[1]")).getText();
		System.out.println(storetitle);
		Assert.assertEquals(title, storetitle);

	}

	@And("^Click on Forgot your password link$")
	public void click_on_forgot_your_password_link() {

	}

	@And("^Enter Email address \"([^\"]*)\" and click on submit button$")
	public void enter_email_address_something_and_click_on_submit_button(String email, String strArg1) {

	}

	@And("^Verify the lost password page title$")
	public void verify_the_lost_password_page_title() {

	}

	@And("^Click on Return to log in link$")
	public void click_on_return_to_log_in_link() {

	}

	@And("^Click on Resend recovery link$")
	public void click_on_resend_recovery_link() {

	}

	@And("^Open email and enter email address \"([^\"]*)\"$")
	public void open_email_and_enter_email_address_something(String email, String strArg1) {

	}

	@And("^click on reset password link$")
	public void click_on_reset_password_link() {

	}

	@And("^Enter \"([^\"]*)\" and \"([^\"]*)\" and click on submit button$")
	public void enter_something_and_something_and_click_on_submit_button(String newpassword, String confirmpassword,
			String strArg1, String strArg2) {

	}

	@And("^Enter \"([^\"]*)\", \"([^\"]*)\" and click on submit button$")
	public void enter_something_something_and_click_on_submit_button(String username, String password, String strArg1,
			String strArg2) {

	}

}
