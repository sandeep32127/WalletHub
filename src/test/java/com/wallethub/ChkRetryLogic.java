package com.wallethub;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ChkRetryLogic {
	
	@Test
	public void Test1() {
		System.out.println("Checking Retry");
		Assert.assertTrue(false);
	}
	
	@Test
	public void Test2() {
		try {
		System.out.println("Checking Retry");
		Assert.assertTrue(true);
	}finally {
		
	}
	}

}
