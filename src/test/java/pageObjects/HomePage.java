package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.event.ObjectChangeListener;
import javax.swing.plaf.metal.OceanTheme;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Automation.Base;
import Automation.CommonFunctions;

public class HomePage extends Base {

	public WebDriver driver;
	public CommonFunctions oCommonFunctions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();

	}

	@FindBys({ @FindBy(xpath = "//div[text()='Copied the invitation link!']") })
	public static List<WebElement> toastNotificationMessage;
	@FindBy(xpath = "(//a[contains(@id,'w3s_')])[1]")
	// a[contains(text(),'Add to cart')][1]
	public static WebElement addToCartLink;
	@FindBy(xpath = "//button[@name='add-to-cart']")
	public static WebElement btnaddToCart;
	@FindBy(xpath = "//div[contains(text(),'No, thanks')]")
	public static WebElement sgboxclose;
	@FindBy(xpath = "//input[@id='term_pop']")
	public static WebElement termsCheckbox;
	@FindBy(xpath = "//a[contains(@href,'/checkout') and contains(@class,'my_cjecked')]")
	public static WebElement proceedToCheckoutButton;
	@FindBys({ @FindBy(xpath = "//img[contains(@src,'https://www.40plusmart.com/wp-content/uploads/')]") })
	public List<WebElement> supplementsLink;
	@FindBy(xpath = "//img[contains(@src,'/wp-content/uploads/')]")
	public static WebElement supplements_5HTPLink;
	@FindBys({ @FindBy(xpath = "//h2[text()='Added to cart successfully!']") })
	public List<WebElement> addedToCartConfirmationMessageText;
	@FindBy(xpath = "//h2[contains(text(),'Best Selling')]")
	public static WebElement bestsellingLabel;
	@FindBy(xpath = "//body/div[@id='main-content']/article[@id='post-5']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
	public static WebElement productImage;
	@FindBy(xpath = "//span[@class='et_shop_image']//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")
	public static WebElement productimage2;
	@FindBy(xpath = "(//*[contains(text(),'Quick View')])")
	public static WebElement QuickViewLink;
	@FindBy(xpath = "(//*[contains(text(),'Quick View')])[2]")
	public static WebElement QuickViewLink2;
	@FindBy(xpath = "(//a[@class='first_add_btn'][contains(@href,'/cart/?add-to-cart')])[1]")
	public static WebElement BtnSearchAddtocart;
	@FindBy(xpath = "//span[contains(@class,'popupbutton num_thr')]")
	public static WebElement PlusIcon;
	@FindBy(xpath = "//*[@id='search_my']")
	public static WebElement SearchTextBox;
	@FindBy(xpath = "//*[@id='searchsubmit_header']")
	public static WebElement BtnSerach;
	@FindBy(xpath = "//input[@id='coupon_code']")
	public static WebElement txtbxcouponcode;
	@FindBy(xpath = "//button[@name='apply_coupon']")
	public static WebElement btnapplycoupon;
	@FindBy(xpath = "//*[contains(@id,'quantity')]")
	public static WebElement txtbxqty;
	@FindBy(xpath = "//*[@name='update_cart']")
	public static WebElement btnqtyupdate;
	@FindBy(xpath = "//*[@class='shipping-calculator-button']")
	public static WebElement btnchangeaddr;
	@FindBy(xpath = "//*[@id='calc_shipping_city']")
	public static WebElement txtbxcity;
	@FindBy(xpath = "//*[@id='calc_shipping_postcode']")
	public static WebElement txtbxpostalcode;
	@FindBy(xpath = "//*[@name='calc_shipping']")
	public static WebElement btnshippingupdate;
	@FindBy(xpath = "(//a[contains(@href,'checkout/') and contains(text(),'roceed to checkout')])")
	public static WebElement btnproceedtocheckout;
	@FindBy(xpath = "//a[@class='shipping-calculator-button']")
	public static WebElement labelChangeAddress;
	@FindBy(xpath = "//*[@id='calc_shipping_state']")
	public static WebElement drpshipState;
	@FindBy(xpath = "//*[@id='calc_shipping_country']")
	public static WebElement drpshipCountry;
	@FindBy(xpath = "//*[@id='calc_shipping_country']")
	public static WebElement labelSubCat;

	// HomePage locators functional links and icons

	@FindBy(xpath = "//div[@class='deal-section']//a[contains(text(),'See All Deals')]")
	public static WebElement labelseeAlldeals;
	@FindBy(xpath = "//div[contains(@class,'owl-next')])[2]")
	public static WebElement NextArrow;
	@FindBy(xpath = "(//div[contains(@class,'owl-prev')])[2]")
	public static WebElement PrevArrow;
	@FindBy(xpath = "(//a[@class='woof_open_hidden_li_btn'][contains(text(),'Show more')])[1]")
	public static WebElement LabelShowMore;
	@FindBy(xpath = "(//a[@class='woof_open_hidden_li_btn'][contains(text(),'Show less')])[1]")
	public static WebElement LabelShowLess;
	@FindBy(xpath = "//li[1]//label[1]//span[1]//label[1]")
	public static WebElement rdbtnFiveStar;

	/* TrackOrder */
	@FindBy(xpath = "(//a[contains(text(),'Track Order')])[1]")
	public static WebElement trackorder;
	@FindBy(xpath = "//input[@id='order_id']")
	public static WebElement Order_ID;
	@FindBy(xpath = "//input[@id='order_email']")
	public static WebElement Order_Email;
	@FindBy(xpath = "//button[contains(text(),'Track')]")
	public static WebElement btnTrack;

	/* Actions */
	public Actions act;

	public void clearbrowserhistory() {
		driver.get("chrome://settings/clearBrowserData?search=cache");
		// WebElement cleardata =
		// driver.findElement(By.xpath("//*[name()='settings-ui']"));
		// cleardata.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@id='clear-now']")).click();
	}

	public void clickAddToCartLink() throws InterruptedException {

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,250)");
		// js.executeScript("window.scrollBy(0,250)");
		oCommonFunctions.scrollToElement(bestsellingLabel, 5);
		act = new Actions(driver);
		// act.moveToElement(supplementsLink.get(0)).build().perform();
		// Thread.sleep(2000);
		// oCommonFunctions.clickElement(supplements_5HTPLink, 10);
		act.moveToElement(productImage).build().perform();
		oCommonFunctions.clickElement(addToCartLink, 10);
		// Thread.sleep(2000);
	}

	public void clickTermsCheckbox() {
		oCommonFunctions.clickElement(termsCheckbox, 5);
	}

	public void clicktoclosepopup() {

		// oCommonFunctions.waitForElementvisible(sgboxclose, 10);
		oCommonFunctions.clickElement(sgboxclose, 10);

		System.out.println(" no discount pop-up is displayed ");

	}

	public void clickChekoutButton() {
		// oCommonFunctions.scrollToElement(proceedToCheckoutButton, 10);
		if (proceedToCheckoutButton.isEnabled()) {
			oCommonFunctions.clickElement(proceedToCheckoutButton, 10);
		} else {
			System.out.println("button is disable, please checked I agree with terms and condtions");
		}
	}

	public void verifyProductAddedToCart() {
		String itemtext = driver.findElement(By.xpath("//h1[@class='product_title entry-title']")).getText();
		System.out.println(itemtext);
		Assert.assertTrue(addedToCartConfirmationMessageText.size() > 0);
	}

	public void navigateToHomePage() {
		driver.get("https://plusmartstage.wpengine.com/");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void searchproduct(String searchtext) {
		oCommonFunctions.clickElement(SearchTextBox, 3);
		oCommonFunctions.sendKey(SearchTextBox, searchtext, 10);

	}

	public void clicksearchproductbtn() {
		oCommonFunctions.clickElement(BtnSerach, 5);
		oCommonFunctions.sleepWait(5);
	}

	public void clickQuickLink() throws InterruptedException {

		act = new Actions(driver);
		act.moveToElement(productimage2).build().perform();
		if (productimage2.isDisplayed()) {
			oCommonFunctions.clickElement(QuickViewLink, 5);
		} else {
			oCommonFunctions.clickElement(QuickViewLink2, 5);
		}

		Thread.sleep(2000);
	}

	public void clickSearchAddToCart() throws InterruptedException {

		act = new Actions(driver);
		act.moveToElement(productimage2).build().perform();
		if (productimage2.isDisplayed()) {
			oCommonFunctions.sleepWait(5);
			oCommonFunctions.clickElement(BtnSearchAddtocart, 10);
		} else {
			oCommonFunctions.clickElement(QuickViewLink2, 10);
		}

		Thread.sleep(2000);
	}

	public void clickplusicon() throws InterruptedException {

		// act = new Actions(driver);
		// act.moveToElement(PlusIcon).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 1; i++) {
			oCommonFunctions.clickElement(PlusIcon, 5);
		}
	}

	public void clickbtnAddtocart() throws InterruptedException {

		oCommonFunctions.clickElement(btnaddToCart, 5);
	}

	public void enterCouponcode(String coupon) {
		oCommonFunctions.sendKey(txtbxcouponcode, coupon, 10);
	}

	public void clickbtnApplycoupon() {
		oCommonFunctions.clickElement(btnapplycoupon, 10);
	}

	public void enterQty(String qty) throws InterruptedException {
		act = new Actions(driver);
		act.moveToElement(txtbxqty).build().perform();
		Thread.sleep(2000);
		oCommonFunctions.clickElement(txtbxqty, 5);
	}

	public void clicklabelCalShippping() {
		oCommonFunctions.clickElement(labelChangeAddress, 10);
	}

	public void entercalcshippingcity(String city) {
		oCommonFunctions.sendKey(txtbxcity, city, 5);
	}

	public void entercalcshippingpostcode(String postcode) {
		oCommonFunctions.sendKey(txtbxpostalcode, postcode, 5);
	}

	public void selectShippingCountry(String Country) {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.drp_select(drpshipCountry, Country, 5);
	}

	public void selectShippingState(String State) {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.drp_select(drpshipState, State, 5);
	}

	public void clickbtnCalShipppingUpdate() {
		oCommonFunctions.clickElement(btnshippingupdate, 5);
	}

	public void clickbtnProceedcheckout() {
		oCommonFunctions.sleepWait(3);
		oCommonFunctions.clickElement(btnproceedtocheckout, 5);
	}

	public void hoverCategory() {

	}

	public void hoverSubCategory() throws Throwable {
		Thread.sleep(1000);
		for (int i = 0; i < 1; i++) {
			oCommonFunctions.clickElement(PlusIcon, 5);
			Thread.sleep(2000);
		}
	}

	/* Homescreenmethods */

	public void ClickSeeAllDeals() {
		oCommonFunctions.clickElement(labelseeAlldeals, 10);

	}

	public void ClickLeftArrow() {
		oCommonFunctions.scrollToElement(PrevArrow, 10);
		oCommonFunctions.clickElement(PrevArrow, 10);

	}

	public void ClickRightArrow() {
		oCommonFunctions.clickElement(NextArrow, 10);

	}

	public void ClickShowMore() {
		oCommonFunctions.scrollToElement(LabelShowMore, 10);
		oCommonFunctions.clickElement(LabelShowMore, 10);

	}

	public void ClickShowLess() {
		oCommonFunctions.clickElement(LabelShowLess, 10);

	}

	public void ClickRadioBtnFiveStar() {
		oCommonFunctions.clickElement(rdbtnFiveStar, 10);

	}

	/* TrackOrder */
	public void ClickBtnTrackOrder() {
		oCommonFunctions.clickElement(trackorder, 10);

	}

	public void EnterOrderDetails(String id, String email) {
		oCommonFunctions.sendKey(Order_ID, id, 5);
		oCommonFunctions.sendKey(Order_Email, email, 5);

	}

	public void ClickBtnTrack() {
		oCommonFunctions.clickElement(btnTrack, 5);

	}

	/* Verify the URL */
	public static void verifyLink(String urlLink) {

		try {

			URL link = new URL(urlLink);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
