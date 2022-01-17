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
public class ordersummary extends baseclass {

	

	@FindBy(xpath ="//span[normalize-space()='I confirm my order']")
	WebElement confirmmyorderbtn;
	

	public ordersummary()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public OrderconfirmationPage clickonconfirmmyorder()
	{
		Action.click(driver, confirmmyorderbtn);
		return new OrderconfirmationPage();
	}
}
