package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {

WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}		
	
	//locators 	
	private By cartProduct = By.xpath("//div[@class=\"cart_item\"]");
	private By checkOutButton = By.id("checkout");
	private By continueShoppingButton = By.id("continue-shopping");

	
	//actions		
	public void clickContinueShopping () {
		driver.findElement(continueShoppingButton).click();
	}
	
	public void checkoutClick () {
		driver.findElement(checkOutButton).click();
	}
	
	public boolean cartProductState() {
		return driver.findElement(cartProduct).isDisplayed();
	}

}
