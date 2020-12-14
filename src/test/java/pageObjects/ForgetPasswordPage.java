package pageObjects;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

import Automation.Base;
import Automation.CommonFunctions;

public class ForgetPasswordPage extends Base {
	public WebDriver driver;
	public CommonFunctions oCommonFunctions;
	static Properties property;

	public ForgetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();
	}

	@FindBy(xpath = "//*[contains(@placeholder,'Public Mailinator Inbox')]")
	public static WebElement txtbxInbox;
	@FindBy(xpath = "//button[contains(text(),'G')]")
	public static WebElement btnGo;
	@FindBy(xpath = "(//*[contains(text(),'Reset')])[1]")
	public static WebElement labelInboxTitle;
	@FindBy(xpath = "//a[contains(text(),'verify')]")
	public static WebElement linkClickhere;

	public void OpenMail(String email) throws IOException, InterruptedException {

		driver.get("https://www.mailinator.com");
		oCommonFunctions.sendKey(txtbxInbox, email, 10);
		oCommonFunctions.clickElement(btnGo, 10);
		oCommonFunctions.clickElement(labelInboxTitle, 10);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,250)");
		// jse.executeScript("window.scrollBy(0,250)");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='msg_body']")));
		oCommonFunctions.scrollToElement(linkClickhere, 5);
		jse.executeScript("arguments[0].click();", linkClickhere);
		// oCommonFunctions.sleepWait(5);

	}
}
