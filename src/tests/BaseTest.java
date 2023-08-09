package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import components.CartIcon;
import components.MainMenu;
import messages.Login;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutYourInformationPage;
import pages.CheckoutCompletePage;
import pages.LoginPage;
import pages.ProductsPage;
import testData.URL;
import testData.User;

public class BaseTest {
	
	static WebDriver driver;
	public static LoginPage loginPage;
	public static ProductsPage productsPage;
	public static CartPage cartPage;
	public static User userTD = new User("standardUser");
	public static User userInvalid = new User("locked_out_user");
	public static CartIcon cartIcon;
	public static MainMenu mainMenu;
	public static MainMenu logout;
	public static Login messages;
	public static CheckoutYourInformationPage checkoutInformationPage;
	public static CheckoutOverviewPage checkoutOverviewPage;
	public static CheckoutCompletePage checkoutCompletePage;
	
	
	
	@BeforeClass
	public static void beforeAll() {
		
	}
	
	@AfterClass
	public static void afterAll() {
		
	}
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\defin\\Desktop\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		userTD = new User("standardUser");
		userInvalid = new User("locked_out_user");
		cartIcon = new CartIcon(driver);
		mainMenu = new MainMenu(driver);
		logout  = new MainMenu(driver);
		checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		checkoutInformationPage = new CheckoutYourInformationPage(driver);
		
		driver.navigate().to(URL.BASE_URL);
		driver.manage().window().maximize();
		
		
	}
	
	@After
	public void after() {
		driver.close();
		driver.quit();
		
	}

}
