package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import com.qa.util.Util;
import com.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver Browser;
	public static WebEventListener evenListener;
	public static EventFiringWebDriver eBrowser;
	public static void BrowserSelection(String BrowserType, String NavURL) {
		switch (BrowserType) {
		case "Chrome":
			Browser = new ChromeDriver();
			Browser.navigate().to(NavURL);
			break;
		case "Mozilla":
			Browser = new FirefoxDriver();
			Browser.navigate().to(NavURL);
			break;
		}
		eBrowser=new EventFiringWebDriver(Browser);
		evenListener=new WebEventListener();
		eBrowser.register(evenListener);
		Browser = eBrowser;
	}

	public static void setUpBrowser(){
		try {
			Util.BrowserSelection(Util.configValue("Driver"), Util.configValue("NavURL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static WebElement Wait(WebElement WebElem) {
			WebDriverWait wait = new WebDriverWait(Util.Browser,10);
			WebElement e = wait.until(ExpectedConditions.visibilityOf((WebElement) WebElem));
			if (e!=null)
			return WebElem;
			else throw new IllegalAccessError();
	}
	
	@AfterSuite
	public static void closeDriver() {
		Browser.manage().deleteAllCookies();
		Browser.quit();
	}
	
}