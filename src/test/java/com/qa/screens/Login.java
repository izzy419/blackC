package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login extends BaseTest {



	public Login (AppiumDriver driver) {
		  PageFactory.initElements(new AppiumFieldDecorator(driver) ,this); }

	// 
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText") private WebElement emailOrPhonenumberTxtFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.EditText") private WebElement passwordTxtFld;
	@AndroidFindBy (accessibility = "com.blackcopper:id/login-screen-submit-button") private WebElement loginButton;

	@AndroidFindBy (accessibility = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") private WebElement allowLocationAcc;
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]") private WebElement errorMsg;
	
	
	
    @AndroidFindBy (accessibility = "com.blackcopper:id/alert-default-dismiss-button") private WebElement dismissBtn;
	
    
	
	 public Login enterEmailorPhone (String email) {
		 sendKeys(emailOrPhonenumberTxtFld, email);
		 return this;
	 }
	 
	 public Login enterEmailorPhoneClear () {
		 clear(emailOrPhonenumberTxtFld);
		 return this;
	 }
	 
	 
	 
	 public Login enterPassword (String password) {
		 sendKeys(passwordTxtFld, password);
		 return this;
	 }
	 
	 public Login enterPasswordClear () {
		 clear(passwordTxtFld);
		 return this;
	 }
	 
	 public Dashboard pressLoginBtn() {
		 click(loginButton);
		 return new Dashboard(driver);
	 }
	 

	 
	 public Login pressDismissBtn () {
		 click(dismissBtn);
		 return this;
	 }

		/*
		 * public Dashboard locAccess () { click(allowLocationAcc); return new
		 * Dashboard(driver); }
		 */
	 
	 public String getErrMsg() {
		 return getAttribute(errorMsg, "text");
	 }

	
	 
	
}


  


