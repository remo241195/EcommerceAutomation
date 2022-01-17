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

/**
 * @author Rohit
 *
 */
public class Homepagetest extends baseclass  {
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
	public void wishlisttest() {
		indexpage = new Indexpage();
		loginpage = indexpage.clickonsignin();
		 homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		   boolean flag=   homepage.validatewishlists();
		   Assert.assertTrue(flag, "wishlist element is not found");
	}
	@Test
	public void orderhistoryanddetailstest() {
		indexpage = new Indexpage();
		loginpage = indexpage.clickonsignin();
		 homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		   Boolean flag=   homepage.validateorderhistory();
		   Assert.assertTrue(flag, "wishlist element is not found");
	}
}
