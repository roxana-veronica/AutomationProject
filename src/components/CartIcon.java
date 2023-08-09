package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartIcon {
	
	WebDriver driver;
	
	public CartIcon(WebDriver driver) {
		this.driver = driver;
	}

	private By shoppingCartIcon = By.id("shopping_cart_container");
	
	
	public boolean shoppingCartButtonDisplayState() {
		return driver.findElement(shoppingCartIcon).isDisplayed();
	}
}