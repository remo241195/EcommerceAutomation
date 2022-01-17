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
public class Homepage extends baseclass {

	@FindBy(xpath ="//span[normalize-space()='My wishlists']")
	WebElement Mywishlists;
	
	@FindBy(xpath ="//span[normalize-space()='//span[normalize-space()='Order history and details']']")
	WebElement orderhistory;
	
	public Homepage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public boolean validatewishlists()
	
	{
		return Action.isdisplayed(driver, Mywishlists);
	}
	
public boolean validateorderhistory()
	
	{
		return Action.isdisplayed(driver, orderhistory);
	}

 public String getcurrenturl()
 {
	 String homepageurl = driver.getCurrentUrl();
	   return homepageurl;
 }
	
	
}
