package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericUtils.genericUtils;

public class confirmationPage extends genericUtils {
	
	WebDriver driver;

	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//h1[normalize-space(.)='Thankyou for the order.']")
	private WebElement confirmationPage;
	
	By confMe=By.xpath("//h1[normalize-space(.)='Thankyou for the order.']");
	
	
	public void verifyConfirmationMessage(String message)
	{
		
		waitforelementtoAppear(confMe);
		String confirmMessage = confirmationPage.getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
	}
	
	

}
