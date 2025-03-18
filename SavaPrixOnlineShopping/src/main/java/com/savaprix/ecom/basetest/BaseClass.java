package com.savaprix.ecom.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.savaprix.ecom.fileutility.Constants;
import com.savaprix.ecom.fileutility.ExcelUtility;
import com.savaprix.ecom.fileutility.FileUtility;
import com.savaprix.ecom.webdriverutility.JavaUtility;
import com.savaprix.ecom.webdriverutility.UtilityClassObject;
import com.savaprix.ecom.webdriverutility.WebdriverUtility;


public class BaseClass implements Constants{
	public WebDriver driver;
	public FileUtility fU = new FileUtility();
	public JavaUtility jU = new JavaUtility();
	public WebdriverUtility wU = new WebdriverUtility();
	public ExcelUtility eU = new ExcelUtility();
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(@Optional("chrome") String browser) throws IOException {
		switch (browser) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
		}	
		wU.implicitWait(driver);
		driver.get(fU.getDataFromPropertyFile("url"));
		UtilityClassObject.setDriver(driver);
	}
	 
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		driver.get(fU.getDataFromPropertyFile("url"));  // website always logs out and stays on the homepage so to reset everything, i used .get() here too
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
	}
}
