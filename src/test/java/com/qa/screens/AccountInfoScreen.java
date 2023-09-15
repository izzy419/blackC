package com.qa.screens;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountInfoScreen extends BaseTest{
	public AccountInfoScreen (AppiumDriver driver) {
		  PageFactory.initElements(new AppiumFieldDecorator(driver) ,this); }
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"com.blackcopper:id/setup-account-details-bank-select-field\"]/android.view.ViewGroup/android.view.ViewGroup[2]") private WebElement bankNameFld;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText") private WebElement accountNumber;
	@AndroidFindBy (accessibility = "com.blackcopper:id/setup-account-submit-continue-button") private WebElement continueBtn;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]")private WebElement acctName;
	@AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]") private WebElement disMsg;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView") private WebElement continueBtn1;

	 public BanklistScreen bankName () {
		 click(bankNameFld);
		 return new BanklistScreen(driver);
	 }
	 
	 public AccountInfoScreen enterAccctNO (String acctNo) {
		 sendKeys(accountNumber, acctNo);
		 return this;
	 }
	 
	 public AccountInfoScreen getAcctName () {
		 getAttribute(acctName, "text");
		 return this;
	 }
	 
	 public AccountInfoScreen pressContinueBtn() {
		 click(continueBtn);
		 return this;
	 }
	 
	 public AccountInfoScreen getDisplayMsg () {
		 getAttribute(disMsg, "text");
		 return this;
	 }
	 
	 public Dashboard pressContinueBtn1 () {
		 click(continueBtn1);
		 return new Dashboard(driver);
	 }
	 
	 
	 
	 
}
