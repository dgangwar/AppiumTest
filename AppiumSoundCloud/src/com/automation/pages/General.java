package com.automation.pages;

import com.automation.core.AppiumCommands;
import com.automation.core.Validation;

public class General 
{
	private AppiumCommands appiumcommand = new AppiumCommands();
	
	public Validation isGeneralPageOpened()
	{
		return new Validation("General", HeaderBar.getHeader());
	}
	
	public Validation isDeviceNameDisplayed()
	{
		String DeviceRow = appiumcommand.getAttributeAtLocator("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]","name");
		System.out.println(DeviceRow);
		return new Validation("Apple Unknown",DeviceRow);
	}
	
	public Validation isHostNameDisplayed()
	{
		String HostRow = appiumcommand.getText("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]");
		System.out.println(HostRow);
		return new Validation("dharmeshs-air.lan", HostRow);
	}
	
	
}
