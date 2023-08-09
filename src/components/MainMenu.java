package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainMenu {
	
WebDriver driver;
//public WebDriverWait wait = new WebDriverWait(driver,30);
	
	public MainMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	private By mainMenu = By.id("react-burger-menu-btn");
	private By logout = By.id("logout_sidebar_link");

	public void clickLogout() {
		driver.findElement(mainMenu).click();
	//	wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		driver.findElement(logout).click();
	}
}
