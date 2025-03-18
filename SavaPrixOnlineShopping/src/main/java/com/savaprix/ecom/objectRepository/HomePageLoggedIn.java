package com.savaprix.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLoggedIn {
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(text(), 'Welcome')]")
	private WebElement welcomeMsg;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	public HomePageLoggedIn(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getWelcomeMsg() {
		return welcomeMsg;
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public boolean welcomeMsgVerify(String userName) {
		if (welcomeMsg.getText().contains(userName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void logoutAsUser() {
		logoutBtn.click();
	}
}
