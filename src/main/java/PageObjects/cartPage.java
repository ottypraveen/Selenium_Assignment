package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericUtils.genericUtils;

public class cartPage extends genericUtils {
	
	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	private List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[.='Checkout']")
	private WebElement Checkoutbutton;
	
	By checkOutButton=By.xpath("//button[.='Checkout']");
	
	
	public void MatchProductsfromCart(String productName)
	{
			
		Boolean match = 	cartProducts.stream().anyMatch(s-> s.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
	}
	
	public void clickCheckOutButton()
	{
		waitforelementtoAppear(checkOutButton);
		Checkoutbutton.click();
	}
	
	
	
	
	
	
	

}
