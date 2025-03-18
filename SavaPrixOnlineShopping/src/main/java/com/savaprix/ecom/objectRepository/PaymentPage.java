package com.savaprix.ecom.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement codRadioBtn;
	
	@FindBy(xpath = "//input[@value='Internet Banking']")
	private WebElement internetBankingRadioBtn;
	
	@FindBy(xpath = "//input[@value='Debit / Credit card']")
	private WebElement creditDebitRadioBtn;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public PaymentPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCodRadioBtn() {
		return codRadioBtn;
	}

	public WebElement getInternetBankingRadioBtn() {
		return internetBankingRadioBtn;
	}

	public WebElement getCreditDebitRadioBtn() {
		return creditDebitRadioBtn;
	}


}
