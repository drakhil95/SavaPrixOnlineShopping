package com.savaprix.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountsLoggedIn {
	
	WebDriver driver;
	
	@FindBy(id = "name")
	private WebElement usesrNameTbx;
	
	@FindBy(id = "exampleInputEmail1")
	private WebElement emailTbx;
	
	@FindBy(id = "contactno")
	private WebElement contactTbx;
	
	@FindBy(name = "update")
	private WebElement updateBtn;
	
	@FindBy(linkText = "Shipping / Billing Address")
	private WebElement billingAddressLink;
	
	@FindBy(linkText = "Order History")
	private WebElement orderHistoryLink;
	
	@FindBy(linkText = "Payment Pending Order")
	private WebElement paymentPendingLink;

	public MyAccountsLoggedIn(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsesrNameTbx() {
		return usesrNameTbx;
	}

	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getContactTbx() {
		return contactTbx;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getBillingAddressLink() {
		return billingAddressLink;
	}

	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}

	public WebElement getPaymentPendingLink() {
		return paymentPendingLink;
	}
	
	
	
	
	
}
