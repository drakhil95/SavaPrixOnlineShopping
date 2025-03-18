package com.savaprix.ecom.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.savaprix.ecom.basetest.BaseClass;
import com.savaprix.ecom.fileutility.FileUtility;

public class AdminLoginPage{
	WebDriver driver;
	FileUtility fU = new FileUtility();
	
	@FindBy(id = "inputEmail")
	private WebElement emailTbx;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTbx;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[contains(text(), 'Back to Portal')]")
	private WebElement backToPortalBtn;

	public AdminLoginPage() {}
	
	public AdminLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getBackToPortalBtn() {
		return backToPortalBtn;
	}

	public WebElement getEmailTxtField() {
		return emailTbx;
	}

	public WebElement getPasswordTxtField() {
		return passwordTbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void adminLogin() {
		String un = "admin";
		String pw = "admin";
		try {
			un = fU.getDataFromPropertyFile("adminUn");
			pw = fU.getDataFromPropertyFile("adminPw");
		} catch (IOException e) {
			System.err.println("ERROR READING DATA FROM THE PROPERTY FILE");
		}
		
		emailTbx.sendKeys(un);
		passwordTbx.sendKeys(pw);
		loginBtn.click();
	}
	
	
}
