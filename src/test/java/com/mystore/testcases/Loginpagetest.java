/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseclass;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.utility.Log;

/**
 * @author Rohit
 *
 */
public class Loginpagetest extends baseclass{

	Indexpage indexpage;
	Loginpage loginpage;
	Homepage homepage;
	
	@BeforeMethod
	public void setup()
	{
		launchapp();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void logintest()
	{
		indexpage = new Indexpage();
		Log.startTestCase("logintest");
		Log.info("user is going to click on signin");
		 loginpage = indexpage.clickonsignin();
		 Log.info("Enter username and password");
		  homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 String actualurl =  homepage.getcurrenturl();
		  String Expectedurl = "http://automationpractice.com/index.php?controller=my-account";
		  Log.info("verify if user is able to login");
		  Assert.assertEquals(actualurl, Expectedurl, "This is not a homepage url");
		  Log.info("login is success");
		  Log.endTestCase("logintest");
	}
}
