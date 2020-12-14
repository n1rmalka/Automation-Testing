package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.CommonFunctions;

public class LoginPage {

	public WebDriver driver;
	private CommonFunctions oCommonFunctions;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();

	}

	@FindBy(name = "username")
	private static WebElement emailTextBox;
	@FindBy(xpath = "//input[@type='password']")
	private static WebElement passwordTextBox;
	@FindBy(xpath = "//input[@value='Login']")
	private static WebElement loginButton;
	@FindBy(xpath = "//a[contains(@href,'/customer-logout/')]")
	private static WebElement logoutButton;
	@FindBy(xpath = "//a[@class='my_extra new_form123 first_form']")
	private static WebElement labelAccountEdit;
	@FindBy(xpath = "//input[@id='account_first_name']")
	private static WebElement firstnameTextBox;
	@FindBy(xpath = "//input[@id='account_last_name']")
	private static WebElement lastnameTextBox;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private static WebElement btnSave;

	@FindBy(xpath = "(//a[contains(@href,'edit-address/billing/') and contains(text(),'Add')])")
	private static WebElement labelBillingAdd;
	@FindBy(xpath = "(//a[contains(@href,'edit-address/billing/') and contains(text(),'Edit')])")
	private static WebElement labelBillingEdit;

	@FindBy(xpath = "(//a[contains(@href,'/edit-address/shipping/') and contains(text(),'Add')])")
	private static WebElement labelShippingAdd;
	@FindBy(xpath = "(//a[contains(@href,'/edit-address/shipping/') and contains(text(),'Edit')])")
	private static WebElement labelShippingEdit;

	public void enterEmailAddress(String email) {
		oCommonFunctions.sendKey(emailTextBox, email, 10);
	}

	public void enterPassword(String password) {
		oCommonFunctions.sendKey(passwordTextBox, password, 10);
	}

	public void clickAccountEdit() {
		oCommonFunctions.clickElement(labelAccountEdit, 10);
	}

	public void clickLogin() {
		oCommonFunctions.clickElement(loginButton, 10);
	}

	public void clickbtnSave() {
		oCommonFunctions.clickElement(btnSave, 10);
	}

	public void enterFirstname(String firstname) {
		oCommonFunctions.sendKey(firstnameTextBox, firstname, 10);
	}

	public void enterLastname(String lastname) {
		oCommonFunctions.sendKey(lastnameTextBox, lastname, 10);
	}

	public void clicklogout() {
		oCommonFunctions.clickElement(logoutButton, 10);

	}

	public void clickbillingAdd() {
		oCommonFunctions.clickElement(labelBillingAdd, 10);

	}

	public void clickbillingEdit() {
		oCommonFunctions.clickElement(labelBillingEdit, 10);

	}

	public void clickshippingAdd() {
		oCommonFunctions.clickElement(labelShippingAdd, 10);

	}

	public void clickshippingEdit() {
		oCommonFunctions.clickElement(labelShippingEdit, 10);

	}

	public void verifyLogout() {
		Assert.assertTrue(driver.getTitle().contains("Login"));
		Assert.assertTrue(driver.getPageSource().contains("Sign In with Social Media"));
		oCommonFunctions.sleepWait(4);
	}

	public void verifyLogin() {
		Assert.assertTrue(driver.getPageSource().contains("My Account"));
		oCommonFunctions.sleepWait(10);
	}
}
