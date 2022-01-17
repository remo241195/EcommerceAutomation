/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseclass;
import com.mystore.pageobjects.Indexpage;

/**
 * @author Rohit
 *
 */
public class Indextestpage extends baseclass {

	Indexpage indexpage;
	
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
	public void validatelogo() {
		
		indexpage = new Indexpage();
		Boolean flag = indexpage.validatelogo();
		Assert.assertTrue(flag, "No any logo found");
	}
	
	@Test
	public void validatetitle() {
		String actual = indexpage.getmystoretitle();
		Assert.assertEquals(actual, "My Store", "title has not been matched");
	}
}
