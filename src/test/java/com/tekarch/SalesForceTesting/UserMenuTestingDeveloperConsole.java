package com.tekarch.SalesForceTesting;

import java.util.ArrayList;

import org.openqa.selenium.By;

public class UserMenuTestingDeveloperConsole extends SFUtility {

	public static void main(String[] args) throws Exception {
		
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		userMenuDropDown();
		driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]")).click();
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows.size());
		driver.switchTo().window(windows.get(1));
		Thread.sleep(5000);
		driver.close();
		
		driver.switchTo().window(windows.get(0));
		
		LogoutSalesForce();
		
		quitBrowser();
		
	}

}
