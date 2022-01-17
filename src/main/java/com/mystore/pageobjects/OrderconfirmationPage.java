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
public class OrderconfirmationPage extends baseclass {


	@FindBy(xpath ="//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement confirmmsg;
	

	public OrderconfirmationPage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public String confirmmsg()
	{
		String confirmmsg1 = confirmmsg.getText();
		return confirmmsg1;
	}
	
	

	
}
