package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.qa.base.TestBase;

public class HomePage extends TestBase {
	WebDriver Browser;
	
	//Object repository or WebElements of page
	@FindBy(xpath="/html/body/div[1]/div[1]/div/a")
	public static WebElement LatchLogo;
	@FindBy (xpath="/html/body/div[1]/div[1]/div/nav/div/a[1]1")//Purposefully failing TestCase#3 by providing wrong xPath
	public static WebElement Header_Product;
	@FindBy (xpath="//a[text()='Design']")
	public static WebElement Header_Design;
	@FindBy (xpath="//a[text()='Partners']")
	public static WebElement Header_Partners;
	@FindBy(xpath="//a[text()='Support']")
	public static WebElement Header_Support ;
	@FindBy(xpath="//a[text()='Get Started']")
	public static WebElement Header_GetStarted;
	@FindBy(xpath="//a[text()='Careers']")
	public static WebElement Footerlink_Careers;
	@FindBy(xpath="//a[text()='Company']")
	public static WebElement Footerlink_Company;
	@FindBy(xpath="//a[text()='Press']")
	public static WebElement Footerlink_Press;
	@FindBy(xpath= "//a[text()='Security and Privacy']")
	public static WebElement Footerlink_SecurityandPrivacy;
	@FindBy (xpath="//a[text()='Contact Us']")
	public static WebElement Footerlink_ContactUs;
	@FindBy (how = How.XPATH, using="//div[@class='column-23 w-col w-col-5']")
	public static WebElement Footer_SocialMedia;
	
	@FindBy (className="div-block-63")
	public static WebElement ContactSales;
	
	//Constructor to initiate PageFactory
	public HomePage(WebDriver Driver){
		this.Browser=Driver;
		PageFactory.initElements(Browser, this);
	}
	
	//Methods can be performed on the HomePage.

	public Boolean checkHeaderLink( WebElement Header) {
		return TestBase.Wait(Header).isDisplayed();
	}
	
	public Boolean logoCheck() {
		return TestBase.Wait(LatchLogo).isDisplayed();
	}

	public Boolean verifyFooterlink(WebElement Footer) {
		return TestBase.Wait(Footer).isDisplayed();
	}
	
	public GetStartedPage navigationToGetStarted() {
		TestBase.Wait(Header_GetStarted).click();
		TestBase.Wait(ContactSales).click();
		return new GetStartedPage(Browser);
	}
	
	public String PageUrl() {
		return Browser.getCurrentUrl();
	}

	public void ClickLink(By LinkName) {
		if (Browser.findElement(LinkName).isDisplayed())
		Browser.findElement(LinkName).click();
		else Assert.assertEquals("unable to click the link "+LinkName, "User should be able to access the link");
	}

}
