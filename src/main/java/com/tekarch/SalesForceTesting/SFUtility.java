package com.tekarch.SalesForceTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFUtility {
	
	public static WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void goToSalesForceURL() {
		driver.get("https://tekarch36-dev-ed.my.salesforce.com/");

	}
	
	public static void waitExplicitly (int iSeconds, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, iSeconds);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void quitBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	public static void loginToSalesForce() {
		WebElement ele = driver.findElement(By.id("username"));
		waitExplicitly(5, ele);
		ele.clear();
		ele.sendKeys("sn21@abc.com");
		driver.findElements(By.xpath("//input[@id = 'password']")).clear();
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("A12b12345");
		driver.findElement(By.xpath("//input[@id = 'Login']")).click();
		
	}
	
	public static void closePopUpWindow() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
	}
	
	public static void userMenuDropDown() {
		driver.findElement(By.id("userNavLabel")).click();
		
	}
	
	public static void openAccountTab() {
		driver.findElement(By.xpath("//ul//li[@id='Account_Tab']")).click();
	}
	
	public static void openOpportunityTab() {
		driver.findElement(By.xpath("//ul//li[@id='Opportunity_Tab']")).click();
	}
	
	public static void openLeadsTab() {
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	}
	
	public static void openContactsTab() {
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}
	
	public static void LogoutSalesForce() {
		
		waitExplicitly(3, driver.findElement(By.id("userNavLabel")));
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

}
