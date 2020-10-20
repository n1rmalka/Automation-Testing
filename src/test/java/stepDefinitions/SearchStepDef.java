package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.Base;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class SearchStepDef extends Base {

	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	public String time = new SimpleDateFormat("HHmmss").format(new Date());

	@And("^search product \"([^\"]*)\" and click on search product$")
	public void search_product_and_click_on_search_product(String searchtext) throws Throwable {
		homePage = new HomePage(driver);
		homePage.searchproduct(searchtext);
		homePage.clicksearchproductbtn();

	}

	@And("^Click on Add to Cart$")
	public void click_on_add_to_cart() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickSearchAddToCart();
	}

	@And("^Click on Quick view$")
	public void click_on_quick_view() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickQuickLink();
		Thread.sleep(2000);
	}

	@And("^Click on plus button and click on add to cart$")
	public void click_on_plus_button_and_click_on_add_to_cart() throws Throwable {
		homePage.clickplusicon();
		homePage.clickbtnAddtocart();
		Thread.sleep(2000);
	}

	@And("^Enter coupon code \"([^\"]*)\" and click on apply coupn button$")
	public void enter_coupon_code_and_click_on_apply_coupn_button(String coupon) throws Throwable {
		Thread.sleep(2000);
		homePage = new HomePage(driver);
		homePage.enterCouponcode(coupon);
		homePage.clickbtnApplycoupon();
		Thread.sleep(2000);
		// Assert.assertTrue(driver.getPageSource().contains("Coupon code
		// applied successfully"));
	}

	@And("^Enter count \"([^\"]*)\"$")
	public void enter_count_something(String qty) throws Throwable {
		Thread.sleep(2000);
		homePage.enterQty(qty);
		// homePage.clickbtnQtyUpdate();

	}

	@And("^Click on Change address and enter new local address \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void click_on_change_address_and_enter_new_local_address(String Country, String State, String city,
			String postalcode) throws Throwable {

		homePage.clicklabelCalShippping();
		// homePage.selectShippingCountry(Country);
		// homePage.selectShippingState(State);
		// homePage.entercalcshippingcity(city);
		homePage.entercalcshippingpostcode(postalcode);
		Thread.sleep(1000);
		homePage.clickbtnCalShipppingUpdate();
	}

	@And("^click on Proceed to checkout button$")
	public void click_on_proceed_to_checkout_button() throws Throwable {
		homePage.clickbtnProceedcheckout();
	}

}
