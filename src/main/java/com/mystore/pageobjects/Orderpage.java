/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseclass;

/**
 * @author Rohit
 *
 */
public class Orderpage extends baseclass {

	

	@FindBy(xpath ="//td[@class='cart_unit']/span/span")
	WebElement unitprice;
	
	@FindBy(xpath ="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement proceedtocheckout;
	
	@FindBy(xpath ="//span[@id='total_price']")
	WebElement totalprice;
	
	
	
	public Orderpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public double getunitprice()
	{
		String unit =unitprice.getText();
		  String unitprice=  unit.replaceAll("[^a-zA-z0-9]", "");
		   double finalunitprice =  Double.parseDouble(unitprice);
		   return finalunitprice/100;
	}
	
	public double gettotalprice()
	{
		String total =totalprice.getText();
		  String toal1=  total.replaceAll("[^a-zA-z0-9]", "");
		   double finaltoalprice =  Double.parseDouble(toal1);
		   return finaltoalprice/100;
	}
	
	public Loginpage clickoncheckout()
	{
		Action.click(driver, proceedtocheckout);
		return new Loginpage();
	}
	
	
}
