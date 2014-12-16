package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

import com.automation.core.AppiumCommands;
import com.automation.core.DriverFactory;
import com.automation.core.Validation;

public class HeaderBar 
{
	private AppiumCommands appiumCommands;
	static AppiumDriver driver = DriverFactory.getDriver();
	
	public MonitorPage goBack()
	{
		driver.findElementByAccessibilityId("Back").click();
		return new MonitorPage();
	}
	
	private static String getPageName()
	{
		WebElement element =  driver.findElementByXPath("//UIANavigationBar[1]");

		System.out.println(element.getSize());
		System.out.println(element.getLocation());
		System.out.println(element.getTagName());
		System.out.println(element.getAttribute("name"));
		
		return element.getAttribute("name");
	}
	
	public static String getHeader()
	{
		return getPageName();
	}
	
	public static String getData()
	{
		List<WebElement> elementList =  driver.findElementsByXPath("//UIATableCell");
		for(int i =0 ; i<elementList.size(); i++)
		{
			System.out.println(i);
			List<WebElement> elementCell =  elementList.get(i).findElements(By.xpath("/UIATableCell"));
			System.out.println("Chile cell size" + elementCell.size() );
			WebElement eleme = elementList.get(i);
			System.out.println(eleme.getSize());
			System.out.println(eleme.getLocation());
			System.out.println(eleme.getTagName());
			System.out.println(eleme.getAttribute("name"));
			System.out.println(eleme.getText());
			
		}
		
		return getPageName();
	}
	
}
