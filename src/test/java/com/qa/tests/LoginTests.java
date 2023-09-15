package com.qa.tests;

import org.testng.annotations.Test;import com.qa.BaseTest;
import com.qa.screens.AccountInfoScreen;
import com.qa.screens.Dashboard;
import com.qa.screens.Login;
import com.qa.screens.NavScreen;
import com.qa.screens.ProfileScreen;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest {

	Login login;
	Dashboard dashboard;
	NavScreen navScreen;
	ProfileScreen profile;
	AccountInfoScreen acctInfo;
	InputStream loginData;
	JSONObject loginUsers;
	
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		try {
			String dataFileName = "testdata/loginUsers.json";
			loginData = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(loginData);
			loginUsers = new JSONObject(tokener);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally {
			if(loginData != null) {
				loginData.close();
			}
		}
	  }
	
	  @AfterClass
	  public void afterClass() {
	  }
	  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	  login = new Login(driver);
	  System.out.println("\n" + " ****** starting test: " + m.getName()+ "***** " + "\n");
  }

  @AfterMethod
  public void afterMethod() {
  }

  
  
  @Test
  public void invalidEmailOrPhone() {
	  login.enterEmailorPhone(loginUsers.getJSONObject("invalidEmailOrPhone").getString("email"));
	  login.enterPassword(loginUsers.getJSONObject("invalidEmailOrPhone").getString("password"));
	  login.pressLoginBtn();
	  
	  String actualErrorMsg = login.getErrMsg();
	  String expectedErrorMsg = "Invalid user name or password entered, please check and try again.";
	  
	  System.out.println("Actaul error message: " + actualErrorMsg + "\n" + " Expected error message: " + expectedErrorMsg);
	  
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  
	  login.pressDismissBtn();
	  login.enterEmailorPhoneClear();
	  login.enterPasswordClear();
	  
	  
  }
  
  @Test
  public void invalidPassword() {
	  login.enterEmailorPhone(loginUsers.getJSONObject("inavlidPassword").getString("email"));
	  login.enterPassword(loginUsers.getJSONObject("inavlidPassword").getString("password"));
	  login.pressLoginBtn();
	  
	  String actualErrorMsg = login.getErrMsg();
	  String expectedErrorMsg = "Invalid user name or password entered, please check and try again.";
	  
	  System.out.println("Actaul error message: " + actualErrorMsg + "\n " + " Expected error message: " + expectedErrorMsg);
	  
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  
	  login.pressDismissBtn();
	  login.enterEmailorPhoneClear();
	  login.enterPasswordClear();
	  	  
  }
  
  @Test
  public void successfulLogin() throws Exception {
	  login.enterEmailorPhone(loginUsers.getJSONObject("validEmailAndPassword").getString("email"));
	  login.enterPassword(loginUsers.getJSONObject("validEmailAndPassword").getString("password"));
	  dashboard = login.pressLoginBtn();
	  
	  String actualDash = dashboard.getAccNo();
	  String expectedDash = "1026131920";
	  
	  System.out.println("Actual Dashboard Display: " + actualDash + "\n " + "Expected Dashboard Display: " + expectedDash);
	  
	  Assert.assertEquals(actualDash, expectedDash);
	  
	  
  }

}
