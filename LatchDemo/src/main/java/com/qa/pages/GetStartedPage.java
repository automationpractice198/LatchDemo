package com.qa.pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class GetStartedPage extends TestBase{
	public WebDriver Browser;
	
	//Object repository for GetStarted page
	@FindBy(xpath="//select[@id='customer-type']//child::option")
	public static List<WebElement> CustomerType;
	@FindBy(id="first-name")
	public static WebElement FirstName;
	@FindBy(id="last-name")
	public static WebElement LastName;
	@FindBy(id="email")
	public static WebElement Email;
	@FindBy(id="phone")
	public static WebElement Phone;
	@FindBy(id="company-name")
	public static WebElement CompanyName;
	@FindBy (id ="total-units-portfolio")
	public static WebElement totalUnitsPortfolio;
	@FindBy(xpath="//select[@id='source']//child::option")
	public static List<WebElement> HowDidYouHearAboutUs;
	@FindBy(id="city")
	public static WebElement City;
	@FindBy(id="zipcode")
	public static WebElement Zip;
	@FindBy(id="additional-info")
	public static WebElement additional_info;
	@FindBy(xpath="//select[@id='total-units-project']//child::option")
	public static List<WebElement> UnitsInProject;
	@FindBy(xpath="//select[@id='state']//child::option")
	public static List<WebElement> state;
	@FindBy(xpath="//select[@id='timeline-month']//child::option")
	public static List<WebElement> month;
	@FindBy(xpath="//select[@id='timeline-year']//child::option")
	public static List<WebElement> year;
	
	//Constructor to initiate page factory
	public GetStartedPage(WebDriver driver){
		this.Browser=driver;
		 PageFactory.initElements(driver, this);
	}
	//Sample methods available for the page
	
	public void fillTextValueFor(WebElement element, String value) {
		TestBase.Wait(element).sendKeys(value);
	}
	
	public String GetURL() {
		return Browser.getCurrentUrl();
	}
	
	public String pageUrl() {
		return Browser.getCurrentUrl();
	}

	public  void selectOption(List<WebElement> element, int index) {
		TestBase.Wait(element.get(index)).click();
	}

}
