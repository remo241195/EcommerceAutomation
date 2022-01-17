package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.baseclass;

public class Indexpage extends baseclass {

	@FindBy(xpath ="//a[@class='login']")
	WebElement signin;
	

	@FindBy(xpath ="//img[@alt='My Store']")
	WebElement mystorelogo;
	
	@FindBy(xpath ="//button[@name='submit_search']")
	WebElement searchbutton;
	
	@FindBy(id ="search_query_top")
	WebElement searchproductbox;
	
	public Indexpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public Loginpage clickonsignin()
	{
		Action.click(driver, signin);
		
		return new Loginpage();
	}
	
	public boolean validatelogo()
	{
		return Action.isdisplayed(driver, mystorelogo);
			
	}
	
	public String getmystoretitle()
	{
		String mystoretitle = driver.getTitle();
		
		return  mystoretitle;
	}
	
	public Searchresultpage searchproduct(String productname)
	{
		Action.type(searchproductbox, productname);
		Action.click(driver, searchbutton);
		return new Searchresultpage();
	}
	
	
}
