package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class ProductsPage {
	
WebDriver driver;


	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
		
	
	private By productNameBackpack = By.xpath("//div[@class=\"inventory_list\"]//descendant::a[@id=\"item_4_title_link\"]");
	private By productNameBikeLights = By.xpath("//div[@class=\"inventory_list\"]//descendant::a[@id=\"item_0_title_link\"]");
	
	
	private By productDescription = By.xpath("//a[@id=\"item_4_title_link\"]//following-sibling::div[@class=\"inventory_item_desc\"]");
	private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
	private By addToCartBikeLights = By.id("add-to-cart-sauce-labs-bike-light");
	private By cartIcon = By.id("shopping_cart_container");
	private By cartItem = By.xpath("//div[@class=\"cart_item\"]");
	
	private By removeFromCartBackpack = By.id("remove-sauce-labs-backpack");
	
	
	private By filterDropdown = By.xpath("//select[@class=\"product_sort_container\"]");
	private By sortAZ = By.xpath("//select[@class=\"product_sort_container\"]/option[@value=\"az\"]");
	private By sortZA = By.xpath("//select[@class=\"product_sort_container\"]/option[@value=\"za\"]");
	private By sortLoHi = By.xpath("//select[@class=\"product_sort_container\"]/option[@value=\"lohi\"]");
	private By sortHiLo = By.xpath("//select[@class=\"product_sort_container\"]/option[@value=\"hilo\"]");
	
	private By unsortedProductsListName = By.xpath("//div[@class=\"inventory_item_name\"]");
	private By unsortedProductsPriceList = By.xpath("//div[@class=\"inventory_item_price\"]");
	
	
	public void clickProductName () {
		driver.findElement(productNameBackpack).click();
	}
	
	
	public void addToCart () {
		driver.findElement(addToCartBackpack).click();
		
	}
	
	public boolean cartItemState() {
		return driver.findElement(cartItem).isDisplayed();
	}
	
	public void clickRemoveFromCart() {
			driver.findElement(removeFromCartBackpack).click();
	}
	
	
	public void addToCartItem2 () {
		driver.findElement(addToCartBikeLights).click();
	}
	
	public void clickCart () {
		driver.findElement(cartIcon).click();
	}

	public String productNameGetText() {
		return driver.findElement(productNameBackpack).getText();
	}
	
	public String productNameBikeGetText() {
		return driver.findElement(productNameBikeLights).getText();
	}
	
	
	public String productDescriptionGetText() {
		return driver.findElement(productDescription).getText();
	}
	
	public boolean addtoCartBackpackButtonState() {
		return driver.findElement(addToCartBackpack).isDisplayed();
	}
	
	public boolean removeFromCartBackpackButtonState() {
		return driver.findElement(removeFromCartBackpack).isDisplayed();
	}
	
	public void sortAZ() {
		driver.findElement(filterDropdown).click();
		driver.findElement(sortAZ).click();	
	}
	
	public void sortZA() {
		driver.findElement(filterDropdown).click();
		driver.findElement(sortZA).click();
	}
		
	public void sortLoHi() {
		driver.findElement(filterDropdown).click();
		driver.findElement(sortLoHi).click();
}
	public void sortHiLo() {
		driver.findElement(filterDropdown).click();
		driver.findElement(sortHiLo).click();
}
	
	public List<String> getNamesList() {
		List<WebElement> getNames = driver.findElements(unsortedProductsListName);
		List<String> getNameList = new ArrayList<String>();
		for (WebElement name: getNames)
		{
			getNameList.add(name.getText());
		}		
		return getNameList;
		}	
	
	
	public List<String> afterFilterNamesListAZ() {
		sortZA();
		sortAZ();
		List<String> resultAZ = getNamesList();
	
	return resultAZ;
}
	
	public List<String> afterFilterNamesListZA() {
		sortZA();
		List<String> resultZA = getNamesList();
		
		return resultZA;
	}	
			
	public List<Double> getPricesList(){
	List<WebElement> getPrices = driver.findElements(unsortedProductsPriceList);
	List<Double> getPriceList = new ArrayList<>();
	
	for (WebElement price : getPrices) {
		getPriceList.add(Double.valueOf(price.getText().replace("$", "")));
	}
	return getPriceList;
	}
	
	
	public List<Double> afterFilterPricesHiLo(){
		sortHiLo();
		List<Double> resultHiLo = getPricesList();
		
		return resultHiLo;
	}
	
	public List<Double> afterFilterPricesLoHi(){
		sortLoHi();
		List<Double> resultLoHi = getPricesList();
		
		return resultLoHi;
	}
	
	
}
