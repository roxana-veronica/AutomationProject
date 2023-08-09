package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import messages.CheckoutSenderInfo;
import messages.OrderComplete;



public class AddToCartTests extends BaseTest {
	
	@Before @Override
	public void before() {
		super.before();
		loginPage.authenticate(userTD.getUsername(), userTD.getPassword());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Products", loginPage.getMainPageHeader());
		assertTrue(cartIcon.shoppingCartButtonDisplayState());
	}
	
	
	@Test
	//4.Add and remove a product from the cart  
	//click add to cart , assert button changes to remove id("remove-sauce-labs-backpack")
	//remove item, assert button changes back to add to cart 
	public void addToCart() {
		
		productsPage.addToCart();
		assertEquals(true, productsPage.removeFromCartBackpackButtonState());
		productsPage.clickRemoveFromCart();
		assertEquals(true, productsPage.addtoCartBackpackButtonState());
	}
	
	@Test
	//validation for item present inside cart
	public void elementAddedToCartValidation() {
		productsPage.addToCart();
		productsPage.clickCart();
		assertTrue(productsPage.cartItemState());
	}
	
	
	@Test
	//5.Validate sender invalid data for first name
	public void invalidDataFirstName () {
		productsPage.addToCart();
		productsPage.clickCart();
		cartPage.checkoutClick();		
		checkoutInformationPage.emptyFirstName();
		assertEquals(CheckoutSenderInfo.INVALID_FIRSTNAME_ERROR,checkoutInformationPage.errorMessageFirstNameGetText());
	}
	
	@Test
	//5.Validate sender invalid data for last name
	public void invalidDataLastName () {
		productsPage.addToCart();
		productsPage.clickCart();
		cartPage.checkoutClick();
		checkoutInformationPage.emptyLastName();
		assertEquals(CheckoutSenderInfo.INVALID_LASTNAME_ERROR,checkoutInformationPage.errorMessageLastNameGetText());
	}
	
	@Test
	//5.Validate sender invalid data for zip
	public void invalidDataZIP () {
		productsPage.addToCart();
		productsPage.clickCart();
		cartPage.checkoutClick();
		checkoutInformationPage.emptyZip();
		assertEquals(CheckoutSenderInfo.INVALID_ZIPCODE_ERROR,checkoutInformationPage.errorMessageZipGetText());
	}
	
	
	@Test
	// 6.Create a purchase for one product 
	public void purchaseOneItem( ) {
	
	productsPage.clickProductName();
	productsPage.addToCart();
	productsPage.clickCart();
	cartPage.checkoutClick();
	checkoutInformationPage.validOrderForm();
	checkoutOverviewPage.clickFinishButton();
	assertEquals(OrderComplete.THANK_YOU_FOR_ORDER, checkoutCompletePage.thankYouOrderMessageGetText());
	assertEquals(OrderComplete.COMPLETE_ORDER_MESSAGE, checkoutCompletePage.completeOrderMessageGetText());
	assertTrue(checkoutCompletePage.HomeButtonState());
	}

	@Test
	// 6.Create a purchase for 2 products
	public void purchaseTwoItems( ) {	
	productsPage.clickProductName();
	productsPage.addToCart();
	productsPage.clickCart();
	cartPage.clickContinueShopping();
	productsPage.addToCartItem2();
	productsPage.clickCart();
	cartPage.checkoutClick();
	checkoutInformationPage.validOrderForm();
	checkoutOverviewPage.clickFinishButton();
	assertEquals(OrderComplete.THANK_YOU_FOR_ORDER, checkoutCompletePage.thankYouOrderMessageGetText());
	assertEquals(OrderComplete.COMPLETE_ORDER_MESSAGE, checkoutCompletePage.completeOrderMessageGetText());
	assertTrue(checkoutCompletePage.HomeButtonState());
}
}


