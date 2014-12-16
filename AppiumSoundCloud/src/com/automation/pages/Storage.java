package com.automation.pages;

import com.automation.core.AppiumCommands;
import com.automation.core.Validation;

public class Storage 
{
	
	private AppiumCommands appiumcommand = new AppiumCommands();
	
	public Validation isStoragePageOpened()
	{
		return new Validation("Storage", HeaderBar.getHeader());
	}

	public Validation areMemoryDetailsCorrect() 
	{
		return new Validation("Storage", HeaderBar.getData());
		
	}
	

}
