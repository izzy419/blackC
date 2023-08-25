package com.qa.tests;

import org.testng.annotations.Test;import com.qa.BaseTest;
import com.qa.screens.Dashboard;
import com.qa.screens.Login;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest {

	Login login;
	Dashboard dashboard;
	
	
	
	@BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	  login = new Login(driver);
	  System.out.println("/n" + "****** starting test: " + m.getName()+ "*****" + "/n");
  }

  @AfterMethod
  public void afterMethod() {
  }

  
  
  @Test
  public void invalidEmailOrPhone() {
	  login.enterEmailorPhone("Oladehinde@gmail");
	  login.enterPassword("Damilola1");
	  login.pressLoginBtn();
	  login.pressDismissBtn();
	  login.enterEmailorPhoneClear();
	  login.enterPasswordClear();
	  
	  String actualErrorMsg = login.getErrMsg();
	  String expectedErrorMsg = "Invalid user name or password entered, please check and try again.";
	  
	  System.out.println("Actaul error message: " + actualErrorMsg + "/n" + "Expected error message: " + expectedErrorMsg);
	  
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
  }
  
  @Test
  public void invalidPassword() {
	  login.enterEmailorPhone("Oladehindedammi@gamil.com");
	  login.enterPassword("Damilola");
	  login.pressLoginBtn();
	  
	  String actualErrorMsg = login.getErrMsg();
	  String expectedErrorMsg = "Invalid user name or password entered, please check and try again.";
	  
	  System.out.println("Actaul error message: " + actualErrorMsg + "/n" + "Expected error message: " + expectedErrorMsg);
	  
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  
	  login.pressDismissBtn();
	  login.enterEmailorPhoneClear();
	  login.enterPasswordClear();
	  
	  
	  
  }
  
  @Test
  public void successfulLogin() {
	  login.enterEmailorPhone("Oladehindedammi@gamil.com");
	  login.enterPassword("Damilola1");
	  login = login.pressLoginBtn();
	  
	  String actualDash = dashboard.getAccNo();
	  String expectedDash = "1026131920";
	  
	  System.out.println("Actual Dashboard Display: " + actualDash + "/n" + "Expected Dashboard Display: " + expectedDash);
	  
	  Assert.assertEquals(actualDash, expectedDash);
	  
  }

}
