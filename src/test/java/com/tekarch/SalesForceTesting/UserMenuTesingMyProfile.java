package com.tekarch.SalesForceTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserMenuTesingMyProfile extends SFUtility{

	public static void main(String[] args) throws Exception {
		
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		userMenuDropDown();
		
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
		
		testingChangeLastName();
		testingPost();
		testingUploadFile();
		testingUploadPhoto();
	
		
		quitBrowser();
		
	}
		
		public static void testingChangeLastName() throws Exception{
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[2]/div[1]/h3[1]/div[1]/div[1]/a[1]/img[1]")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']")));
		
		waitExplicitly(2, driver.findElement(By.xpath("//a[contains(text(),'About')]")));
		driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
		
		waitExplicitly(2, driver.findElement(By.xpath(" //input[@id='lastName']")));
		driver.findElement(By.xpath(" //input[@id='lastName']")).clear();
		driver.findElement(By.xpath(" //input[@id='lastName']")).sendKeys("Manu");
		
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        
        System.out.println("Name updated to "+driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).getText());
        
		}
		
		public static void testingPost() throws Exception{
        
        waitExplicitly(3, driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']")));
		driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']")).click();
		
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iFrame[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//body")).sendKeys("Hello! Everyone. Have a good day.");
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
 		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
 		
		}
		
		public static void testingUploadFile() throws Exception{
	 
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']")).click();
        waitExplicitly(3, driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")));
        driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']")).click();
        waitExplicitly(3, driver.findElement(By.xpath("//input[@id='chatterFile']")));
        driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys("C:\\Users\\Manu-Thinkpad\\Desktop\\Tekarch\\SFDC 37 Testcases.xlsx");
        driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
			
		}
		
		public static void testingUploadPhoto() throws Exception{
		
		Actions action = new Actions(driver);
		WebElement mHover = driver.findElement(By.xpath("//a[@id='uploadLink']"));
		action.moveToElement(mHover).click().build().perform();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']")));
		waitExplicitly(1, driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']")));
		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']")).sendKeys("C:\\Users\\Manu-Thinkpad\\Desktop\\Selenium.png");
		driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:save']")).click();
              
	}
}