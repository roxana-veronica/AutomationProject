package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {


WebDriver driver;

	public CheckoutCompletePage(WebDriver driver) {
	this.driver = driver;
}
	
	//locators	
	private By backHomeButton = By.id("back-to-products");
	private By thankYouOrderMessage = By.xpath("//h2[@class=\"complete-header\"]");
	private By completeText = By.xpath("//div[@class=\"complete-text\"]");
	private By checkoutCompleteTitle = By.xpath("//span[@class=\"title\"]");

	//Actions
	public void clickBackHomeButton() {
		driver.findElement(backHomeButton).click();
	}
	
	public boolean HomeButtonState() {
		return driver.findElement(backHomeButton).isDisplayed();
	}
	
	public String thankYouOrderMessageGetText() {
		return driver.findElement(thankYouOrderMessage).getText();
	}
	
	public String completeOrderMessageGetText() {
		return driver.findElement(completeText).getText();
	}
	
	public String checkoutCompleteTitleGetText() {
		return driver.findElement(checkoutCompleteTitle).getText();
		
	}
	
}
