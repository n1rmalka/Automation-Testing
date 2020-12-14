package stepDefinitions;

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

public class HomeStepDefinition extends Base {

	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;
	public String time = new SimpleDateFormat("HHmmss").format(new Date());
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
	String Email;
	String TrackId;
	String billingemail;
	String trackingmessage;

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
		Thread.sleep(5000);
		if (driver.getPageSource().contains("Sign Up Now")) {
			homePage.clicktoclosepopup();
			// driver.findElement(By.xpath("//div[contains(text(),'No,
			// thanks')]")).click();
			// driver.findElement(By.xpath("(//input[contains(@name,'email')])"))
			// .sendKeys("northsee" + time + "@yopmail.com");
			// driver.findElement(By.xpath("(//span[contains(text(),'S')])[21]")).click();
			// //Assert.assertTrue(driver.getPageSource().contains("Congratulation"));
			// driver.findElement(By.xpath("//body/div[@id='vi-md_wcb']/div[1]/span[1]")).click();

		} else {

			Thread.sleep(3000);
		}

	}

	@When("^User adds a product to cart$")
	public void user_adds_a_product_to_cart() throws Throwable {
		homePage = new HomePage(driver);
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

	@And("^Fill the billing details of the  user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_the_billing_details_of_the_user(String firstname, String lastname, String address1,
			String address2, String state, String city, String postalcode, String phonenumber, String email)
			throws Throwable {

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
		billingemail = (email + time + "@mailinator.com");
		System.out.println("Billing Email is :" + billingemail);
		billingPage.enterBillemail(billingemail);

		Thread.sleep(5000);

	}

	@And("^User entering new password \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_entering_new_password(String password, String confirmpasword) throws Throwable {
		billingPage.enternewpassword(password);
		// driver.findElement(By.xpath(""));
	}

	@And("^Click on Shipping diffrent address checkbox$")
	public void click_on_shipping_diffrent_address_checkbox() {
		billingPage.clickShippingCheckbox();
	}

	@And("^Fill the shipping details of the  user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_the_shipping_details_of_the_user(String firstname, String lastname, String address1,
			String address2, String state, String city, String postalcode, String phonenumber, String email)
			throws Throwable {
		Thread.sleep(1000);
		// billingPage = new BillingPage(driver);
		billingPage.enterShippingfirstname(firstname);
		billingPage.enterShippinglastname(lastname);
		billingPage.enterShippingaddr_1(address1);
		billingPage.enterShippingaddr_2(address2);
		billingPage.drpShippingState(state);
		billingPage.enterShippingcity(city);
		billingPage.enterShippingpostalcode(postalcode);
		billingPage.enterShippingphonenumber(phonenumber + time);
		String shippingemail = (email + time + "@mailinator.com");
		System.out.println("Shipping Email is :" + shippingemail);
		billingPage.enterShippingemail(shippingemail);
		Thread.sleep(5000);
	}

	@And("^User enter credit card details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enter_credit_card_details(String cardnumber, String cardexpdate, String cardcvc) throws Throwable {

		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,250)");
		// jse.executeScript("window.scrollBy(0,250)");
		billingPage.enterCardnumber(cardnumber);
		billingPage.enterCardExpDate(cardexpdate);
		billingPage.enterCardCVC(cardcvc);
	}

	@And("^User click on website terms and conditions$")
	public void user_click_on_website_terms_and_conditions() throws Throwable {

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

	@And("^Verify the Total amount$")
	public void verify_the_total_amount() throws Throwable {
		totalamount = driver.findElement(By.xpath("//th[contains(text(),'Total')]//following::span[1]")).getText();
		Assert.assertEquals(totalamount, totalamount);
		System.out.println(totalamount);
		Assert.assertTrue(driver.getPageSource().contains("Thank you."));
		Thread.sleep(5000);
		if (driver.getPageSource().contains("Invite friends. Get 20% off all products")) {
			driver.findElement(By.xpath("//*[@class='closeLollipopFrameJS text__small popup__link']")).click();

		}
		TrackId = driver.findElement(By.xpath("(//li[contains(text(),'Order number')]//following::strong)[1]"))
				.getText();
		Thread.sleep(3000);
	}

	@And("^Track the order$")
	public void track_the_order() throws Throwable {
		homePage.ClickBtnTrackOrder();
	}

	@And("^Enter track details$")
	public void enter_track_details() throws Throwable {
		homePage.EnterOrderDetails(TrackId, billingemail);
		homePage.ClickBtnTrack();
		trackingmessage = driver.findElement(By.xpath("//div[@class='track_fail_msg']")).getText();
		System.out.println(trackingmessage);
		Assert.assertEquals("Tracking details not found.", "Tracking details not found.");

	}

	/* HomePage Functional test */

	@And("^Scroll down and click on see all deals$")
	public void scroll_down_and_click_on_see_all_deals() {
		homePage = new HomePage(driver);
		homePage.ClickSeeAllDeals();

	}

	@And("^Verify the deal page meesage$")
	public void verify_the_deal_page_meesage() {
		Assert.assertTrue(driver.getPageSource().contains("No products were found matching your selection"));
	}

	@And("^Click back button of browser$")
	public void click_back_button_of_browser() {
		driver.navigate().back();
	}

	@And("^Swtich to Night View$")
	    public void swtich_to_night_view() throws Throwable {
	        driver.findElement(By.xpath("(//*[contains(@class,'toggle')])[1]")).click();
	    }

	@And("^Scroll down and left and right arrow$")
	public void scroll_down_and_left_and_right_arrow() throws Throwable {
		Thread.sleep(2000);
		homePage.ClickRightArrow();
		Thread.sleep(2000);
		homePage.ClickLeftArrow();
		Thread.sleep(2000);
	}

	@And("^Scroll up and click on categories \"([^\"]*)\"$")
	public void scroll_up_and_click_on_categories(String category) throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[contains(@class,'dropdown-toggle')and contains(text(),'" + category + "')])"))
				.click();
		Thread.sleep(2000);
	}

	@And("^Click on Sub Category \"([^\"]*)\"$")
	public void click_on_sub_category(String subcategory) throws Exception {
		driver.findElement(
				By.xpath("(//*[contains(@class,'woof_radio_label')and contains(text(),'" + subcategory + "')])"))
				.click();
		Thread.sleep(3000);
	}

	@And("^Click on price radio button$")
	public void click_on_price_radio_button() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("(//*[contains(@name,'woof_price_radio')])"));
		Boolean is_selected = list.get(0).isSelected();

		if (is_selected == true) {
			list.get(1).click();

		} else {
			list.get(0).click();
		}
	}

	@And("^Click on Show more on narrow choice$")
	public void click_on_show_more_on_narrow_choice() throws Throwable {
		homePage.ClickShowMore();
		Thread.sleep(2000);
	}

	@And("^Click on Show less on narrow choice$")
	public void click_on_show_less_on_narrow_choice() throws Throwable {
		homePage.ClickShowLess();
		Thread.sleep(2000);
	}

	@And("^Click on rating checkbox$")
	public void click_on_rating_checkbox() throws Throwable {
		homePage.ClickRadioBtnFiveStar();
		Thread.sleep(2000);
	}

	@When("^finds the broken links for (.+)$")
	public void finds_the_broken_links_for(String url) throws Throwable {
		if (homePage == null) {
			homePage = new HomePage(driver);
		}
		homePage.verifyLink(url);
	}

}