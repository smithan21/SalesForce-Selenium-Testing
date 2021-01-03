package com.tekarch.SalesForceTesting;

public class SFDCLogin extends SFUtility{

	public static void main(String[] args) throws Exception {
		launchBrowser();
		goToSalesForceURL();
		loginToSalesForce();
		quitBrowser();
	
	}

}
