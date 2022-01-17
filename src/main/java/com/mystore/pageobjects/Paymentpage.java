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
public class Paymentpage extends baseclass{

	

	@FindBy(xpath ="//a[@title='Pay by bank wire']")
	WebElement paybybankwire;
	
	@FindBy(xpath ="//a[@title='Pay by check.']")
	WebElement paybycheck;
	
	
	public Paymentpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public ordersummary clickonpaybybank()
	{
		Action.click(driver, paybybankwire);
		return new ordersummary();
	}
	
	public ordersummary clickonpaybycheck()
	{
		Action.click(driver, paybycheck);
		return new ordersummary();
	}
}
