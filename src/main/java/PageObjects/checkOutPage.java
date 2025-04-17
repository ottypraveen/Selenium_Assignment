package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import GenericUtils.genericUtils;

public class checkOutPage extends genericUtils {
	
	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css="[placeholder='Select Country']")
	private WebElement countryTextbox;
	
	
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	private WebElement desiredCountry;
	
	@FindBy(xpath="//a[normalize-space(.)='Place Order']")
	private WebElement placeOrder;
	
	By countrylistFindBy=By.cssSelector(".ta-results");
	
	
	
	public void placeOrder(String countryinput)
	{
		Actions a = new Actions(driver);
		a.sendKeys(countryTextbox, countryinput).build().perform();
		  waitforelementtoAppear(countrylistFindBy);
		  desiredCountry.click();
		  placeOrder.click();

	}
	

}
