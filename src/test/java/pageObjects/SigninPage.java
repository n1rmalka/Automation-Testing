package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.Base;
import Automation.CommonFunctions;

public class SigninPage extends Base {
	public WebDriver driver;
	public CommonFunctions oCommonFunctions;

	public SigninPage(WebDriver driver) {
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

}
