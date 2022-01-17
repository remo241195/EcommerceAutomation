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
public class Addresspage extends baseclass {

	
	@FindBy(xpath ="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement proceedtocheckout;
	
	
	public Addresspage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public Shippingpage clickproceedtocheckout()
	{
		Action.click(driver, proceedtocheckout);
		return new Shippingpage();
	}
}
