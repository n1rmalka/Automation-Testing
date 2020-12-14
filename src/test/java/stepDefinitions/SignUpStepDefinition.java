/**
 * 
 */
package stepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Automation.Base;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.BillingPage;
import pageObjects.CheckoutPage;
import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SigninPage;
import pageObjects.SignupPage;

public class SignUpStepDefinition extends Base {

	String storetitle;
	String LostPassword;
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;
	SigninPage signinPage;
	SignupPage signupPage;
	ForgetPasswordPage forgetpasswordPage;
	public String time = new SimpleDateFormat("HHmmss").format(new Date());
	public String secs = new SimpleDateFormat("SSS").format(new Date());
	String storeEmail;
	public Actions act;

	public SignUpStepDefinition() {

	}

	@And("^User Click on Signup button$")
	public void user_click_on_signup_button() throws Throwable {

		driver.findElement(By.xpath("//button[@name='register']")).click();
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}

	@And("^User click on Create Account button and verify the messages \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_click_on_create_account_button_and_verify_the_messages(String firstname, String lastname,
			String email, String password, String confirmpassword, String agreeterms) throws Throwable {
		driver.findElement(By.xpath("//input[@id='CreateAccount']")).click();
		

		String actual_msg_fname = driver.findElement(By.xpath("//label[@id='username-error']")).getText();
		String expect_msg_fname = firstname;

		// Verify error message
		Assert.assertEquals(actual_msg_fname, expect_msg_fname);

		String actual_msg_loginpassword = driver.findElement(By.xpath("//label[@id='loginpassword-error']")).getText();
		String expect_msg_loginpassword = ExpectedresultPassword;
		Assert.assertEquals(actual_msg_loginpassword, expect_msg_loginpassword);
	}

	@And("^User enters Create an Account details \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters_create_an_account_details(String username, String mobilenumber, String email,
			String password, String conpassword) throws Throwable {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username + secs);
		// driver.findElement(By.xpath("//input[@id='phonenumber1']")).sendKeys(mobilenumber
		// + time);
		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys(email + time + "@mailinator.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='retypepassword']")).sendKeys(conpassword);

	}

	@And("^User click on receive exclusive Marketing Offers by email checkbox$")
	public void user_click_on_receive_exclusive_marketing_offers_by_email_checkbox() throws Throwable {

		driver.findElement(By.xpath("//input[@name='messageCheck']")).click();

	}

	@And("^User click on agree to Terms of Use checkbox$")
	public void user_click_on_agree_to_terms_of_use_checkbox() throws Throwable {
		driver.findElement(By.xpath("//input[@name='termsCheck']")).click();
	}

	@And("^User click on Create Account button and Verify the message$")
	public void user_click_on_Create_Account_button_and_Verify_the_message() throws Throwable {
		driver.findElement(By.xpath("//input[@id='CreateAccount']")).click();
		Assert.assertTrue(driver.getPageSource().contains("Registration is Successfully!"));
		act = new Actions(driver);
		WebElement myaccount = driver.findElement(By.xpath("//a[@id='my_acc_b']"));
		act.moveToElement(myaccount).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Your Account')]")).click();
		Thread.sleep(2000);
		storeEmail = driver.findElement(By.xpath("//*[@id='edit_account1']/div[2]/span")).getText();
		System.out.println("Email id is : " + storeEmail);
	}

	@And("^User Verify the email from mail link and login into application \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_verify_the_email_from_mail_link_and_login_into_application(String email, String password)
			throws Throwable {
		driver.get("https://www.mailinator.com");
		driver.findElement(By.xpath("//*[contains(@placeholder,'Public Mailinator Inbox')]")).sendKeys(storeEmail);
		driver.findElement(By.xpath("//button[contains(text(),'G')]")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("(//a[contains(text(),'lusmart')])")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		jse.executeScript("window.scrollBy(0,250)");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='msg_body']")));
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[contains(text(),'verifyEmail')]")));
		Thread.sleep(5000);
		signinPage = new SigninPage(driver);
		signinPage.enterUsername(storetitle);
		signinPage.enterPassword(password);
		signinPage.clickBtnSubmit();
		// Assert.assertTrue(driver.getPageSource().contains("MY DASHBOARD"));

	}
}
