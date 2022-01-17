package com.mystore.utility;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentSparkReporter htmlreporter;
	public static ExtentReports extent;
	public  static ExtentTest test;
	
	
	public  static void setextent() throws IOException
	{
		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReports/"+"report.html");
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/Extent-config.xml");
		
		extent =  new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname","My Host");
		extent.setSystemInfo("ProjectName", "MyStore");
		extent.setSystemInfo("Tester", "Rohit");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
						
	}
	

	public  static void endreport()
	{
		extent.flush();
	}
}
