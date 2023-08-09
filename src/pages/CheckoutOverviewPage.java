package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
	
WebDriver driver;

	public CheckoutOverviewPage(WebDriver driver) {
	this.driver = driver;
	}
	
	//locators	
	private By finishButton = By.id("finish");
	
	
	public void clickFinishButton() {		
	// Page Down with actions
	//	Actions actions = new Actions(driver);		
	//	actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
	//	actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
	//	actions.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
	
	//scroll down to element 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement finishButton2 = driver.findElement(finishButton);
		js.executeScript("arguments[0].scrollIntoView();", finishButton2);
		driver.findElement(finishButton).click();		
	}

}
