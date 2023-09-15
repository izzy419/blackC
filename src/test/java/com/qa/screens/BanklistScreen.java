package com.qa.screens;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BanklistScreen extends AccountInfoScreen{

	
	public BanklistScreen(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")private WebElement searchbankNameFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup") private WebElement bankName;

	 public BanklistScreen enterBankName (String bankName) {
		 sendKeys(searchbankNameFld, bankName);
		 return this;
	 }
	 
	 public AccountInfoScreen selectBank () {
		 click(searchbankNameFld);
		 return new AccountInfoScreen(driver);
	 }
}
