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
import com.mystore.pageobjects.Searchresultpage;

/**
 * @author Rohit
 *
 */
public class Searchresultpagetest extends baseclass {

	Indexpage indexpage;
	Loginpage loginpage;
	Searchresultpage searchresultpage;
	
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
	public void productavailabilitytest() throws InterruptedException
	{
		 indexpage = new Indexpage();
		 searchresultpage =  indexpage.searchproduct("T-shirt");
		  boolean flag =  searchresultpage.isproductavailable();
		  Assert.assertTrue(flag, "product not found ");
		  Thread.sleep(3000);
	}
}
