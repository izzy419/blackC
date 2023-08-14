package blackC;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverSession {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_4");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.UDID,"emulator-5554" );		
		caps.setCapability("appPackage", "app.web.foomigate");		
		caps.setCapability("appActivity", "app.web.foomigate.MainActivity");
		caps.setCapability("newCommandTimeout", 300);
		
		URL url = new URL("http://localhost:4723/wd/hub");
		
		AppiumDriver driver = new AndroidDriver(url, caps);
		
		System.out.println("session_id " + driver.getSessionId());
		
		driver.close();
	
	
	}
	
	

}
