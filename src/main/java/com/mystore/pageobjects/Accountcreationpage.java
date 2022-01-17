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
public class Accountcreationpage extends baseclass {

	@FindBy(xpath = "//h1[normalize-space()='Create an account']")
	WebElement formTitle;
	
	public Accountcreationpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountcreatepage()
	{
		return Action.isdisplayed(driver, formTitle);
	}
	
}
