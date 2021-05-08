package com.wallethub;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookAssignment {
	
	public static RemoteWebDriver driver;
	public Properties prop;
	public String userName , password, url, postMessage ; 
	
	@BeforeTest
	public void setUpTestData() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			userName = prop.getProperty("username");
			password = prop.getProperty("password");
			url = prop.getProperty("URL");
			postMessage = prop.getProperty("postmessage");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void facebookStatus() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'email']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'pass']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name = 'login']")));
			driver.findElementByXPath("//input[@id = 'email']").sendKeys(userName);
			driver.findElementByXPath("//input[@id = 'pass']").sendKeys(password);
			driver.findElementByXPath("//button[@name = 'login']").click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text() , 'on your mind')]")));
			driver.findElementByXPath("//span[contains(text() , 'on your mind')]").click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text() , 'on your mind')]")));
			
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElementByXPath("//div[contains(text() , 'on your mind')]")).perform();
			builder.click().perform();
			builder.sendKeys(postMessage).perform();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Post']")));
			builder.click(driver.findElementByXPath("//span[text() = 'Post']")).perform();
			
		} catch (Exception e) {
			throw new Exception("Failed due to exception : "+e.getMessage());
		}finally {
			driver.quit();
		}
	}
}
