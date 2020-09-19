package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.Base;
import Automation.CommonFunctions;

public class SignupPage extends Base {
	public WebDriver driver;
	public CommonFunctions oCommonFunctions;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();
	}

	@FindBy(xpath = "//a[@class='signUpBtn' and contains(text(),'Sign In')]")
	public static WebElement siginlink;
	@FindBy(xpath = "//input[@id='loginusername']")
	public static WebElement loginUsername;
	@FindBy(xpath = "//input[@id='loginpassword']")
	public static WebElement loginPassword;
	@FindBy(xpath = "//*[contains(@href,'/lost-password')]")
	public static WebElement forgotPasswordlink;
	@FindBy(xpath = "//input[@name='submit']")
	public static WebElement btnSubmit;
	@FindBy(xpath = "//input[@id='useremail']")
	public static WebElement btnUserEmail;
	@FindBy(xpath = "//div[@class='lost_pass_txt']//li[1]")
	public static WebElement linkReturntologin;
	@FindBy(xpath = "//div[@class='lost_pass_txt']//li[2]")
	public static WebElement Resendrecoverylink;
	@FindBy(xpath = "//input[@id='login']")
	public static WebElement txtbxyopmailLogin;
	@FindBy(xpath = "//input[@class='sbut']")
	public static WebElement btnyopmailSubmit;
	@FindBy(xpath = "//div[@id='m1']//span[@class='lmf'][contains(text(),'40Plusmart')]")
	public static WebElement linkyopmailInbox;
	@FindBy(xpath = "//a[contains(text(),'Click here')]")
	public static WebElement linkyopmailreset;
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement txtbxnewPassword;
	@FindBy(xpath = "//input[@id='retypepassword']")
	public static WebElement txtbxretypePassword;

	public void clickSigninLink() {
		oCommonFunctions.sleepWait(2);
		oCommonFunctions.clickElement(siginlink, 5);

	}

	public void clickForgetPasswordLink() {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.clickElement(forgotPasswordlink, 5);

	}

	public void enterEmail(String email) {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.sendKey(btnUserEmail, email, 5);
	}

	public void clickBtnSubmit() {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.clickElement(btnSubmit, 10);
	}

	public void clickRecoveryLink() {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.clickElement(Resendrecoverylink, 10);
	}

	public void clickResendRecoveryLink() {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.clickElement(Resendrecoverylink, 10);
	}

	public void enterUsername(String username) {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.sendKey(loginUsername, username, 5);
	}

	public void enterPassword(String password) {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.sendKey(loginPassword, password, 5);
	}

	public void enterNewPassword(String newpassword) {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			oCommonFunctions.sleepWait(1);
			oCommonFunctions.sendKey(txtbxnewPassword, newpassword, 5);
		}
	}

	public void enterConfirmPassword(String confirmpassword) {
		oCommonFunctions.sleepWait(1);
		oCommonFunctions.sendKey(txtbxretypePassword, confirmpassword, 5);
	}

}
