package org.project;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectDayOne {
	
	static WebDriver driver;
	static Date d;
	
	@BeforeClass
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\oficj\\Raj\\ProjectClass\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	private void exitBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	private void startTime() {
		d = new Date();
	}
	
	@AfterMethod
	private void endTime() {
		d = new Date();
	}
	
	@Test
	private void AscendingOrder() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone 11");
		
		WebElement find = driver.findElement(By.xpath("//input[@type='submit']"));
		find.click();
		
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		System.out.println("Size: " + products.size());
		System.out.println("Actual Order");
		
		String productsNames;
		String priceValues;
		
		for (int i = 0; i < products.size(); i++) {
			WebElement productList = products.get(i);
			productsNames = productList.getText();
			System.out.println(productsNames);
			WebElement priceList = price.get(i);
			priceValues = priceList.getText();
			System.out.println(priceValues);
		}
		
		System.out.println(" ");
		System.out.println("Ascending Order");
		
		String productsName;
		String priceValue;
		int int_priceValue;
		
		TreeMap<Integer, String> a = new TreeMap<Integer, String>();
		for (int i = 0; i < products.size(); i++) {
			WebElement productList = products.get(i);
			productsName = productList.getText();
			WebElement priceList = price.get(i);
			priceValue = priceList.getText();
			priceValue = priceValue.replaceAll("[^0-9]", "");
			int_priceValue = Integer.parseInt(priceValue);
			String put = a.put(int_priceValue, productsName);
			System.out.println(put);
		}
	}
}
