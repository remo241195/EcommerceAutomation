/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.baseclass;
import com.mystore.pageobjects.Addresspage;
import com.mystore.pageobjects.Addtocartpage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.Loginpage;
import com.mystore.pageobjects.OrderconfirmationPage;
import com.mystore.pageobjects.Orderpage;
import com.mystore.pageobjects.Paymentpage;
import com.mystore.pageobjects.Searchresultpage;
import com.mystore.pageobjects.Shippingpage;
import com.mystore.pageobjects.ordersummary;

/**
 * @author Rohit
 *
 */
public class Endtoendtest extends baseclass{


	Indexpage indexpage;
	Loginpage loginpage;
	Searchresultpage searchresultpage;
	Addtocartpage addtocartpage;
	Orderpage orderpage;
	Addresspage addresspage;
	Shippingpage shippingpage;
	Paymentpage paymentpage;
	OrderconfirmationPage orderconfirmationpage;
	ordersummary Ordersummary;
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
	public void endtoendtest() throws Exception
	{
		indexpage = new Indexpage();
		 searchresultpage =  indexpage.searchproduct("T-shirt");
		 addtocartpage = searchresultpage.clickonproduct();
		 addtocartpage.amendquantity("1");
		 addtocartpage.selectsize("S");
		  addtocartpage.clickaddtocart();
		  orderpage =   addtocartpage.clickincheckout();
		   loginpage =       orderpage.clickoncheckout();
		     addresspage=  loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		      shippingpage= addresspage.clickproceedtocheckout();
		      shippingpage.clickonterms();
		       paymentpage= shippingpage.clickonproceedtocheckout();
		       Ordersummary=  paymentpage.clickonpaybybank();
		       orderconfirmationpage=  Ordersummary.clickonconfirmmyorder();
		     String Actual =   orderconfirmationpage.confirmmsg();
		     String expected = "Your order on My Store is complete.";
		     Assert.assertEquals(Actual, expected);
	}
}
