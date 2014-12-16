package com.automation.appium.test;

import org.testng.annotations.Test;

import com.automation.core.BaseAppium;
import com.automation.pages.MonitorPage;

public class TestStorage extends BaseAppium
{
	MonitorPage monitorPage = new MonitorPage();
	
	
	@Test()
	public void testStorageInformation() throws Exception 
	{
		monitorPage.launchApp();	
		//monitorPage.goToStorage().isStoragePageOpened().shouldBeEqual("Header is wrong");
		monitorPage.goToStorage().areMemoryDetailsCorrect();
		
		
		
	}

}
