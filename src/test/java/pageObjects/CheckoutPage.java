package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Automation.CommonFunctions;

public class CheckoutPage {

	public WebDriver driver;
	private CommonFunctions oCommonFunctions;



	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();

	}

	@FindBys({ @FindBy(xpath = "//*[contains(text(),'lick here to login')]") })
	public List<WebElement> clickHereToLoginLink;
	@FindBy(id = "username")
	private static WebElement usernameTextBox;
	@FindBy(id = "password")
	private static WebElement passwordTextBox;
	@FindBy(xpath = "//button[contains(@name,'login')]")
	private static WebElement loginButton;

	public void verifyClickHereToLoginLinkDisplayed() {
		Assert.assertTrue(clickHereToLoginLink.size() > 0);
	}

	public void clickClickHereToLoginLink() {
		oCommonFunctions.clickElement(clickHereToLoginLink.get(0), 10);
	}

	public void enterUsername(String username) {
		oCommonFunctions.sendKey(usernameTextBox, username, 10);
	}

	public void enterPassword(String password) {
		oCommonFunctions.sendKey(passwordTextBox, password, 10);
	}

	public void clickLogin() {
		oCommonFunctions.clickElement(loginButton, 10);
		oCommonFunctions.sleepWait(8);
	}
	
	

	public void verifyBillingDetailsDisplayed() {
		Assert.assertTrue(driver.getPageSource().contains("Billing details"));
	}

}
