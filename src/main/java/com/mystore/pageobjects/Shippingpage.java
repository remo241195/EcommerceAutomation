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
public class Shippingpage extends baseclass {

	
	@FindBy(xpath ="//input[@id='cgv']")
	WebElement tickbox;
	
	@FindBy(xpath ="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtocheckout;
	
	
	public Shippingpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public void clickonterms()
	{
		Action.click(driver, tickbox);
	}
	
	public Paymentpage clickonproceedtocheckout()
	{
		Action.click(driver, proceedtocheckout);
		return new Paymentpage();
	}
}
