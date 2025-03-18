package com.savaprix.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishlist {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[contains(@onclick, 'Are you sure you want to delete')]")
	private WebElement removeFromCartBtn;
	
	public MyWishlist(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getRemoveFromCartBtn() {
		return removeFromCartBtn;
	}
	
	
	
}
