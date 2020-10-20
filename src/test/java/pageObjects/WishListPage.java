package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Automation.CommonFunctions;

public class WishListPage {

	public WebDriver driver;
	public CommonFunctions oCommonFunctions;
	static Properties property;

	public WishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		oCommonFunctions = new CommonFunctions();
	}

}
