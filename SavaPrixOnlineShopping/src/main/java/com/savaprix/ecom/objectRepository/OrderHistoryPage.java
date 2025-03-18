package com.savaprix.ecom.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class OrderHistoryPage {
	WebDriver driver;
	
	@FindBy(xpath = "//form[@name='cart']//tbody/tr")
	private List<WebElement> orderList;
	
	
	public OrderHistoryPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getOrderList() {
		return orderList;
	}
		

	/*
	 * checks for the latest product ordered 
	 */
	public void verifyLatestOrder(String product) {
		
		int size = orderList.size() - 1;
		boolean flag = false;
		
		String txt = orderList.get(size).findElement(By.xpath(".//h4[@class='cart-product-description']")).getText().toLowerCase();
		System.out.println("++++"+txt+"++++");
		if (txt.contains(product.toLowerCase())) {
			flag = true;
		}
		
		Assert.assertTrue(flag);
	}
	
		
	/*
	 * checks for the product from the entire order list
	 */
	public void verifyOrder(String product) {
		
		boolean flag = false;
		
			for (WebElement ele : orderList) {
				String txt = ele.findElement(By.xpath(".//h4[@class='cart-product-description']")).getText().toLowerCase();
				if (txt.contains(product.toLowerCase())) {
					flag = true;
					System.out.println(product + " is present");
					break;
				}
			}	
			Assert.assertTrue(flag);
		}
}
