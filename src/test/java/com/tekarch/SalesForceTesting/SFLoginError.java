package com.tekarch.SalesForceTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SFLoginError {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.get("https://tekarch36-dev-ed.my.salesforce.com/");
		
		driver.findElement(By.xpath("//a[@id='forgot_password_link']")).click();
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("sn21@abc.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		System.out.println(driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/div[@id='wrapper']/div[@id='content']/div[@id='forgotPassForm']/div[1]")).getText());
		
		driver.quit();

	}
}
