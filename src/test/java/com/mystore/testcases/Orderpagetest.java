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
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.Searchresultpage;

/**
 * @author Rohit
 *
 */
public class Orderpagetest extends baseclass {

	Indexpage indexpage;
	Loginpage loginpage;
	Searchresultpage searchresultpage;
	Addtocartpage addtocartpage;
	Orderpage orderpage;
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
	public void verifypricetest() throws Exception
	{
		indexpage = new Indexpage();
		 searchresultpage =  indexpage.searchproduct("T-shirt");
		 addtocartpage = searchresultpage.clickonproduct();
		 addtocartpage.amendquantity("1");
		 addtocartpage.selectsize("S");
		  addtocartpage.clickaddtocart();
		  orderpage =   addtocartpage.clickincheckout();
		   double unitprice =   orderpage.getunitprice();
		   double totalprice =  orderpage.gettotalprice();
		   double totalexpectedproce = (unitprice*1)+2;
		   Assert.assertEquals(totalprice, totalexpectedproce);
		
		 
		 
	}
}
