package com.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.TestBase;

public class TestListeners  extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
			try {
				Util.TakeScreenShot(result);
			} catch (Exception e) {
				System.out.println("Unable to take screenshot..! NEED INVESTIGATION");
			}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Util.TakeScreenShot(result);
		} catch (Exception e) {
			System.out.println("Unable to take screenshot..! NEED INVESTIGATION");
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("***Test execution started *** ");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("***Test execution Completed *** ");
	}

}
