package com.savaprix.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.savaprix.ecom.webdriverutility.WebdriverUtility;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountBtn;
	
	@FindBy(linkText = "Wishlist")
	private WebElement wishlistBtn;
	
	@FindBy(linkText = "My Cart")
	private WebElement myCartBtn;
	
	@FindBy(linkText = "Login")
	private WebElement userLoginBtn;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;
	
	@FindBy(linkText = " Books")
	private WebElement booksBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Electronics')]")
	private WebElement electronicsBtn;
	
	@FindBy(linkText = " Fashion")
	private WebElement fashionBtn;
	
	@FindBy(linkText = " Home Decor")
	private WebElement homeDecorBtn;
	
	@FindBy(linkText = " Jewelry")
	private WebElement jewelryBtn;
	
	@FindBy(linkText = "Admin Login")
	private WebElement adminLoginBtn;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMyAccountBtn() {
		return myAccountBtn;
	}

	public WebElement getWishlistBtn() {
		return wishlistBtn;
	}

	public WebElement getMyCartBtn() {
		return myCartBtn;
	}

	public WebElement getUserLoginBtn() {
		return userLoginBtn;
	}

	public WebElement getAdminLoginBtn() {
		return adminLoginBtn;
	}
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getBooksBtn() {
		return booksBtn;
	}

	public WebElement getElectronicsBtn() {
		return electronicsBtn;
	}

	public WebElement getFashionBtn() {
		return fashionBtn;
	}

	public WebElement getHomeDecorBtn() {
		return homeDecorBtn;
	}

	public WebElement getJewelryBtn() {
		return jewelryBtn;
	}

	public void adminLoginFromHomePage(){
		adminLoginBtn.click();
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin();
	}
	
	public void userLoginFromHomePage(String email, String password){
		WebdriverUtility wU = new WebdriverUtility();
		wU.waitForElementToAppear(driver, userLoginBtn);
		userLoginBtn.click();
		MyAccounts ma = new MyAccounts(driver);
		ma.loginAsUser(email, password);
	}
}
