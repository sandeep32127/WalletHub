package com.wallethub;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicGoogleSearch {
	WebDriver driver = null;
	
	@Test
	public void dynamicSearch() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("testing");
		
		List<WebElement> suggestions = driver.findElements
				(By.xpath("//div[@class = 'aajZCb']/ul/li//div[@class ='sbtc']"));////div[@class = 'aajZCb']/ul//li/descendant::div[@class ='sbtc']
		
		for (WebElement webElement : suggestions) {
			System.out.println("all the suggestions displayed are : " +webElement.getText().trim() );
		}
		
		for (WebElement webElement : suggestions) {
			if (webElement.getText().trim().equals("testing course")) {
				webElement.click();
				break;
			}
		}
		
	}

}
