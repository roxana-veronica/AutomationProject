package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators , UI mapper
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	private By websiteHeader = By.xpath("\"//div[@class=\\\"app_logo\\\"]\"");
	private By loginErrorMessage = By.xpath("//div[@class=\"error-message-container error\"]");
	private By productsMainPageTitle = By.xpath("//span[@class=\"title\"]");
		 
	
	//Actions
		public void enterUsername(String name) {
			driver.findElement(usernameInput).sendKeys(name);
		}
		public void enterPassword(String password) {
			driver.findElement(passwordInput).sendKeys(password);
		}
		public void clickLogin() {
			driver.findElement(loginButton).click();
		}
		
		public void authenticate(String name, String password) {
			enterUsername(name);
			enterPassword(password);
			clickLogin();
		}
		
		public String getHeader() {
			return driver.findElement(websiteHeader).getText();
		}
		
		public String getLoginError() {
			return driver.findElement(loginErrorMessage).getText();
		}
		
		public String getMainPageHeader() {
			return driver.findElement(productsMainPageTitle).getText();
		}
		
		public boolean loginButtonState() {
			return driver.findElement(loginButton).isDisplayed();
		}

	}
	