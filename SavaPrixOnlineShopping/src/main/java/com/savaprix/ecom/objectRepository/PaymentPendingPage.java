package com.savaprix.ecom.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPendingPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//form[@name='cart']//tbody/tr")
	private List<WebElement> productList;
	
	@FindBy(name = "ordersubmit")
	private WebElement proceedToPayBtn;
	
	@FindBy(xpath = "//td/h4[text()='No Result Found']")
	private WebElement emptyListMsg;

	
	public PaymentPendingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public List<WebElement> getProductList() {
		return productList;
	}

	public WebElement getProceedToPayBtn() {
		return proceedToPayBtn;
	}
	
	public WebElement getEmptyListMsg() {
		return emptyListMsg;
	}


	/*
	 * checks for the product from the entire order list and delete it from the l
	 */
	public void deletePendingProduct(String product) {
		for (WebElement ele : productList) {
			String txt = ele.findElement(By.xpath(".//h4[@class='cart-product-description']")).getText().toLowerCase();
			if (txt.contains(product.toLowerCase())) {
				ele.findElement(By.xpath(".//td/a[text()='Delete']")).click(); // clicking on the delete button
				break;
			}
		}	
	}
}
