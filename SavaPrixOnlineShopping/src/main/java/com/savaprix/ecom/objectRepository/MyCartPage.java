package com.savaprix.ecom.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
	WebDriver driver;
	
	@FindBy(xpath = "//tbody//td[@class='cart-product-name-info']/h4/a")
	private List<WebElement> productNameList;
	
	@FindBy(xpath = "//tbody//td[@class='cart-product-grand-total']/span")
	private List<WebElement> finalPriceList;
	
	@FindBy(name = "submit")
	private WebElement updateShoppingCartBtn;
	
	@FindBy(linkText = "Continue Shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy(name = "billingaddress")
	private WebElement shippingAddressTbx;
	
	@FindBy(id = "bilingstate")
	private WebElement shippingStateTbx;
	
	@FindBy(id = "billingcity")
	private WebElement shippingCityTbx;
	
	@FindBy(id = "billingpincode")
	private WebElement shippingPincodeTbx;
	
	@FindBy(name = "shippingaddress")
	private WebElement billingAddressTx;
	
	@FindBy(id = "shippingstate")
	private WebElement billingStateTbx;
	
	@FindBy(id = "shippingcity")
	private WebElement billingCityTbx;
	
	@FindBy(id = "shippingpincode")
	private WebElement billingPincodeTbx;
	
	@FindBy(xpath = "//button[text()='PROCCED TO CHEKOUT']")
	private WebElement checkoutBtn;
	
	@FindBy(name = "shipupdate")
	private WebElement billingAddressUpdateBtn;
	
	@FindBy(name = "update")
	private WebElement shippingAddressUpdateBtn;
	
	
	public WebElement getBillingAddressUpdateBtn() {
		return billingAddressUpdateBtn;
	}


	public WebElement getShippingAddressUpdateBtn() {
		return shippingAddressUpdateBtn;
	}


	public MyCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<WebElement> getProductNameList() {
		return productNameList;
	}

	public List<WebElement> getFinalPriceList() {
		return finalPriceList;
	}

	public WebElement getUpdateShoppingCartBtn() {
		return updateShoppingCartBtn;
	}

	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public WebElement getShippingAddressTbx() {
		return shippingAddressTbx;
	}

	public WebElement getShippingStateTbx() {
		return shippingStateTbx;
	}

	public WebElement getShippingCityTbx() {
		return shippingCityTbx;
	}

	public WebElement getShippingPincodeTbx() {
		return shippingPincodeTbx;
	}

	public WebElement getBillingAddressTx() {
		return billingAddressTx;
	}

	public WebElement getBillingStateTbx() {
		return billingStateTbx;
	}

	public WebElement getBillingCityTbx() {
		return billingCityTbx;
	}

	public WebElement getBillingPincodeTbx() {
		return billingPincodeTbx;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	
	
	
	public void updateShippingAddress(String address, String state, String city, String pincode) {
		shippingAddressTbx.clear();
		shippingStateTbx.clear();
		shippingCityTbx.clear();
		shippingPincodeTbx.clear();
		
		shippingAddressTbx.sendKeys(address);
		shippingStateTbx.sendKeys(state);
		shippingCityTbx.sendKeys(city);
		shippingPincodeTbx.sendKeys(pincode);
		shippingAddressUpdateBtn.click();
	}
	
	public void updateBillingAddress(String address, String state, String city, String pincode) {
		billingAddressTx.clear();
		billingStateTbx.clear();
		billingCityTbx.clear();
		billingPincodeTbx.clear();
		
		billingAddressTx.sendKeys(address);
		billingStateTbx.sendKeys(state);
		billingCityTbx.sendKeys(city);
		billingPincodeTbx.sendKeys(pincode);
		billingAddressUpdateBtn.click();
	}
}
