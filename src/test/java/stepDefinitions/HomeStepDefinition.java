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

	@And("^Click on Shipping diffrent address checkbox$")
	public void click_on_shipping_diffrent_address_checkbox() {
		billingPage.clickShippingCheckbox();
	}

	@And("^Fill the shipping details of the  user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_the_shipping_details_of_the_user(String firstname, String lastname, String address1,
			String address2, String country, String state, String city, String postalcode, String phonenumber,
			String email) throws Throwable {
		Thread.sleep(1000);
		// billingPage = new BillingPage(driver);
		billingPage.enterShippingfirstname(firstname);
		billingPage.enterShippinglastname(lastname);
		billingPage.enterShippingaddr_1(address1);
		billingPage.enterShippingaddr_2(address2);
		billingPage.selectShippingCountry(country);
		billingPage.drpShippingState(state);
		billingPage.enterShippingcity(city);
		billingPage.enterShippingpostalcode(postalcode + secs);
		billingPage.enterShippingphonenumber(phonenumber + secs);
		billingPage.enterShippingemail(email + secs + secs + secs + "@mailinator.com");
		Thread.sleep(5000);
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

	/* HomePage Functional test */
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

	@And("^Scroll down and click on see all deals$")
	public void scroll_down_and_click_on_see_all_deals() {

	}

	@And("^Verify the deal page meesage$")
	public void verify_the_deal_page_meesage() {

	}

	@And("^Click back button of browser$")
	public void click_back_button_of_browser() {

	}

	@And("^Scroll down and  left and right arrow$")
	public void scroll_down_and_left_and_right_arrow() {

	}

	@And("^Scroll up and hover on categories \"([^\"]*)\"$")
	public void scroll_up_and_hover_on_categories_something(String category, String strArg1) {

	}

	@And("^Click on Sub Category \"([^\"]*)\"$")
	public void click_on_sub_category_something(String subcategory, String strArg1) {

	}

	@And("^Click on Show more on narrow choice$")
	public void click_on_show_more_on_narrow_choice() {

	}

	@And("^Click on Show less on narrow choice$")
	public void click_on_show_less_on_narrow_choice() {

	}

	@And("^Verify the radio button is enable and click on radio button$")
	public void verify_the_radio_button_is_enable_and_click_on_radio_button() {

	}

	@And("^Click on rating checkbox$")
	public void click_on_rating_checkbox() {

	}

	@And("^Scroll down and click on page number and next arrow$")
	public void scroll_down_and_click_on_page_number_and_next_arrow() {

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