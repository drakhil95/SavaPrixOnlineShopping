package com.savaprix.ecom.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.savaprix.ecom.basetest.BaseClass;
import com.savaprix.ecom.objectRepository.HomePage;
import com.savaprix.ecom.objectRepository.HomePageLoggedIn;
import com.savaprix.ecom.objectRepository.MyAccounts;
import com.savaprix.ecom.objectRepository.MyAccountsLoggedIn;
import com.savaprix.ecom.objectRepository.MyCartPage;
import com.savaprix.ecom.objectRepository.MyWishlist;
import com.savaprix.ecom.objectRepository.OrderHistoryPage;
import com.savaprix.ecom.objectRepository.PaymentPage;
import com.savaprix.ecom.objectRepository.PaymentPendingPage;
import com.savaprix.ecom.objectRepository.ProductsInformationPage;


@Listeners(com.savaprix.ecom.listenerutility.ListenerImpClass.class)
public class HomePageTest extends BaseClass {
	String sheetName = "UserData";
	String un = eU.getDataFromExcel(sheetName, 1, 0);
	String pw = eU.getDataFromExcel(sheetName, 1, 3);
	String contact = eU.getDataFromExcel(sheetName, 1, 2);
	String email = eU.getDataFromExcel(sheetName, 1, 1);

	@Test(groups = "Smoke")
	public void registerAsUserTest() {
		
		HomePage hp = new HomePage(driver);
		MyAccounts ma = new MyAccounts(driver);
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		String sheetName = "UserData";
		String un = eU.getDataFromExcel(sheetName, 1, 0);
		String pw = eU.getDataFromExcel(sheetName, 1, 3);
		String contact = eU.getDataFromExcel(sheetName, 1, 2);
		String email = eU.getDataFromExcel(sheetName, 1, 1);
		
	    email = "akhil"+jU.getRandomInt()+"@gmail.com";  // To generate unique email
		
		hp.getMyAccountBtn().click();
		ma.createAccount(un, email, contact, pw);
		ma.loginAsUser(email, pw); 
		Assert.assertTrue(hpli.welcomeMsgVerify(un));  // verifying the welcome message
		hpli.logoutAsUser();
	}
	
	@Test(groups = "Regression")
	public void addProductToCart() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		
		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		
		driver.findElement(By.linkText("Asus Strix G16")).click();    // TODO: Change this statement to dynamic one like the one below
		//h3[@class='name']/a[contains(text(),'Adidas MESSI 16.3 TF Football turf Shoes')]
		
		pip.getAddToCartBtn().click();
		wU.alertPopupAccept(driver);
		
		WebElement ele =  driver.findElement(By.xpath("//h4//a[text()='Asus Strix G16']"));
		Assert.assertTrue(ele.isDisplayed());
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	@Test(groups = "Regression")
	public void addProductToWishList() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		
		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		driver.findElement(By.linkText("Asus Strix G16")).click();
		pip.getAddToWishlistBtn().click();

		boolean res1 = "My Wishlist".equals(driver.getTitle()); 
		Assert.assertTrue(res1);
		
		boolean res2 = driver.findElement(By.linkText("Asus Strix G16")).isDisplayed();
		Assert.assertTrue(res2);
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	
	@Test(groups = "Regression")
	public void addProductFromWishlistToCart() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		MyWishlist mwl = new MyWishlist(driver);
		
		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		driver.findElement(By.linkText("Asus Strix G16")).click();
		pip.getAddToWishlistBtn().click();
		Assert.assertTrue(mwl.getAddToCartBtn().isDisplayed());
		
		mwl.getAddToCartBtn().click(); 
		// TODO: write assertion for the product being added to the cart
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
		
	}
	
	@Test(groups = "Regression")
	public void addProductToCartAndUpdateAddress() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		
		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		
		driver.findElement(By.linkText("Asus Strix G16")).click();    // TODO: Change this statement to dynamic one like the one below
		//h3[@class='name']/a[contains(text(),'Adidas MESSI 16.3 TF Football turf Shoes')]
		
		pip.getAddToCartBtn().click();
		wU.alertPopupAccept(driver);
		mcp.updateShippingAddress(un, pw, email, contact);
		wU.alertPopupAccept(driver);
		mcp.updateBillingAddress(un, pw, email, contact);
		wU.alertPopupAccept(driver);
		
		WebElement ele =  driver.findElement(By.xpath("//h4//a[text()='Asus Strix G16']"));
		Assert.assertTrue(ele.isDisplayed());
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	
	@Test(groups = "Smoke")
	public void placeOrder() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		PaymentPage pp = new PaymentPage(driver);
		OrderHistoryPage ohp = new OrderHistoryPage(driver);

		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		
		driver.findElement(By.linkText("Asus Strix G16")).click();    // TODO: Change this statement to dynamic one like the one below
		//h3[@class='name']/a[contains(text(),'Adidas MESSI 16.3 TF Football turf Shoes')]
		
		pip.getAddToCartBtn().click();
		wU.alertPopupAccept(driver);
		wU.scrollByAmount(driver, 0, 400);
		mcp.getCheckoutBtn().click();
		pp.getInternetBankingRadioBtn().click();
		pp.getSubmitBtn().click();
		ohp.verifyLatestOrder("Asus Strix G16");
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	@Test(groups = "Regression")
	public void completePendingOrder() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		PaymentPage pp = new PaymentPage(driver);
		OrderHistoryPage ohp = new OrderHistoryPage(driver);
		MyAccountsLoggedIn mali = new MyAccountsLoggedIn(driver);
		PaymentPendingPage ppp = new PaymentPendingPage(driver);
		
		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		
		driver.findElement(By.linkText("Asus Strix G16")).click();    // TODO: Change this statement to dynamic one like the one below
		//h3[@class='name']/a[contains(text(),'Adidas MESSI 16.3 TF Football turf Shoes')]
		
		pip.getAddToCartBtn().click();
		wU.alertPopupAccept(driver);
		wU.scrollByAmount(driver, 0, 400);
		mcp.getCheckoutBtn().click();
		
		hp.getMyAccountBtn().click();
		mali.getPaymentPendingLink().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP + 300);
		ppp.getProceedToPayBtn().click();
		
		pp.getInternetBankingRadioBtn().click();
		pp.getSubmitBtn().click();
		ohp.verifyLatestOrder("Asus Strix G16");
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	
	@Test(groups = "Regression")
	public void removeProductsFromPaymentPendingPage() {
		HomePage hp = new HomePage(driver);
		ProductsInformationPage pip = new ProductsInformationPage(driver);
		MyCartPage mcp = new MyCartPage(driver);
		MyAccountsLoggedIn mali = new MyAccountsLoggedIn(driver);
		PaymentPendingPage ppp = new PaymentPendingPage(driver);
		
		hp.userLoginFromHomePage(email, pw);
		hp.getElectronicsBtn().click();
		wU.scrollByAmount(driver, 0, SCROLL_AMOUNT_FOR_SIGNUP);
		
		driver.findElement(By.linkText("Asus Strix G16")).click();    // TODO: Change this statement to dynamic one like the one below
		//h3[@class='name']/a[contains(text(),'Adidas MESSI 16.3 TF Football turf Shoes')]
		
		pip.getAddToCartBtn().click();
		wU.alertPopupAccept(driver);
		wU.scrollByAmount(driver, 0, 400);
		mcp.getCheckoutBtn().click();
		
		hp.getMyAccountBtn().click();
		mali.getPaymentPendingLink().click();
		ppp.deletePendingProduct("Asus Strix G16");
		Assert.assertTrue(ppp.getEmptyListMsg().isDisplayed());
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	@Test(groups = "Smoke")
	public void changeAccountDetails() {
		HomePage hp = new HomePage(driver);
		MyAccountsLoggedIn mali = new MyAccountsLoggedIn(driver);
		hp.userLoginFromHomePage(email, pw);
		hp.getMyAccountBtn().click();
		
		mali.getContactTbx().clear();
		mali.getContactTbx().sendKeys("9999999999");
		mali.getUpdateBtn().click();
		wU.alertPopupAccept(driver);
		String res = mali.getContactTbx().getDomAttribute("value");
		Assert.assertEquals(res, "9999999999");
		HomePageLoggedIn hpli = new HomePageLoggedIn(driver);
		hpli.logoutAsUser();
	}
	
	@Test(groups = "Smoke")
	public void loginWithInvalidCred() {
		HomePage hp = new HomePage(driver);
		hp.userLoginFromHomePage("akhil@gmail.com", "1234567");
	}
}
