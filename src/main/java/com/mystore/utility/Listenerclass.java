/**
 * 
 */
package com.mystore.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * @author Rohit
 *
 */
public class Listenerclass extends ExtentManager implements ITestListener{

	
	public void ontestStart(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
	}
	
	public void ontestsuccess(ITestResult result)
	{
		if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"Pass test case name is "+result.getName());
		}
	}
	
	public void ontestfail(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case failed", ExtentColor.RED));
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test case failed", ExtentColor.RED));
			}
	}
	
	public void ontestskip(ITestResult result)
	{
		 if (result.getStatus()==ITestResult.SKIP)
				{
					test.log(Status.SKIP,"Skipped test case is"+result.getName());
	}
	}
}
