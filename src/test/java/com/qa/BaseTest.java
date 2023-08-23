package com.qa;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.utilis.Testutilis;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	protected  AppiumDriver driver;
	protected Properties props;
	InputStream inputStream;
	
	//public BaseTest (AppiumDriver driver) {
		// PageFactory.initElements(new AppiumFieldDecorator(driver) ,this);
	// }
	
	
 
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	   
	  try {
		  props = new Properties();
		  String propsFileName = "config.properties";
		  inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);
		  props.load(inputStream);
		  
		  DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("anyDeviceNmae"));
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
			caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");	
			
			/*
			 * URL appURL = getClass().getClassLoader().getResource(props.
			 * getProperty("app/blackcopper-release (7).apk")); caps.setCapability("app",
			 * appURL);
			 */
			
			caps.setCapability("appPackage", props.getProperty("androidAppPackage"));		
			caps.setCapability("appActivity",  props.getProperty("androidAppActivity"));
			
			
			
//			caps.setCapability("newCommandTimeout", 300);
			
			URL url = new URL(props.getProperty("appiumUrl"));
			
			 driver = new AndroidDriver(url, caps);
			 String sessionId = driver.getSessionId().toString();
				System.out.println(sessionId);	 
				
				By skipBtn = AppiumBy.accessibilityId("com.blackcopper:id/welcome-skip-button");
				By agreeToTermsCheckbox = AppiumBy.accessibilityId("com.blackcopper:id/location-notice-agreement--button");
				By okayContinueButton = AppiumBy.accessibilityId("com.blackcopper:id/location-notice-continue--button");
				By landingScreenLoginButton = AppiumBy.accessibilityId("com.blackcopper:id/landing-screen-login-button");
			
				driver.findElement(skipBtn).click();
				driver.findElement(agreeToTermsCheckbox).click();
				driver.findElement(okayContinueButton).click();
				driver.findElement(landingScreenLoginButton).click();
			
				
		  
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw e;
	  }
	  
	  }
  
        public void waitForVisibility(WebElement e) {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Testutilis.WAIT));
        	wait.until(ExpectedConditions.invisibilityOf(e));
        	 }
        
        public void click (WebElement e) {
        	waitForVisibility(e);
        	e.click();
        }
        
        public void sendKeys (WebElement e, String txt) {
        	waitForVisibility(e);
        	e.sendKeys(txt);
        }
        
        public void getAttribute (WebElement e, String attribute) {
        	waitForVisibility(e);
        	e.getAttribute(attribute);
        }
	

 @AfterTest
  public void afterTest() {
  }

}
