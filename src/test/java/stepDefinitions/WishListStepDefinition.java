package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Automation.Base;
import cucumber.api.java.en.And;
import pageObjects.BillingPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class WishListStepDefinition extends Base {
	/* Actions */
	public Actions act;
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	BillingPage billingPage;

	public WishListStepDefinition() {
		// TODO Auto-generated constructor stub
	}

	@And("^Click on wishlist$")
	public void click_on_wishlist() throws Throwable {
		driver.findElement(By.xpath("//i[contains(@class,'fa-heart-o')]")).click();
		Assert.assertTrue(driver.getPageSource().contains("No products added to the wishlist"));
		driver.findElement(By.xpath("//a[contains(text(),'Back To Shopping')]")).click();
	}

	@And("^Click on product and add more quantity \"([^\"]*)\"$")
	public void click_on_product_and_add_more_quantity(String qty) throws Throwable {
		act = new Actions(driver);
		WebElement productimage2 = driver.findElement(By.xpath(
				"//span[@class='et_shop_image']//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']"));
		act.moveToElement(productimage2).build().perform();
		driver.findElement(By
				.xpath("(//span[@class='et_shop_image']//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'quantity')]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'quantity')]")).sendKeys(qty);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();

	}

	@And("^Click on heart icon$")
	public void click_on_heart_icon() throws Throwable {
		driver.findElement(By.xpath("//span[contains(text(),'Add to wishlist')]")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains("Product added!"));
	}

	@And("^Click on Browse wishlist$")
	public void click_on_browse_wishlist() throws Throwable {
		driver.findElement(By.xpath("//a[contains(@href,'https://plusmartstage.wpengine.com/wishlist/view/')]"))
				.click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("In Stock"));
	}

	@And("^Click on Add to cart$")
	public void click_on_add_to_cart() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		Thread.sleep(3000);
	}

}
