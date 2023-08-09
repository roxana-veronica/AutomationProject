package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import messages.Login;



public class LoginTests extends BaseTest {
	

	@Test
	//1. Login with valid data 
	public void loginValidCredentials() {
	loginPage.authenticate(userTD.getUsername(), userTD.getPassword());
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	assertEquals("Products", loginPage.getMainPageHeader());
	assertTrue(cartIcon.shoppingCartButtonDisplayState());
}
	
	@Test
	//2.Login with invalid data (wrong username)
	public void loginInvalidCredentials() {
		loginPage.authenticate("username", userTD.getPassword());
		assertEquals(Login.LOGIN_ERROR, loginPage.getLoginError());
	}
	
	@Test
	//2.Login with invalid data (locked user)
	public void loginLockedCredentials() {
		loginPage.authenticate(userInvalid.getUsername(), userInvalid.getPassword());
		assertEquals(Login.LOGIN_LOCKED_ERROR, loginPage.getLoginError());
	}
		
	@Test
	//9.Logout 
	public void logout() {
		loginPage.authenticate(userTD.getUsername(), userTD.getPassword());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Products", loginPage.getMainPageHeader());
		assertTrue(cartIcon.shoppingCartButtonDisplayState());
		mainMenu.clickLogout();
		assertTrue(loginPage.loginButtonState());
	}
		
}

