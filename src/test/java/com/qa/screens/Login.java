package com.qa.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login extends BaseTest {
	
	public Login (AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
	}

	/*
	 * @AndroidFindBy (accessibility = "com.blackcopper:id/welcome-skip-button")
	 * private WebElement skipButton;
	 * 
	 * @AndroidFindBy (accessibility =
	 * "com.blackcopper:id/location-notice-agreement--button") private WebElement
	 * agreeToTermsCheckbox;
	 * 
	 * @AndroidFindBy (accessibility =
	 * "com.blackcopper:id/location-notice-continue--button") private WebElement
	 * okayContinueButton;
	 * 
	 * @AndroidFindBy (accessibility =
	 * "com.blackcopper:id/landing-screen-login-button") private WebElement
	 * landingScreenLoginButton;
	 */
	
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText") private WebElement emailOrPhonenumberTxtFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.EditText") private WebElement passwordTxtFld;
	@AndroidFindBy (accessibility = "com.blackcopper:id/login-screen-submit-button") private WebElement loginButton;
	
	
	
	 public Login enterEmailorPhone (String email) {
		 sendKeys(emailOrPhonenumberTxtFld, email);
		 return this;
	 }
	 
	 public Login enterPassword (String password) {
		 sendKeys(passwordTxtFld, password);
		 return this;
	 }
	 
	 public Login pressLoginBtn() {
		 click(loginButton);
		 return this;
	 }
	 
}

  


