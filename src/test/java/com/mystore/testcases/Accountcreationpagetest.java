/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseclass;
import com.mystore.pageobjects.Accountcreationpage;
import com.mystore.pageobjects.Homepage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.Loginpage;

/**
 * @author Rohit
 *
 */
public class Accountcreationpagetest extends baseclass {
	 Indexpage indexpage;
		Loginpage loginpage;
		Homepage homepage;
		Accountcreationpage accountcreationpage;
		
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
		public void verifycreateaccountpagetest()
		{
			indexpage = new Indexpage();
			loginpage = indexpage.clickonsignin();
			accountcreationpage =   loginpage.createnewAccount("abc@xyz.com");
			boolean flag =  accountcreationpage.validateAccountcreatepage();
			Assert.assertTrue(flag, "This is not a accountcreationpage");
		}
}
