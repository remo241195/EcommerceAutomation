/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseclass;
import com.mystore.pageobjects.Addtocartpage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.pageobjects.Searchresultpage;

/**
 * @author Rohit
 *
 */
public class AddtocartTest extends baseclass{

	Indexpage indexpage;
	Loginpage loginpage;
	Searchresultpage searchresultpage;
	Addtocartpage addtocartpage;
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
	public void verifyaddtocartTest()
	{
		 indexpage = new Indexpage();
		 searchresultpage =  indexpage.searchproduct("T-shirt");
		 
		 addtocartpage = searchresultpage.clickonproduct();
		 addtocartpage.amendquantity("2");
		 addtocartpage.selectsize("S");
		 addtocartpage.clickaddtocart();
		  boolean flag =  addtocartpage.validateaddtocartmsg();
		 Assert.assertTrue(flag);
	}
}
