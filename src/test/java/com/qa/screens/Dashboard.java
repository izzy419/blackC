package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dashboard extends BaseTest{

	public Dashboard (AppiumDriver driver) {
		  PageFactory.initElements(new AppiumFieldDecorator(driver) ,this); }


	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"com.blackcopper:id/home-copy-account-number-button\"]/android.widget.TextView[1]") private WebElement dashbrdAcctNo;
	
	
	 public String getAccNo() {
		 return getAttribute(dashbrdAcctNo, "text");
 
	 }
	 
}
