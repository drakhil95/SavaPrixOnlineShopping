package com.savaprix.ecom.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.savaprix.ecom.fileutility.Constants;

public class RetryListenerImp implements IRetryAnalyzer, Constants{
	int count = 0;
	@Override
	public boolean retry(ITestResult result) {
		if (count < RETRY_ANALYZER_COUNT) {
			count++;
			return true;
		}
		return false;
	}
}
