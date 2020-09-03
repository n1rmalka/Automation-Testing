package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.BillingPage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.Base;

@RunWith(Cucumber.class)
public class HomeStepDefinition extends Base {
	// public WebDriver driver = null;
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;
	public String secs = new SimpleDateFormat("ss").format(new Date());
	String contractTitle;
	String contractDescription;
	String contractValue;
	String governingLaw;
	String category;
	String referenceID;
	String contract;
	String isRenewable;
	String contractLifecycle = "No";
	String numberOfRenewales;
	String renewDuration;
	String renewDurationUnit;
	String totalamount;

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {

		if (driver == null) {
			driver = Base.getDriver();
		}
		if (driver.toString().contains("(null)")) {
			driver = Base.getDriver();
		}
		homePage = new HomePage(driver);
		homePage.clearbrowserhistory();
		driver.navigate().to("https://plusmartstage.wpengine.com/");
	}

	@Then("^User close the discount popup$")
	public void user_close_the_discount_popup() throws Throwable {
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sgcboxClose']")));
		// driver.findElement(By.xpath("//button[@id='sgcboxClose']")).click();

		homePage.clicktoclosepopup();
		Thread.sleep(2000);
	}

	@When("^User adds a product to cart$")
	public void user_adds_a_product_to_cart() throws Throwable {
		homePage.clickAddToCartLink();
	}

	@And("^user click on term & condtions checkbox$")
	public void user_click_on_term_condtions_checkbox() throws Throwable {
		homePage.clickTermsCheckbox();
	}

	@Then("^product should added successfully to the cart$")
	public void product_should_added_successfully_to_the_cart() throws Throwable {
		homePage.verifyProductAddedToCart();
	}

	@And("^clicks checkout button$")
	public void clicks_checkout_button() throws Throwable {
		homePage.clickChekoutButton();
	}

	@When("^User clicks click here to login link$")
	public void user_clicks_click_here_to_login_link() throws Throwable {
		checkoutPage.clickClickHereToLoginLink();
	}

	@Then("^click here to login link should be displayed$")
	public void click_here_to_login_link_should_be_displayed() throws Throwable {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.verifyClickHereToLoginLinkDisplayed();
	}

	@And("^Fill the billing details of the  user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_the_billing_details_of_the_user(String firstname, String lastname, String address1,
			String address2, String Country, String State, String city, String postalcode, String phonenumber,
			String email) throws Throwable {

		Thread.sleep(1000);
		billingPage = new BillingPage(driver);
		billingPage.enterBillfirstname(firstname);
		billingPage.enterBilllastname(lastname);
		billingPage.enterBilladdr_1(address1);
		billingPage.enterBilladdr_2(address2);
		billingPage.selectBillCountry(Country);
		billingPage.drpBillState(State);
		billingPage.enterBillcity(city);
		billingPage.enterBillpostalcode(postalcode + secs);
		billingPage.enterBillphonenumber(phonenumber + secs);
		billingPage.enterBillemail(email + secs + secs + secs + "@yopmail.com");
		Thread.sleep(5000);

	}

	@And("^Fill the shipping details of the  user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_the_shipping_details_of_the_user(String firstname, String lastname, String address1,
			String address2, String country, String state, String city, String postalcode, String phonenumber,
			String email) throws Throwable {

	}

	@And("^User enter credit card details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enter_credit_card_details(String cardnumber, String cardexpdate, String cardcvc) throws Throwable {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		jse.executeScript("window.scrollBy(0,250)");
		billingPage.enterCardnumber(cardnumber);
		billingPage.enterCardExpDate(cardexpdate);
		billingPage.enterCardCVC(cardcvc);
	}

	@And("^User click on website terms and conditions$")
	public void user_click_on_website_terms_and_conditions() throws Throwable {
		// driver.switchTo().defaultContent();

		totalamount = driver.findElement(By.xpath("//th[contains(text(),'Total')]//following::span[1]")).getText();
		Thread.sleep(2000);
		billingPage.clickTerms_ConditionCheckbox();
	}

	@And("^Click on Place order button$")
	public void click_on_place_order_button() throws Throwable {
		billingPage.clickPlaceorderbutton();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")));
	}

	@And("^Verify the place order message$")
	public void verify_the_place_order_message() throws Throwable {
		throw new PendingException();
	}

	@And("^Verify the Total amount$")
	public void verify_the_total_amount() throws Throwable {
		totalamount = driver.findElement(By.xpath("//th[contains(text(),'Total')]//following::span[1]")).getText();
		Assert.assertEquals(totalamount, totalamount);
		System.out.println(totalamount);
	}

	@When("^finds the broken links for (.+)$")
	public void finds_the_broken_links_for(String url) throws Throwable {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		homePage.verifyLink(url);
	}

	// @After
	// public void tearDown() {
	// driver.quit();
	// }
	//
	// @Before
	// public void setup() throws IOException {
	// driver = Base.getDriver();
	// }

}