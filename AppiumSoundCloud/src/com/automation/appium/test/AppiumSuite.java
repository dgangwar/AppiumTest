package com.automation.appium.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


public class AppiumSuite
{
  
   public static void main(String[] args) 
   {
      AppiumSuite suite = new AppiumSuite();
      suite.getTestNGSuite();
   }

   public void getTestNGSuite()
   {
	   XmlSuite suite = new XmlSuite();
	   suite.setName("TmpSuite");
	    
	   XmlTest test = new XmlTest(suite);
	   test.setName("TmpTest");
	   List<XmlClass> classes = new ArrayList<XmlClass>();
	   classes.add(new XmlClass("com.automation.appium.test.TestGeneral"));
	   classes.add(new XmlClass("com.automation.appium.test.TestStorage"));
	   test.setXmlClasses(classes) ;
	   List<XmlSuite> suites = new ArrayList<XmlSuite>();
	   suites.add(suite);
	   TestNG tng = new TestNG();
	   tng.setXmlSuites(suites);
	   tng.run();

   }
}
