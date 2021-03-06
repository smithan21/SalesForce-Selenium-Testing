package com.tekarch.SalesForceTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFForgotPwd2 {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.get("https://tekarch36-dev-ed.my.salesforce.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		driver.findElement(By.id("username")).sendKeys("123");
		driver.findElements(By.xpath("//input[@id = 'password']")).clear();
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("22131");
		
		driver.findElement(By.xpath("//input[@id = 'Login']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='error']")).getText());
		
		driver.quit();
		

}
}