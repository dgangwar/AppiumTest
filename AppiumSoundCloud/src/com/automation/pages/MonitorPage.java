package com.automation.pages;

import com.automation.core.AppiumCommands;
import com.automation.core.Validation;

public class MonitorPage 
{
	
	private General general = new General();
	private CPU cpu;
	private Processes processes;
	private RAM ram;
	private GPU gpu;
	private Network network;
	private Connections Connections;
	private Storage storage = new Storage();
	private Battery battery;
	private MonitorPage monitorPage;
	AppiumCommands appiumCommands = new AppiumCommands();
	
	public General goToGeneral()
	{
		appiumCommands.click("General");
		return	general;
	}
	
	public CPU goToCPU()
	{
		return	cpu;
	}
	public Processes goToProcesses()
	{
		return	processes;
	}
	public RAM goToRAM()
	{
		return	ram;
	}
	public GPU goToGPU()
	{
		return	gpu;
	}
	public Network goToNetwork()
	{
		return	network;
	}
	public Connections goToConnections()
	{
		return	Connections;
	}
	public Storage goToStorage()
	{
		appiumCommands.click("Storage");
		return storage;
	}

	public Battery goToBattery()
	{
		return	battery;
	}
	
	public Validation isDeafultOrientationPortrait()
	{
		return new Validation(appiumCommands.getOrientation(), "PORTRAIT");
	}
	
	public MonitorPage launchApp()
	{
		appiumCommands.launchApp();
		return monitorPage;
	}
	
	public MonitorPage closeApp()
	{
		appiumCommands.launchApp();
		return monitorPage;
	}
	
}
