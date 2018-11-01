package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.GetStartedPage;

public class GetStartedPageTestCases extends TestBase {
	GetStartedPage GetStarted;

	GetStartedPageTestCases() {
		//super.setUpBrowser();
		GetStarted = new GetStartedPage(Browser);
	}

	@Test(priority=6)
	public void FormFillUp() {
	if (GetStarted.pageUrl().equals("https://www.latch.com/order/get-started-2")) {
		GetStarted.selectOption(GetStartedPage.HowDidYouHearAboutUs, 1);
		GetStarted.fillTextValueFor(GetStartedPage.FirstName, "Maheshkumar");
		GetStarted.fillTextValueFor(GetStartedPage.LastName, "Palled");
		GetStarted.fillTextValueFor(GetStartedPage.Email,"Maheshkumar@gmail.com");
		GetStarted.fillTextValueFor(GetStartedPage.Phone,"1231231212");
		GetStarted.fillTextValueFor(GetStartedPage.totalUnitsPortfolio,"23");
		GetStarted.fillTextValueFor(GetStartedPage.CompanyName,"TEST");
		GetStarted.selectOption(GetStartedPage.CustomerType,2);
		GetStarted.fillTextValueFor(GetStartedPage.City,"Kansas City");
		GetStarted.selectOption(GetStartedPage.state,10);
		GetStarted.fillTextValueFor(GetStartedPage.Zip, "49001");
		GetStarted.selectOption(GetStartedPage.UnitsInProject, 2);
		GetStarted.selectOption(GetStartedPage.month, 3);
		GetStarted.selectOption(GetStartedPage.year, 4);
		GetStarted.fillTextValueFor(GetStartedPage.additional_info, "Building automation framework for front end");
		Assert.assertEquals("Form fill in is successful", "Form fill in is successful");
	}
	else Assert.assertEquals("Form fill in is successful", "Form fill in is not successful");
		
	}
}
