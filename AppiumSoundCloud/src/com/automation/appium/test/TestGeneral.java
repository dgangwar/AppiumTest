package com.automation.appium.test;

import org.testng.annotations.Test;

import com.automation.core.BaseAppium;
import com.automation.pages.MonitorPage;

public class TestGeneral extends BaseAppium {
	
	MonitorPage monitorPage = new MonitorPage();
	
	
	@Test()
	public void testDeviceInformation() throws Exception 
	{
		monitorPage.launchApp();	
		//monitorPage.goToGeneral().isDeviceNameDisplayed().shouldBeEqual("Device information is not correct");
		monitorPage.goToGeneral().isGeneralPageOpened().shouldBeEqual("Header is wrong");
		
	}

}