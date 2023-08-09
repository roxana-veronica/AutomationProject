package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutYourInformationPage {
	
WebDriver driver;

		
		public CheckoutYourInformationPage(WebDriver driver) {
			this.driver = driver;
		}
	
	private By orderFormFirstName = By.id("first-name");
	private By orderFormLastName = By.id("last-name");
	private By orderFormZip = By.id("postal-code");
	private By continueButton = By.xpath("//input[@value=\"Continue\"]");
	private By errorMessage = By.xpath("//h3[@data-test=\"error\"]");

	
	public void emptyFirstName () {
		driver.findElement(orderFormLastName).sendKeys("Horne");
		driver.findElement(orderFormZip).sendKeys("4444");
		clickContinueButton();	
		
	}
	
	public void emptyLastName () {

		driver.findElement(orderFormFirstName).sendKeys("Audrey");
		driver.findElement(orderFormZip).sendKeys("4444");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickContinueButton();	
	}
	
	public void emptyZip() {
		driver.findElement(orderFormFirstName).sendKeys("Audrey");
		driver.findElement(orderFormLastName).sendKeys("Horne");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickContinueButton();
	}
	
	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}
	
	public void validOrderForm () {
		driver.findElement(orderFormFirstName).sendKeys("Audrey");
		driver.findElement(orderFormLastName).sendKeys("Horne");
		driver.findElement(orderFormZip).sendKeys("4444");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickContinueButton();
	}
	
	public String errorMessageFirstNameGetText() {
		emptyFirstName();
		return driver.findElement(errorMessage).getText();
	}
	
	public String errorMessageLastNameGetText() {
		emptyLastName();
		return driver.findElement(errorMessage).getText();
	}
	
	public String errorMessageZipGetText() {
		emptyZip();
		return driver.findElement(errorMessage).getText();
	}
}