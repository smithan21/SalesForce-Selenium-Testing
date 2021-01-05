package com.tekarch.SalesForceTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestingLeads extends SFUtility {

	public static void main(String[] args) throws Exception {
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		openLeadsTab();
		closePopUpWindow();		
		
		//testingLeadsViewDropDown();
		//testingFunctionalityOfGoButton();
		//testingTodaysLeadsLink();
		testingLeadsNewButton();
		
		LogoutSalesForce();
		quitBrowser();

	}
	
	public static void testingLeadsViewDropDown() throws Exception {
		
		Select se = new Select(driver.findElement(By.id("fcf")));
		System.out.println("Following options available: ");
		List<WebElement> e = se.getOptions();
		int listSize = e.size();
		
		for (int i =0; i <listSize; i++) {
			
			System.out.println(e.get(i).getText());
			
		}
	}
	
	public static void testingFunctionalityOfGoButton() throws Exception {
		
		Select se1 = new Select(driver.findElement(By.id("fcf")));
		se1.selectByVisibleText("My Unread Leads");
		
		LogoutSalesForce();
		Thread.sleep(3000);
		loginToSalesForce();
		openLeadsTab();
		closePopUpWindow();
		
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' Go! ']")));
		driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
	}
	
	public static void testingTodaysLeadsLink() throws Exception {
		
		Select se1 = new Select(driver.findElement(By.id("fcf")));
		se1.selectByVisibleText("Today's Leads");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' Go! ']")));
		driver.findElement(By.xpath("//input[@value=' Go! ']")).click();
	}
	
	public static void testingLeadsNewButton() throws Exception{
		
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='name_lastlea2']")));
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys("ABCD");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@id='lea3']")));
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ABCD");
		waitExplicitly(2, driver.findElement(By.xpath("//input[@value=' Save ']")));
		driver.findElement(By.xpath("//input[@value=' Save ']")).click();

	}

}
