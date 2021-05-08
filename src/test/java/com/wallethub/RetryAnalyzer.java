package com.wallethub;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	public int counter = 0;

	public boolean retry(ITestResult result) {
		while (counter < 3) {
			counter++;
			return true;
		}
		return false;
	}

}
