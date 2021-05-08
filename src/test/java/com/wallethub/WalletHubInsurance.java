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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WalletHubInsurance {
	public static RemoteWebDriver driver;
	public Properties prop;
	public String userName , password, url ; 
	
	@BeforeTest
	public void setUpTestData() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			userName = prop.getProperty("wallethub_username");
			password = prop.getProperty("wallethub_password");
			url = prop.getProperty("wallethub_URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeReview() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Login']")));
		driver.findElementByXPath("//span[text() = 'Login']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Login']")));
		driver.findElementById("email").sendKeys(userName);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByXPath("//span[text() = 'Login']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//review-star[@class = 'rvs-svg']//div[@class = 'rating-box-wrapper']")));
		driver.findElementByXPath("//review-star[@class = 'rvs-svg']//div[@class = 'rating-box-wrapper']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Select...']")));
		driver.findElementByXPath("//span[text() = 'Select...']").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text() = 'Health Insurance']")));
		driver.findElementByXPath("//li[text() = 'Health Insurance']").click();
		driver.findElementByXPath("//textarea[@placeholder = 'Write your review...']").sendKeys("good reviews");
		driver.findElementByXPath("//div[text() = 'Submit']").click();
	}

}
