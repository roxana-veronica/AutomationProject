package tests;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;


public class ProductsListTests extends BaseTest{
	
	@Before @Override
	public void before() {
		super.before();
		loginPage.authenticate(userTD.getUsername(), userTD.getPassword());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("PRODUCTS", loginPage.getMainPageHeader());
		assertTrue(cartIcon.shoppingCartButtonDisplayState());
	}
	
	
	@Test
	//3.View product details - missing product price 
	//get product details (name, price, description), check one product has the following details
	public void productDetails() {
			
		assertEquals("Sauce Labs Backpack", productsPage.productNameGetText());	
		String description = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
		assertEquals(description, productsPage.productDescriptionGetText());
		}
	
	@Test
	//8. Filter products based on name AZ
	public void sortAZ() {
		System.out.println(productsPage.getNamesList());
		System.out.println(productsPage.afterFilterNamesListAZ());
		System.out.println(productsPage.getNamesList());
		assertTrue(productsPage.getNamesList().equals(productsPage.afterFilterNamesListAZ()));
	}
	
	@Test
	//8. Filter products based on name ZA
	public void sortZA() {
		System.out.println(productsPage.getNamesList());
		System.out.println(productsPage.afterFilterNamesListZA());
		System.out.println(productsPage.getNamesList());
		assertTrue(productsPage.getNamesList().equals(productsPage.afterFilterNamesListZA()));
		
	}
	


	@Test
	//8. Filter products based on price lo-hi
	public void sortLoHi() {
		System.out.println(productsPage.getPricesList());
		System.out.println(productsPage.afterFilterPricesLoHi());	
		System.out.println(productsPage.getPricesList());
		assertTrue(productsPage.getPricesList().equals(productsPage.afterFilterPricesLoHi()));
		}
	
	@Test
	//8. Filter products based on price hi-lo
	public void sortHiLo() {
		System.out.println(productsPage.getPricesList());
		System.out.println(productsPage.afterFilterPricesHiLo());
		System.out.println(productsPage.getPricesList());
		assertTrue(productsPage.getPricesList().equals(productsPage.afterFilterPricesHiLo()));		
	}

	
	
}

