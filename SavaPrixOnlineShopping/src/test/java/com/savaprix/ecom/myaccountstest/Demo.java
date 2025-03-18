package com.savaprix.ecom.myaccountstest;


import java.io.IOException;

import org.testng.annotations.Test;
import com.savaprix.ecom.basetest.BaseClass;
import com.savaprix.ecom.objectRepository.HomePage;

public class Demo extends BaseClass{
	
	@Test
	public void sampleTest() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.userLoginFromHomePage(null, null);
	}

}
