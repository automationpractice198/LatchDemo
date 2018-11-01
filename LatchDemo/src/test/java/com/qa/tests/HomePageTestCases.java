package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.qa.base.TestBase;
import com.qa.pages.GetStartedPage;
import com.qa.pages.HomePage;

public class HomePageTestCases extends TestBase {
	HomePage home;
	GetStartedPage getStartPage;

	HomePageTestCases() {
		super.setUpBrowser();
		home = new HomePage(Browser);
	}

	@Test(groups = "Regression", priority = 1)
	public void CheckHomePage() {
		Assert.assertTrue(home.PageUrl().contentEquals("https://www.latch.com/"));
	}

	@Test(groups = "Regression", priority = 2)
	public void LogoCheck() {
		Assert.assertTrue(home.logoCheck());
	}

	@Test(groups = "Regression", priority = 3) //Purposefully failing the test case#3 by providing wrong xPath for Header_Product webElement
	public void verifyTheHeaderLinkPresense() {
		Boolean Product = home.checkHeaderLink(HomePage.Header_Product);
		Boolean Design = home.checkHeaderLink(HomePage.Header_Design);
		Boolean Partner = home.checkHeaderLink(HomePage.Header_Partners);
		Boolean Support = home.checkHeaderLink(HomePage.Header_Support);
		Boolean GetStarted = home.checkHeaderLink(HomePage.Header_GetStarted);
		if (Product == true && Design == true && Partner == true && Support == true && GetStarted == true)
			Assert.assertEquals("All the header links are present in the page",
					"All the header links are present in the page");
		else
			Assert.assertEquals("All the header links are not present in the page",
					"All the header links are present in the page");
	}

	@Test(groups = "Regression", priority = 4)
	public void verifyFooterLinkNavigation() {
		Boolean Career = home.verifyFooterlink(HomePage.Footerlink_Careers);
		Boolean Comapny = home.verifyFooterlink(HomePage.Footerlink_Company);
		Boolean Press = home.verifyFooterlink(HomePage.Footerlink_Press);
		Boolean SecurityAndPrivacy = home.verifyFooterlink(HomePage.Footerlink_SecurityandPrivacy);
		Boolean ContactUs = home.verifyFooterlink(HomePage.Footerlink_ContactUs);
		Boolean SocialMedia = home.verifyFooterlink(HomePage.Footer_SocialMedia);
		if (Career == true && Comapny == true && Press == true && SecurityAndPrivacy == true && ContactUs == true
				&& SocialMedia == true)
			Assert.assertEquals("All the footer links are present in the page",
					"All the footer links are present in the page");
		else
			Assert.assertEquals("All the footer links are not present in the page",
					"All the footer links are present in the page");
	}

	@Test(groups="Regression", priority=5)
	public void NavigationToGetStartedPage() {
		getStartPage = home.navigationToGetStarted();
	}
}
