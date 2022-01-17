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
public class Loginpage extends baseclass {

	
	
	@FindBy(id ="email")
	WebElement username;
	
	@FindBy(id ="passwd")
	WebElement password;
	
	@FindBy(id ="SubmitLogin")
	WebElement submitlogin;
	
	@FindBy(id ="SubmitCreate")
	WebElement createnewAcbtn;
	
	@FindBy(id ="email_create")
	WebElement EmailfornewAccount;
	
	public Loginpage()
	{
		 PageFactory.initElements(driver, this);
	}
	
	public Homepage login(String usname,String pwd)
	{
		Action.type(username, usname);
		Action.type(password, pwd);
		Action.click(driver, submitlogin);
		return new Homepage();
	}
	
	public Addresspage login1(String usname,String pwd)
	{
		Action.type(username, usname);
		Action.type(password, pwd);
		Action.click(driver, submitlogin);
		return new Addresspage();
	}
	
	
	public Accountcreationpage createnewAccount(String newemail)
	{
		Action.type(EmailfornewAccount, newemail);
		Action.click(driver, createnewAcbtn);
		return new Accountcreationpage();
	}
	
}
