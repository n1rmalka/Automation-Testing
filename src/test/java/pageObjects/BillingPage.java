package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.CommonFunctions;

public class BillingPage {

	public WebDriver driver;
	private CommonFunctions oCommonFunctions;

	public BillingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();

	}

	@FindBy(xpath = "//*[@id='payment']/ul/li[1]")
	private static WebElement paymentsection;
	@FindBy(name = "cardnumber")
	private static WebElement stripenumber;
	// @FindBy(id = "stripe-exp-element")
	@FindBy(name = "exp-date")
	private static WebElement stripeexpdate;
	@FindBy(name = "cvc")
	private static WebElement stripecvc;
	/*--------------------Billing Locators----------------------*/

	@FindBy(xpath = "//input[contains(@id,'billing_first_name')]")
	private static WebElement Billfirstname;
	@FindBy(xpath = "//input[contains(@id,'billing_last_name')]")
	private static WebElement Billlastname;
	@FindBy(xpath = "//input[contains(@id,'billing_address_1')]")
	private static WebElement Billaddr1;
	@FindBy(xpath = "//input[contains(@id,'billing_address_2')]")
	private static WebElement Billaddr2;
	@FindBy(xpath = "//*[@id='billing_state']")
	public static WebElement txtbxBillState;
	@FindBy(xpath = "//*[@id='billing_state']")
	public static WebElement drpBillState;
	@FindBy(xpath = "//*[@id='billing_country']")
	public static WebElement drpBillCountry;
	@FindBy(xpath = "//input[contains(@id,'billing_city')]")
	private static WebElement Billcity;
	@FindBy(xpath = "//input[contains(@id,'billing_postcode')]")
	private static WebElement Billpostalcode;
	@FindBy(xpath = "//input[contains(@id,'billing_phone')]")
	private static WebElement Billphonenumber;
	@FindBy(xpath = "//input[contains(@id,'billing_email')]")
	private static WebElement Billemail;

	/*--------------------Shipping Locators----------------------*/
	@FindBy(xpath = "//input[contains(@id,'ship-to-different-address-checkbox')]")
	private static WebElement ShippingCheckbox;
	@FindBy(xpath = "//input[contains(@id,'shipping_first_name')]")
	private static WebElement Shippingfirstname;
	@FindBy(xpath = "//input[contains(@id,'shipping_last_name')]")
	private static WebElement Shippinglastname;
	@FindBy(xpath = "//input[contains(@id,'shipping_address_1')]")
	private static WebElement Shippingaddr1;
	@FindBy(xpath = "//input[contains(@id,'shipping_address_2')]")
	private static WebElement Shippingaddr2;
	@FindBy(xpath = "//*[@id='shipping_state']")
	public static WebElement txtbxShippingState;
	@FindBy(xpath = "//*[@id='shipping_state']")
	public static WebElement drpShippingtate;
	@FindBy(xpath = "//*[@id='shipping_country']")
	public static WebElement drpShippingCountry;
	@FindBy(xpath = "//input[contains(@id,'shipping_city')]")
	private static WebElement Shippingcity;
	@FindBy(xpath = "//input[contains(@id,'shipping_postcode')]")
	private static WebElement Shippingpostalcode;
	@FindBy(xpath = "//input[contains(@id,'shipping_phone')]")
	private static WebElement Shippingphonenumber;
	@FindBy(xpath = "//input[contains(@id,'shipping_email')]")
	private static WebElement Shippingemail;

	@FindBy(xpath = "//input[contains(@id,'terms')]")
	private static WebElement terms_ConditionCheckbox;
	@FindBy(xpath = "//button[contains(text(),'Place order')]")
	private static WebElement Placeorder;

	/*--------------------Billing Address Method----------------------*/
	public void enterBillfirstname(String firstname) {
		oCommonFunctions.sendKey(Billfirstname, firstname, 10);

	}

	public void enterBilllastname(String lastname) {
		oCommonFunctions.sendKey(Billlastname, lastname, 10);

	}

	public void enterBilladdr_1(String address1) {
		oCommonFunctions.sendKey(Billaddr1, address1, 10);

	}

	public void enterBilladdr_2(String address2) {
		oCommonFunctions.sendKey(Billaddr2, address2, 10);

	}

	public void selectBillCountry(String Country) {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.drp_select(drpBillCountry, Country, 5);
	}

	// public void enterBillState(String State) {
	// oCommonFunctions.sleepWait(2);
	// oCommonFunctions.sendKey(txtbxBillState, State, 5);
	// }

	public void drpBillState(String State) {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.drp_select(txtbxBillState, State, 5);
	}

	public void enterBillcity(String city) {
		oCommonFunctions.sendKey(Billcity, city, 10);

	}

	public void enterBillpostalcode(String postalcode) {
		oCommonFunctions.sendKey(Billpostalcode, postalcode, 10);

	}

	public void enterBillphonenumber(String phonenumber) {
		oCommonFunctions.sendKey(Billphonenumber, phonenumber, 10);

	}

	public void enterBillemail(String email) {
		oCommonFunctions.sendKey(Billemail, email, 10);

	}

	/*-----------------------Shipping Address Method---------------------*/

	public void clickShippingCheckbox() {
		oCommonFunctions.waitForElementvisible(ShippingCheckbox, 10);
		oCommonFunctions.clickElement(ShippingCheckbox, 5);
	}

	public void enterShippingfirstname(String firstname) {
		oCommonFunctions.sendKey(Shippingfirstname, firstname, 10);

	}

	public void enterShippinglastname(String lastname) {
		oCommonFunctions.sendKey(Shippinglastname, lastname, 10);

	}

	public void enterShippingaddr_1(String address1) {
		oCommonFunctions.sendKey(Shippingaddr1, address1, 10);

	}

	public void enterShippingaddr_2(String address2) {
		oCommonFunctions.sendKey(Shippingaddr2, address2, 10);

	}

	public void selectShippingCountry(String Country) {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.drp_select(drpShippingCountry, Country, 5);
	}

	// public void enterShippingState(String State) {
	// oCommonFunctions.sleepWait(2);
	// oCommonFunctions.sendKey(txtbxShippingState, State, 5);
	// }

	public void drpShippingState(String State) {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.drp_select(txtbxShippingState, State, 5);
	}

	public void enterShippingcity(String city) {
		oCommonFunctions.sendKey(Shippingcity, city, 10);

	}

	public void enterShippingpostalcode(String postalcode) {
		oCommonFunctions.sendKey(Shippingpostalcode, postalcode, 10);

	}

	public void enterShippingphonenumber(String phonenumber) {
		oCommonFunctions.sendKey(Shippingphonenumber, phonenumber, 10);

	}

	public void enterShippingemail(String email) {
		oCommonFunctions.sendKey(Shippingemail, email, 10);

	}

	public void enterCardnumber(String cardnumber) {
		oCommonFunctions.scrollToElement(stripenumber, 2);
		oCommonFunctions.waitForElementvisible(paymentsection, 10);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='stripe-card-element']/div/iframe")));
		oCommonFunctions.sendKey(stripenumber, cardnumber, 10);
		driver.switchTo().defaultContent();
	}

	public void enterCardExpDate(String cardexpdate) {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"stripe-exp-element\"]/div/iframe")));
		oCommonFunctions.sendKey(stripeexpdate, cardexpdate, 10);
		driver.switchTo().defaultContent();
	}

	public void enterCardCVC(String cardcvc) {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"stripe-cvc-element\"]/div/iframe")));
		oCommonFunctions.sendKey(stripecvc, cardcvc, 10);
		driver.switchTo().defaultContent();
	}

	public void clickTerms_ConditionCheckbox() {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'terms')]")));
		oCommonFunctions.waitForElementvisible(terms_ConditionCheckbox, 10);
		oCommonFunctions.clickElement(terms_ConditionCheckbox, 5);
	}

	public void clickPlaceorderbutton() {
		oCommonFunctions.clickElement(Placeorder, 5);
	}

}
