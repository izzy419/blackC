package com.qa;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	protected AppiumDriver driver;
	protected Properties props;
	InputStream inputStream;
	
	
 
  @BeforeTest
  public void beforeTest(String platformName, String platformVersion, String deviceName ) throws Exception {
	   
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
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		  
	  } catch (Exception e) {
		  e.printStackTrace();
		  throw e;
	  }
	  
	  }

	

  @AfterTest
  public void afterTest() {
  }

}
