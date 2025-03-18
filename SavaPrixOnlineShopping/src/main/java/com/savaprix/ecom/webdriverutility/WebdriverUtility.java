package com.savaprix.ecom.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.savaprix.ecom.fileutility.Constants;

public class WebdriverUtility implements Constants{
	WebDriverWait wait; /* Shared across multiple waits so declared here */
	
	public void alertPopupAccept(WebDriver driver) {
		waitForAlertToAppear(driver);
		driver.switchTo().alert().accept();
	}
	
	public void alertPopupReject(WebDriver driver) {
		waitForAlertToAppear(driver);
		driver.switchTo().alert().dismiss();
	}
	
	public String alertPopupGetText(WebDriver driver) {
		waitForAlertToAppear(driver);
		return driver.switchTo().alert().getText();
	}
	
	public void alertPopupSendKeys(WebDriver driver, String text) {
		waitForAlertToAppear(driver);
		driver.switchTo().alert().sendKeys(text);
	}
	
	
	
	
	public void implicitWait(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	public void waitForElementToAppear(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAlertToAppear(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions a = new Actions(driver);
		a.scrollByAmount(x , y).perform();
	}
}
