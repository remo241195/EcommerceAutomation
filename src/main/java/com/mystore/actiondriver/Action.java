package com.mystore.actiondriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mystore.base.baseclass;

public class Action extends baseclass {

	public static void click(WebDriver driver,WebElement locatorname)
	
	{
		Actions act = new Actions(driver);
				act.moveToElement(locatorname).click().perform();
	}
	
	
	public static boolean findelement(WebDriver driver,WebElement ele)
	{
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		}
		catch(Exception e)
			{
				flag = false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("Element is found");
			}
			else
			{
				System.out.println("Element is  not found");

			}
		}
		return flag;	
	}
	
	public static boolean isdisplayed(WebDriver driver,WebElement ele)
	{
		boolean flag = false;
		flag = findelement(driver,ele);
		if(flag)
		{
			flag = ele.isDisplayed();
			if(flag)
			{
				System.out.println("Element is displayed");
			}
			else
			{
				System.out.println("Element is not displayed");
			}
		}
		else
		{
			System.out.println("Element is not found");
		}
			
	return flag;
		
	}

	
	public static void selectfromdropdown(List<WebElement> options, String value)
	{
		boolean flag = false;
		Assert.assertTrue(options.size()>0, "There is no any options in the dropdown");
		for(WebElement ele : options)
		{
			System.out.println("options are "+ele.getText().trim());
			if(ele.getText().trim().equalsIgnoreCase(value));
			{
				ele.click();
				flag = true;
				break;
			}
		}
		
		if(flag == false)
		{
			Assert.fail("The value"+value+"is not available in the given dropdown");
		}
	}
	
	public static boolean jsclick(WebDriver driver,WebElement ele) throws Exception {
		boolean flag = false;
		try
		{
		JavascriptExecutor  jsr=  (JavascriptExecutor)driver;
		jsr.executeScript("arguments[0].click();", ele);
		
		flag = true;
		}catch(Exception e) {
			throw e;
		}
		finally
		{
			if(flag)
			System.out.println("click operation is performed");
			
		}
		 return flag;
	}

		
	public static void waitforelement(WebElement ele, String Condition, int Duration )
	{
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, Duration);
		
		switch(Condition)
		
		{
		case "iselementvisible":
		  wait.until(ExpectedConditions.visibilityOf(ele));
		  break;
		  
		case "iselementclickable":
		  wait.until(ExpectedConditions.elementToBeClickable(ele));
		  break;
		  
		  default : 
			  Assert.fail("options are not matching,checked expected conditions");
		     break;
		}
	}
	
	public static void checkifwindowalertpresent( String message)
	{
		boolean flag = false;
		try
		{
			Alert alert = driver.switchTo().alert();
			 flag = true;
			 Assert.assertEquals(alert.getText().trim(), message, "not the expected message");
			 
		} catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		Assert.assertTrue(flag);
	}
	   public void validateErrormessage(String expectederrormessage)
	   {
		     String Actualerrormessage =   driver.switchTo().alert().getText();
		     
		     Assert.assertEquals(Actualerrormessage, expectederrormessage,"Not the expected message");
		     
	   }
	   
	   public static void sleeper(int timeinmillisec)
	   {
		   try
		   {
			   Thread.sleep(timeinmillisec);
		   }
		   catch(InterruptedException e) {
			    e.printStackTrace();
	   }
	   }
	   
	   public static boolean type(WebElement ele,String text)
	   {
		   boolean flag = false;
		   try
		   {
			 flag=  ele.isDisplayed();
			   ele.clear();
			   ele.sendKeys(text);
			   flag = true;
		   }
		   catch(Exception e) {
			   System.out.println("Location not found");
			   flag = false;
		   }
		   finally {
			   if(flag)
			   {
				   System.out.println("successfully entered value");
			   }
			   else
			   {
				   System.out.println("unable to  entered value");
			   }
		   }
		   
		return flag;
		   
	   }
	
}


