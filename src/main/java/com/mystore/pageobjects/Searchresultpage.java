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
public class Searchresultpage extends baseclass{

	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productresultpage;
	
	public Searchresultpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public boolean isproductavailable()
	{
		return Action.isdisplayed(driver, productresultpage);
	}
	
	public Addtocartpage clickonproduct()
	{
		Action.click(driver, productresultpage);
		return new Addtocartpage();
	}
}
