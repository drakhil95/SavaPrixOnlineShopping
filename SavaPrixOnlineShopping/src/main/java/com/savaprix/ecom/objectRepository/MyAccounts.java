package com.savaprix.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.savaprix.ecom.webdriverutility.WebdriverUtility;

public class MyAccounts {
	WebDriver driver;
	
	@FindBy(id = "exampleInputEmail1")
	private WebElement loginEmailTbx;
	
	@FindBy(id = "exampleInputPassword1")
	private WebElement loginPasswordTbx;
	
	@FindBy(xpath = "//button[text()='Login']") /*  */
	private WebElement loginBtn;
	
	
	@FindBy(name = "fullname")
	private WebElement fullNameTbx;
	
	@FindBy(id = "email")
	private WebElement emailTbx;
	
	@FindBy(id = "contactno")
	private WebElement contactTbx;
	
	@FindBy(id = "password")
	private WebElement passwordTbx;
	
	@FindBy(id = "confirmpassword")
	private WebElement confirmPasswordTbx;
	
	@FindBy(id = "submit")
	private WebElement signUpBtn;

	
	public MyAccounts(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getLoginEmailTbx() {
		return loginEmailTbx;
	}

	public WebElement getLoginPasswordTbx() {
		return loginPasswordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getFullNameTbx() {
		return fullNameTbx;
	}

	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getContactTbx() {
		return contactTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getConfirmPasswordTbx() {
		return confirmPasswordTbx;
	}
	
	public WebElement getSignUpBtn() {
		return signUpBtn;
	}


	public void createAccount(String un, String email, String contact, String pw) {
		WebdriverUtility wU = new WebdriverUtility();
		fullNameTbx.sendKeys(un);
		emailTbx.sendKeys(email);
		contactTbx.sendKeys(contact);
		passwordTbx.sendKeys(pw);
		confirmPasswordTbx.sendKeys(pw);
		
		wU.scrollByAmount(driver, 0, 200);
		signUpBtn.click();
		wU.alertPopupAccept(driver);
	}
	
	public void loginAsUser(String username, String password) {
		loginEmailTbx.sendKeys(username);
		loginPasswordTbx.sendKeys(password);
		loginBtn.click();
	}
}
