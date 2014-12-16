package com.automation.core;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	private static AppiumDriver driver;
	
 
	public static AppiumDriver getDriver()
	{

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(
				classpathRoot,
				"../../../Library/Developer/Xcode/DerivedData/SystemMonitor-boybtlcxvounyedxgfzonaqexlym/Build/Products/Debug-iphonesimulator/");
		File app = new File(appDir, "SystemMonitor.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("platformName", "iOS");
//		capabilities.setCapability("deviceName", "iPhone Retina 4-inch");
//		capabilities.setCapability("deviceName", "iPhone");
		capabilities.setCapability("deviceName", "iPhone Simulator");
		capabilities.setCapability("app", app.getAbsolutePath());
//		capabilities.setCapability("autoAcceptAlerts", true);
//		capabilities.setCapability("autoLaunch", false);
//		capabilities.setCapability("bundleId","com.antennasoftware.enterprise.sharebuilder");
		try {
			if(driver == null)
			{
			driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
