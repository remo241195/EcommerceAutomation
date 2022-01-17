/**
 * 
 */
package com.mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseclass;

/**
 * @author Rohit
 *
 */
public class Addtocartpage extends baseclass {

	

	@FindBy(id ="//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(id ="//select[@id='group_1']")
	WebElement size;
	
	@FindBy(xpath ="//span[normalize-space()='Add to cart']")
	WebElement Addtocartbtn;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addtocartmsg;
	
	@FindBy(xpath ="//span[normalize-space()='Proceed to checkout']")
	WebElement proceedtocheckout;
	
	public Addtocartpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	
	public void amendquantity(String qty)
	{
		Action.type(quantity, qty);
	}
	
	public void selectsize(String value)
	{
		List<WebElement> options =  driver.findElements(By.xpath("//option"));
		System.out.println(options);
		Action.selectfromdropdown(options, value);
	}
	
	public void  clickaddtocart()
	{
		 Action.click(driver, Addtocartbtn);
	}
	public boolean validateaddtocartmsg() {
		 Action.waitforelement(addtocartmsg, "iselementvisible", 5);
		return Action.isdisplayed(driver, addtocartmsg);
	}
	
	public Orderpage clickincheckout() throws Exception {
	 Action.waitforelement(proceedtocheckout, "iselementvisible", 20);
		Action.jsclick(driver, proceedtocheckout);
		
		return new Orderpage();
	}
	
}
