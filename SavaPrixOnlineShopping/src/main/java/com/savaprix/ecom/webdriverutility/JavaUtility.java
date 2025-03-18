package com.savaprix.ecom.webdriverutility;

import java.util.Random;

import com.savaprix.ecom.fileutility.Constants;

public class JavaUtility implements Constants{
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(RANDOM_NUMBER_RANGE);
	}
}
