package com.wallethub;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinks {
	static WebDriver driver ;
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<String> imagesAndLinksURL = new ArrayList<String>();
		
		List<WebElement> tagLinks = driver.findElements(By.tagName("a"));
		List<WebElement> tagImages = driver.findElements(By.tagName("img"));
		
		for (WebElement ele : tagLinks) {
			if (ele.getAttribute("href")!= null) {
				imagesAndLinksURL.add(ele.getAttribute("href"));
			}
		}
		
		for (WebElement ele : tagImages) {
			if (ele.getAttribute("src")!= null) {
				imagesAndLinksURL.add(ele.getAttribute("src"));
			}
		}
		System.out.println("Total number of links and images are :"+imagesAndLinksURL.size());
		
		for (String links : imagesAndLinksURL) {
			try {
				HttpURLConnection urls = (HttpURLConnection) (new URL(links)).openConnection();
				urls.connect();
				System.out.println("Th response message is : "+urls.getResponseMessage()+" The response codes are : "+urls.getResponseCode());
				urls.disconnect();
			} catch (Exception e) {
				continue;
			}
		}
	}

}
