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

	public void enterEmailAddress(String email) {
		oCommonFunctions.sendKey(emailTextBox, email, 10);
	}

	public void enterPassword(String password) {
		oCommonFunctions.sendKey(passwordTextBox, password, 10);
	}

	public void clickLogin() {
		oCommonFunctions.clickElement(loginButton, 10);
	}

	public void verifyLogout() {
		Assert.assertTrue(driver.getTitle().contains("Sign in"));
		Assert.assertTrue(driver.getPageSource().contains("Sign in with your email"));
	}

	public void verifyLogin() {
		Assert.assertTrue(driver.getPageSource().contains("My Account"));
	}
}
