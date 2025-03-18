package com.savaprix.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInformationPage {
	WebDriver driver;
	
	@FindBy(tagName = "h1")
	private WebElement productName;
	
	@FindBy(xpath = "//a[contains(@href, 'product-details.php?page=product')]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@class='arrows']/div[contains(@class, 'plus')]")
	private WebElement quantityIncreaseBtn;
	
	@FindBy(xpath = "//div[@class='arrows']/div[contains(@class, 'minus')]")
	private WebElement quantityDecreaseBtn;
	
	@FindBy(xpath = "//a[@data-original-title='Wishlist']")
	private WebElement addToWishlistBtn;
	
	
	public ProductsInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getQuantityIncreaseBtn() {
		return quantityIncreaseBtn;
	}

	public WebElement getQuantityDecreaseBtn() {
		return quantityDecreaseBtn;
	}

	public WebElement getAddToWishlistBtn() {
		return addToWishlistBtn;
	}
	
	
}
